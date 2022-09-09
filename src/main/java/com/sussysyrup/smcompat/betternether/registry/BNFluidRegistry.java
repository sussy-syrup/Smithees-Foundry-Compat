package com.sussysyrup.smcompat.betternether.registry;

import com.sussysyrup.smitheesfoundry.api.fluid.ApiMoltenFluidRegistry;
import com.sussysyrup.smitheesfoundry.api.fluid.FluidProperties;

public class BNFluidRegistry {

    public static void initialise()
    {
        ApiMoltenFluidRegistry.getInstance().registerCreateFluid("molten_cincinnasite", new FluidProperties("molten_cincinnasite", "cincinnasite", 315));
    }

}
