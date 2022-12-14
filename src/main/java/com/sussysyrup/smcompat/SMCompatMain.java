package com.sussysyrup.smcompat;

import com.sussysyrup.smcompat.betterend.SMBetterEnd;
import com.sussysyrup.smcompat.betternether.SMBetterNether;
import com.sussysyrup.smcompat.chisel.SMChisel;
import com.sussysyrup.smitheesfoundry.api.entrypoints.CommonSetup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMCompatMain implements CommonSetup {

    public static final Logger COMPATLOG = LoggerFactory.getLogger("smitheesfoundry-compat");
    public static final String MODID = "smcompat";

    @Override
    public void init() {
        if(SMCompatPreLaunch.betterEnd)
        {
            SMBetterEnd.initialise();
        }
        if(SMCompatPreLaunch.betterNether)
        {
            SMBetterNether.initialise();
        }
        if(SMCompatPreLaunch.chisel)
        {
            SMChisel.initialise();
        }
    }
}
