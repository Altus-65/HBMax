package com.hbmax.energy;

import java.util.List;
import java.util.Map;

public interface IEnergyConductor extends IEnergyConnector {
    IPowerNet getPowerNet();
    void setPowerNet(IPowerNet net);
    int getIdentity();
    boolean hasProxies();
    List<Integer> getProxies();
    void reevaluate(Map<Integer, IEnergyConductor> links, Map<Integer, Integer> proxies);
}