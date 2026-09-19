package com.hbmax.bridge;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

/**
 * HBMaxBridge — асинхронный TCP-клиент для связи с C++ ядром.
 *
 * Протокол (бинарный, little-endian):
 *   [4 bytes: task_id]
 *   [2 bytes: task_type]
 *   [4 bytes: payload_size]
 *   [N bytes: payload]
 *
 * Использование:
 *   HBMaxBridge bridge = HBMaxBridge.getInstance();
 *   bridge.connect();
 *   bridge.sendTask(TaskType.PING, new byte[0], response -> { ... });
 */
public class HBMaxBridge {

    private static final Logger LOGGER = LogManager.getLogger("HBMaxBridge");

    // ── Настройки ──────────────────────────────────────────────────────────────
    private static final String HOST    = "127.0.0.1";
    private static final int    PORT    = 25566;
    private static final int    TIMEOUT = 3000; // ms на коннект

    // ── Singleton ──────────────────────────────────────────────────────────────
    private static final HBMaxBridge INSTANCE = new HBMaxBridge();
    public static HBMaxBridge getInstance() { return INSTANCE; }

    // ── Состояние ──────────────────────────────────────────────────────────────
    private Socket           socket;
    private DataOutputStream out;
    private DataInputStream  in;

    private final AtomicBoolean connected  = new AtomicBoolean(false);
    private final AtomicInteger taskIdGen  = new AtomicInteger(1);

    // Ожидающие ответа задачи: task_id → callback
    private final ConcurrentHashMap<Integer, Consumer<byte[]>> pendingTasks = new ConcurrentHashMap<>();

    // Поток чтения ответов от C++ ядра
    private Thread readerThread;

    // Очередь задач на отправку (чтобы не блокировать game thread)
    private final BlockingQueue<OutgoingTask> sendQueue = new LinkedBlockingQueue<>();
    private Thread writerThread;

    // ── Типы задач ─────────────────────────────────────────────────────────────
    public static final class TaskType {
        public static final short PING           = 0x0001;
        public static final short REACTOR_TICK   = 0x0010;
        public static final short EXPLOSION_CALC = 0x0020;
        public static final short RADIATION_SPREAD = 0x0030;

        private TaskType() {}
    }

    // ── Внутренний класс задачи ────────────────────────────────────────────────
    private record OutgoingTask(int id, short type, byte[] payload, Consumer<byte[]> callback) {}

    // ── Приватный конструктор ──────────────────────────────────────────────────
    private HBMaxBridge() {}

    // ══════════════════════════════════════════════════════════════════════════
    //  PUBLIC API
    // ══════════════════════════════════════════════════════════════════════════

    /**
     * Подключиться к C++ ядру. Вызывать при старте мода.
     * Не блокирует — коннект в отдельном потоке.
     */
    public void connect() {
        if (connected.get()) {
            LOGGER.warn("[HBMaxBridge] Уже подключён, пропускаем.");
            return;
        }

        Thread connectThread = new Thread(() -> {
            try {
                LOGGER.info("[HBMaxBridge] Подключаюсь к C++ ядру {}:{}...", HOST, PORT);
                socket = new Socket();
                socket.connect(new InetSocketAddress(HOST, PORT), TIMEOUT);
                socket.setTcpNoDelay(true); // важно — убирает задержку Nagle

                out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                in  = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

                connected.set(true);
                LOGGER.info("[HBMaxBridge] ✓ Подключён к C++ ядру!");

                startReaderThread();
                startWriterThread();

            } catch (IOException e) {
                LOGGER.error("[HBMaxBridge] ✗ Не удалось подключиться: {}", e.getMessage());
                connected.set(false);
            }
        }, "HBMax-Connect");

        connectThread.setDaemon(true);
        connectThread.start();
    }

    /**
     * Отправить задачу асинхронно.
     *
     * @param taskType  тип из TaskType.*
     * @param payload   данные задачи (можно new byte[0])
     * @param callback  вызовется в reader-потоке когда придёт ответ
     * @return task_id или -1 если не подключён
     */
    public int sendTask(short taskType, byte[] payload, Consumer<byte[]> callback) {
        if (!connected.get()) {
            LOGGER.warn("[HBMaxBridge] Не подключён, задача проигнорирована (type={})", taskType);
            return -1;
        }

        int id = taskIdGen.getAndIncrement();
        pendingTasks.put(id, callback != null ? callback : (r) -> {});
        sendQueue.offer(new OutgoingTask(id, taskType, payload, callback));
        return id;
    }

