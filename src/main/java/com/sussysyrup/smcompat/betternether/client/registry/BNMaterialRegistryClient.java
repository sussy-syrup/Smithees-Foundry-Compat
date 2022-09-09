package com.sussysyrup.smcompat.betternether.client.registry;

import com.sussysyrup.smitheesfoundry.api.material.ApiMaterialRegistry;

import java.awt.*;

public class BNMaterialRegistryClient {

    public static void clientInit()
    {
        ApiMaterialRegistry.getInstance().registerColours("cincinnasite",
                new Color(79, 47, 11),
                new Color(83, 51, 19),
                new Color(202, 124,21),
                new Color(245, 138, 11),
                new Color(253, 167, 42),
                new Color(255, 199, 104),
                new Color(255, 205, 120));

        ApiMaterialRegistry.getInstance().registerColours("netherruby",
                new Color(76, 0, 11),
                new Color(99, 1, 14),
                new Color(130, 4,20),
                new Color(147, 0, 21),
                new Color(160, 45, 59),
                new Color(198, 53, 71),
                new Color(240, 116, 127));
    }

}
