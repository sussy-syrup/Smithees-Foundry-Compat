package com.sussysyrup.smcompat.betternether.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.block.ApiVariationRegistry;
import com.sussysyrup.smitheesfoundry.api.block.VariationWoodRecord;
import net.minecraft.util.Identifier;
import paulevs.betternether.BetterNether;

public class BNVariationRegistry {

    public static void initialise()
    {
        quickReg(new Identifier(Main.MODID, "stalagnate"), BetterNether.makeID("stalagnate"));
        quickReg2(new Identifier(Main.MODID, "willow"), BetterNether.makeID("willow"));
        quickReg3(new Identifier(Main.MODID, "rubeus"), BetterNether.makeID("rubeus"));
        quickReg2(new Identifier(Main.MODID, "wart"), BetterNether.makeID("wart"));
        quickReg2(new Identifier(Main.MODID, "mushroom_fir"), BetterNether.makeID("mushroom_fir"));
        quickReg3(new Identifier(Main.MODID, "anchor_tree"), BetterNether.makeID("anchor_tree"));
        quickReg3(new Identifier(Main.MODID, "nether_sakura"), BetterNether.makeID("nether_sakura"));
    }

    private static void quickReg(Identifier id, Identifier wood)
    {
        ApiVariationRegistry.getInstance().registerVariantWood(id,  new VariationWoodRecord(
                new Identifier(wood.getNamespace(), wood.getPath()+"_bark_side"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_bark_top"),
                wood.getPath(),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks")
        ));
    }
    private static void quickReg2(Identifier id, Identifier wood)
    {
        ApiVariationRegistry.getInstance().registerVariantWood(id,  new VariationWoodRecord(
                new Identifier(wood.getNamespace(), wood.getPath()+"_bark"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log_top"),
                wood.getPath(),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks")
        ));
    }

    private static void quickReg3(Identifier id, Identifier wood)
    {
        ApiVariationRegistry.getInstance().registerVariantWood(id,  new VariationWoodRecord(
                new Identifier(wood.getNamespace(), wood.getPath()+"_log_side"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log_top"),
                wood.getPath(),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks")
        ));
    }

    private static void quickRegMetal(Identifier id, Identifier metal)
    {
        ApiVariationRegistry.getInstance().registerVariantMetalQuick(id, metal);
    }
}
