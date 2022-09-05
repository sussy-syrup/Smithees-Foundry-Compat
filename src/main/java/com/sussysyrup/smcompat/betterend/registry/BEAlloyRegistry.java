package com.sussysyrup.smcompat.betterend.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.fluid.ApiAlloyRegistry;
import net.minecraft.util.Identifier;

public class BEAlloyRegistry {

    public static void initialise()
    {
        ApiAlloyRegistry.getInstance().addAlloy(new Identifier(Main.MODID, "molten_terminite"), 20,
                new Identifier[]{new Identifier(Main.MODID, "molten_thallasium"),
                        new Identifier(Main.MODID, "molten_enderdust")}, new long[]{10,10});

        ApiAlloyRegistry.getInstance().addAlloy(new Identifier(Main.MODID, "molten_aeternium"), 20,
                new Identifier[]{new Identifier(Main.MODID, "molten_terminite"),
                        new Identifier(Main.MODID, "molten_netherite")}, new long[]{10,10});
    }

}
