package com.sussysyrup.smcompat.betternether.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.casting.ApiCastingRegistry;
import net.minecraft.util.Identifier;
import paulevs.betternether.BetterNether;

public class BNCastingRegistry {

    public static void initialise()
    {
        ApiCastingRegistry.getInstance().addIdentifierIngot(new Identifier(Main.MODID, "molten_cincinnasite"), BetterNether.makeID("cincinnasite_ingot"));
    }

}
