package com.sussysyrup.smcompat.betterend;

import com.sussysyrup.smcompat.betterend.registry.*;

public class SMBetterEnd {

    public static void initialise()
    {
        BEFluidRegistry.main();
        BEMaterialRegistry.initialise();
        BESmelteryRegistry.initialise();
        BECastingRegistry.initialise();
        BEVariationRegistry.initialise();
        BEAlloyRegistry.initialise();
    }

}
