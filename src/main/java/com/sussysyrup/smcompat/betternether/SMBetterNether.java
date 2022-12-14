package com.sussysyrup.smcompat.betternether;

import com.sussysyrup.smcompat.betternether.registry.*;

public class SMBetterNether {

    public static void initialise()
    {
        BNVariationRegistry.initialise();
        BNMaterialRegistry.initialise();
        BNFluidRegistry.initialise();
        BNSmelteryRegistry.initialise();
        BNCastingRegistry.initialise();
    }

}
