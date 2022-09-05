package com.sussysyrup.smcompat.betterend.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.casting.ApiBlockCastingRegistry;
import com.sussysyrup.smitheesfoundry.api.casting.ApiCastingRegistry;
import net.minecraft.util.Identifier;
import ru.betterend.BetterEnd;

public class BECastingRegistry {

    public static void initialise()
    {
        ApiCastingRegistry.getInstance().addIdentifierNugget(new Identifier(Main.MODID, "molten_thallasium"), BetterEnd.makeID("thallasium_nugget"));
        ApiCastingRegistry.getInstance().addIdentifierIngot(new Identifier(Main.MODID, "molten_thallasium"), BetterEnd.makeID("thallasium_ingot"));
        ApiBlockCastingRegistry.getInstance().addIdentifierBlock(new Identifier(Main.MODID, "molten_thallasium"), BetterEnd.makeID("thallasium_block"));

        ApiCastingRegistry.getInstance().addIdentifierNugget(new Identifier(Main.MODID, "molten_terminite"), BetterEnd.makeID("terminite_nugget"));
        ApiCastingRegistry.getInstance().addIdentifierIngot(new Identifier(Main.MODID, "molten_terminite"), BetterEnd.makeID("terminite_ingot"));
        ApiBlockCastingRegistry.getInstance().addIdentifierBlock(new Identifier(Main.MODID, "molten_terminite"), BetterEnd.makeID("terminite_block"));

        ApiCastingRegistry.getInstance().addIdentifierIngot(new Identifier(Main.MODID, "molten_aeternium"), BetterEnd.makeID("aeternium_ingot"));
        ApiBlockCastingRegistry.getInstance().addIdentifierBlock(new Identifier(Main.MODID, "molten_aeternium"), BetterEnd.makeID("aeternium_block"));
    }

}
