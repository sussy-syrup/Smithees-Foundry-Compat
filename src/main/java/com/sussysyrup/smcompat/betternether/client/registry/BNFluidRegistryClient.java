package com.sussysyrup.smcompat.betternether.client.registry;

import com.sussysyrup.smitheesfoundry.api.fluid.ApiMoltenFluidRegistry;

import java.awt.*;

public class BNFluidRegistryClient {

    public static void clientInit()
    {
        ApiMoltenFluidRegistry.getInstance().registerColours("molten_cincinnasite",
                new Color(150, 110, 11),
                new Color(170, 120, 19),
                new Color(202, 124,21),
                new Color(245, 138, 11),
                new Color(253, 167, 42),
                new Color(255, 199, 104),
                new Color(255, 205, 120));
    }

}
