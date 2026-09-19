package com.hbmax.energy;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.energy.IEnergyStorage;

import java.util.*;

public class EnergyNet {

    private final Set<BlockPos> cables = new HashSet<>();
    private final Set<BlockPos> connectedMachines = new HashSet<>();
    private boolean valid = true;

    // ── API ────────────────────────────────────────────────────────────────

    public void addCable(BlockPos pos) {
        cables.add(pos.immutable());
    }

    public void removeCable(BlockPos pos) {
        cables.remove(pos);
    }

    public void addMachine(BlockPos pos) {
        connectedMachines.add(pos.immutable());
    }

    public void removeMachine(BlockPos pos) {
        connectedMachines.remove(pos);
    }

    public boolean containsCable(BlockPos pos) {
        return cables.contains(pos);
    }

    public Set<BlockPos> getCables() {
        return Collections.unmodifiableSet(cables);
    }

    public Set<BlockPos> getConnectedMachines() {
        return Collections.unmodifiableSet(connectedMachines);
    }

    /**
     * Передать энергию всем потребителям в сети.
     * Возвращает сколько энергии было реально передано.
     */
    public int distribute(Level level, int amount) {
        if (amount <= 0 || connectedMachines.isEmpty()) return 0;

        // Собираем всех потребителей
        List<IEnergyStorage> consumers = new ArrayList<>();

        for (BlockPos machinePos : connectedMachines) {
            BlockEntity be = level.getBlockEntity(machinePos);
            if (be == null) continue;

            // Проверяем все стороны
            for (Direction dir : Direction.values()) {
                var opt = be.getCapability(ForgeCapabilities.ENERGY, dir);
                opt.ifPresent(storage -> {
                    if (storage.canReceive() && !consumers.contains(storage)) {
                        consumers.add(storage);
                    }
                });
            }
        }

        if (consumers.isEmpty()) return 0;

        // Распределяем энергию поровну между всеми потребителями
        int perConsumer = amount / consumers.size();
        if (perConsumer < 1) perConsumer = 1;

        int totalSent = 0;
        int remaining = amount;

        for (IEnergyStorage consumer : consumers) {
            if (remaining <= 0) break;

            int toSend = Math.min(perConsumer, remaining);
            int accepted = consumer.receiveEnergy(toSend, false);
            totalSent += accepted;
            remaining -= accepted;
        }

        return totalSent;
    }

    public void destroy() {
        valid = false;
        cables.clear();
        connectedMachines.clear();
    }

    public boolean isValid() {
        return valid;
    }

    public int size() {
        return cables.size();
    }

    // ── Объединение сетей ──────────────────────────────────────────────────

    public void mergeWith(EnergyNet other) {
        if (other == this) return;
        cables.addAll(other.cables);
        connectedMachines.addAll(other.connectedMachines);
        other.destroy();
    }
}