    /**
     * PING — быстрая проверка соединения.
     * @param onPong вызовется с ответом ядра
     */
    public void ping(Consumer<String> onPong) {
        sendTask(TaskType.PING, new byte[0], response -> {
            String msg = new String(response).trim();
            LOGGER.info("[HBMaxBridge] PONG: {}", msg);
            if (onPong != null) onPong.accept(msg);
        });
    }

    /** Подключён ли мост прямо сейчас */
    public boolean isConnected() {
        return connected.get();
    }

    /** Отключиться (вызывать при выгрузке мода) */
    public void disconnect() {
        connected.set(false);
        try {
            if (socket != null) socket.close();
        } catch (IOException ignored) {}

        if (readerThread != null) readerThread.interrupt();
        if (writerThread != null) writerThread.interrupt();

        pendingTasks.clear();
        sendQueue.clear();
        LOGGER.info("[HBMaxBridge] Отключён.");
    }

    // ══════════════════════════════════════════════════════════════════════════
    //  ВНУТРЕННИЕ ПОТОКИ
    // ══════════════════════════════════════════════════════════════════════════

    /** Поток записи — берёт из sendQueue и отправляет в сокет */
    private void startWriterThread() {
        writerThread = new Thread(() -> {
            while (connected.get() && !Thread.currentThread().isInterrupted()) {
                try {
                    OutgoingTask task = sendQueue.poll(500, TimeUnit.MILLISECONDS);
                    if (task == null) continue;

                    writePacket(task.id(), task.type(), task.payload());

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } catch (IOException e) {
                    LOGGER.error("[HBMaxBridge] Ошибка записи: {}", e.getMessage());
                    handleDisconnect();
                    break;
                }
            }
        }, "HBMax-Writer");

        writerThread.setDaemon(true);
        writerThread.start();
    }

    /** Поток чтения — читает пакеты от C++ и вызывает callbacks */
    private void startReaderThread() {
        readerThread = new Thread(() -> {
            while (connected.get() && !Thread.currentThread().isInterrupted()) {
                try {
                    // Читаем заголовок: task_id(4) + task_type(2) + payload_size(4) = 10 байт
                    byte[] header = new byte[10];
                    in.readFully(header);

                    ByteBuffer buf = ByteBuffer.wrap(header).order(ByteOrder.LITTLE_ENDIAN);
                    int   taskId      = buf.getInt();
                    short taskType    = buf.getShort();
                    int   payloadSize = buf.getInt();

                    // Читаем payload
                    byte[] payload = new byte[payloadSize];
                    if (payloadSize > 0) in.readFully(payload);

                    // Находим и вызываем callback
                    Consumer<byte[]> callback = pendingTasks.remove(taskId);
                    if (callback != null) {
                        callback.accept(payload);
                    } else {
                        LOGGER.warn("[HBMaxBridge] Получен ответ на неизвестный task_id={}", taskId);
                    }

                } catch (EOFException e) {
                    LOGGER.info("[HBMaxBridge] C++ ядро закрыло соединение.");
                    handleDisconnect();
                    break;
                } catch (IOException e) {
                    if (connected.get()) {
                        LOGGER.error("[HBMaxBridge] Ошибка чтения: {}", e.getMessage());
                        handleDisconnect();
                    }
                    break;
                }
            }
        }, "HBMax-Reader");

        readerThread.setDaemon(true);
        readerThread.start();
    }

    /** Записать пакет в сокет (little-endian) */
    private void writePacket(int taskId, short taskType, byte[] payload) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(10 + payload.length).order(ByteOrder.LITTLE_ENDIAN);
        buf.putInt(taskId);
        buf.putShort(taskType);
        buf.putInt(payload.length);
        buf.put(payload);

        synchronized (out) {
            out.write(buf.array());
            out.flush();
        }
    }

    private void handleDisconnect() {
        connected.set(false);
        pendingTasks.clear();
        LOGGER.warn("[HBMaxBridge] Соединение разорвано. Переподключение не реализовано пока.");
        // TODO: авто-реконнект с задержкой
    }
}
