package com.hbmax.energy;

import java.util.List;

public interface IPowerNet {
    void joinNetworks(IPowerNet network);
    IPowerNet joinLink(IEnergyConductor conductor);
    void leaveLink(IEnergyConductor conductor);
    void subscribe(IEnergyConnector connector);
    void unsubscribe(IEnergyConnector connector);
    boolean isSubscribed(IEnergyConnector connector);
    void destroy();
    void reevaluate();
    boolean isValid();
    List<IEnergyConductor> getLinks();
    List<IEnergyConnector> getSubscribers();
    long transferPower(long power);
    long getTotalTransfer();
}