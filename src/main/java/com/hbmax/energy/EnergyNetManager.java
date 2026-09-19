package com.hbmax.energy;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import java.util.*;

/**
 * EnergyNetManager — управляет всеми сетями в уровне.
 * Хранится per-level через SavedData или статически (для simplicity).
 */
public class EnergyNetManager {

    // level dimension → map(pos → net)
    private static final Map<String, Map<BlockPos, EnergyNet>> LEVEL_NETS = new HashMap<>();

    private static Map<BlockPos, EnergyNet> getNets(Level level) {
        String key = level.dimension().location().toString();
        return LEVEL_NETS.computeIfAbsent(key, k -> new HashMap<>());
    }

    // ── Получить сеть по позиции ───────────────────────────────────────────

    public static EnergyNet getNet(Level level, BlockPos pos) {
        return getNets(level).get(pos);
    }

    // ── Добавить провод ────────────────────────────────────────────────────

    public static void addCable(Level level, BlockPos pos) {
        Map<BlockPos, EnergyNet> nets = getNets(level);

        // Собираем все соседние сети
        List<EnergyNet> neighborNets = new ArrayList<>();
        for (Direction dir : Direction.values()) {
            BlockPos neighbor = pos.relative(dir);
            EnergyNet net = nets.get(neighbor);
            if (net != null && !neighborNets.contains(net)) {
                neighborNets.add(net);
            }
        }

        EnergyNet myNet;

        if (neighborNets.isEmpty()) {
            // Новая изолированная сеть
            myNet = new EnergyNet();
        } else {
            // Берём первую сеть и сливаем остальные в неё
            myNet = neighborNets.get(0);
            for (int i = 1; i < neighborNets.size(); i++) {
                EnergyNet other = neighborNets.get(i);
                // переназначаем все позиции старой сети на новую
                for (BlockPos cablePos : other.getCables()) {
                    nets.put(cablePos, myNet);
                }
                myNet.mergeWith(other);
            }
        }

        myNet.addCable(pos);
        nets.put(pos, myNet);

        // Проверяем соседей на машины
        checkNeighborMachines(level, pos, myNet, true);
    }

    // ── Удалить провод ─────────────────────────────────────────────────────

    public static void removeCable(Level level, BlockPos pos) {
        Map<BlockPos, EnergyNet> nets = getNets(level);
        EnergyNet net = nets.remove(pos);
        if (net == null) return;

        net.removeCable(pos);

        // Пересчитываем сеть — разбиваем на независимые части
        rebuildNets(level, net, nets);
    }

    // ── Пересчёт сети после удаления ──────────────────────────────────────

    private static void rebuildNets(Level level, EnergyNet oldNet,
                                    Map<BlockPos, EnergyNet> nets) {
        Set<BlockPos> remaining = new HashSet<>(oldNet.getCables());
        oldNet.destroy();

        // BFS для каждого несвязанного кабеля
        while (!remaining.isEmpty()) {
            BlockPos start = remaining.iterator().next();
            EnergyNet newNet = new EnergyNet();

            Queue<BlockPos> queue = new LinkedList<>();
            queue.add(start);
            Set<BlockPos> visited = new HashSet<>();

            while (!queue.isEmpty()) {
                BlockPos current = queue.poll();
                if (!visited.add(current)) continue;
                if (!remaining.contains(current)) continue;

                newNet.addCable(current);
                nets.put(current, newNet);
                remaining.remove(current);

                for (Direction dir : Direction.values()) {
                    BlockPos neighbor = current.relative(dir);
                    if (remaining.contains(neighbor)) {
                        queue.add(neighbor);
                    }
                }

            // Подключаем машины к новой сети
            for (BlockPos cablePos : newNet.getCables()) {
                checkNeighborMachines(level, cablePos, newNet, true);
            }
            }
        }
    }

    // ── Проверить соседей на машины ────────────────────────────────────────

    // В методе checkNeighborMachines добавьте проверку, что блок не провод
    public static void checkNeighborMachines(Level level, BlockPos cablePos,
                                             EnergyNet net, boolean add) {
        for (Direction dir : Direction.values()) {
            BlockPos neighbor = cablePos.relative(dir);

            // Если сосед — провод, пропускаем (он будет в сети отдельно)
            if (getNets(level).containsKey(neighbor)) continue;

            BlockEntity be = level.getBlockEntity(neighbor);
            if (be == null) continue;

            // Проверяем, есть ли у блока энергия
            boolean hasEnergy = be.getCapability(
                    ForgeCapabilities.ENERGY,
                    dir.getOpposite()
            ).isPresent();

            if (hasEnergy) {
                if (add) {
                    net.addMachine(neighbor);
                    System.out.println("Added machine at " + neighbor + " to network"); // отладка
                } else {
                    net.removeMachine(neighbor);
                    System.out.println("Removed machine at " + neighbor + " from network"); // отладка
                }
            }
        }
    }

    // ── Очистка при выгрузке уровня ────────────────────────────────────────

    public static void clearLevel(Level level) {
        String key = level.dimension().location().toString();
        Map<BlockPos, EnergyNet> nets = LEVEL_NETS.remove(key);
        if (nets != null) nets.values().forEach(EnergyNet::destroy);
    }
}