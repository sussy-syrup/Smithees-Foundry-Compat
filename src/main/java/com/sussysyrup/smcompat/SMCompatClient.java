package com.sussysyrup.smcompat;

import com.sussysyrup.smcompat.betterend.SMBetterEndClient;
import com.sussysyrup.smcompat.betternether.SMBetterNetherClient;
import com.sussysyrup.smcompat.chisel.SMChiselClient;
import com.sussysyrup.smitheesfoundry.api.entrypoints.ClientSetup;
import net.fabricmc.api.ClientModInitializer;

public class SMCompatClient implements ClientSetup {
    @Override
    public void init() {
        if (SMCompatPreLaunch.betterEnd) {
            SMBetterEndClient.initialise();
        }
        if (SMCompatPreLaunch.betterNether) {
            SMBetterNetherClient.initialise();
        }
        if (SMCompatPreLaunch.chisel)
        {
            SMChiselClient.initialise();
        }
    }
}
