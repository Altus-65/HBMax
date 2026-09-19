package com.hbmax.energy;

import net.minecraft.world.level.block.entity.BlockEntity;

import java.util.*;

public class PowerNet implements IPowerNet {

    private boolean valid = true;
    private final Map<Integer, IEnergyConductor> links = new HashMap<>();
    private final List<IEnergyConnector> subscribers = new ArrayList<>();
    private long totalTransfer = 0;

    @Override
    public void joinNetworks(IPowerNet network) {
        if (network == this) return;
        for (IEnergyConductor conductor : network.getLinks()) {
            joinLink(conductor);
        }
        network.getLinks().clear();
        for (IEnergyConnector connector : network.getSubscribers()) {
            subscribe(connector);
        }
        network.destroy();
    }

    @Override
    public IPowerNet joinLink(IEnergyConductor conductor) {
        if (conductor.getPowerNet() != null) {
            conductor.getPowerNet().leaveLink(conductor);
        }
        conductor.setPowerNet(this);
        links.put(conductor.getIdentity(), conductor);
        return this;
    }

    @Override
    public void leaveLink(IEnergyConductor conductor) {
        conductor.setPowerNet(null);
        links.remove(conductor.getIdentity());
    }

    @Override
    public void subscribe(IEnergyConnector connector) {
        if (!subscribers.contains(connector)) {
            subscribers.add(connector);
        }
    }

    @Override
    public void unsubscribe(IEnergyConnector connector) {
        subscribers.remove(connector);
    }

    @Override
    public boolean isSubscribed(IEnergyConnector connector) {
        return subscribers.contains(connector);
    }

    @Override
    public void destroy() {
        valid = false;
        subscribers.clear();
        for (IEnergyConductor link : links.values()) {
            link.setPowerNet(null);
        }
        links.clear();
    }

    @Override
    public void reevaluate() {
        if (!valid) return;
        // Простая переоценка
        for (IEnergyConductor link : getLinks()) {
            if (link == null) continue;
            if (link.getWorld() == null) continue;
            if (link.getWorld().getBlockEntity(link.getPosition()) == null) {
                leaveLink(link);
            }
        }
    }

    @Override
    public boolean isValid() {
        return valid;
    }

    @Override
    public List<IEnergyConductor> getLinks() {
        return new ArrayList<>(links.values());
    }

    @Override
    public List<IEnergyConnector> getSubscribers() {
        return new ArrayList<>(subscribers);
    }

    @Override
    public long transferPower(long power) {
        if (power <= 0 || subscribers.isEmpty()) return power;

        // Очистка мёртвых подписчиков
        subscribers.removeIf(connector -> {
            if (connector == null) return true;
            if (connector.getWorld() == null) return true;
            if (connector.getWorld().getBlockEntity(connector.getPosition()) == null) return true;
            return false;
        });

        long remaining = power;
        long transferred = 0;

        // Сортируем по приоритету
        IEnergyConnector.ConnectionPriority[] priorities = {
                IEnergyConnector.ConnectionPriority.HIGH,
                IEnergyConnector.ConnectionPriority.NORMAL,
                IEnergyConnector.ConnectionPriority.LOW
        };

        for (IEnergyConnector.ConnectionPriority priority : priorities) {
            List<IEnergyConnector> prioritySubs = new ArrayList<>();
            for (IEnergyConnector sub : subscribers) {
                if (sub.getPriority() == priority) {
                    prioritySubs.add(sub);
                }
            }

            if (prioritySubs.isEmpty()) continue;

            // Собираем веса
            List<Long> weights = new ArrayList<>();
            long totalWeight = 0;
            for (IEnergyConnector sub : prioritySubs) {
                long weight = sub.getTransferWeight();
                weights.add(weight);
                totalWeight += weight;
            }

            if (totalWeight == 0) continue;

            // Распределяем
            for (int i = 0; i < prioritySubs.size(); i++) {
                IEnergyConnector sub = prioritySubs.get(i);
                long weight = weights.get(i);
                long toSend = (long) Math.floor((double) weight / totalWeight * remaining);
                if (toSend > 0) {
                    long sent = sub.transferPower(toSend);
                    remaining -= sent;
                    transferred += sent;

                    // Обновляем TileEntity
                    if (sub instanceof BlockEntity be) {
                        be.setChanged();
                    }
                }
            }
        }

        totalTransfer += transferred;
        return remaining;
    }

    @Override
    public long getTotalTransfer() {
        return totalTransfer;
    }
}