package com.sussysyrup.smcompat;

import com.sussysyrup.smcompat.betterend.SMBetterEnd;
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
    }
}
