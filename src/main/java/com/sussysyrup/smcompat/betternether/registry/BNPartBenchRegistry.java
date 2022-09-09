package com.sussysyrup.smcompat.betternether.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.block.ApiPartBenchRegistry;
import com.sussysyrup.smitheesfoundry.api.block.PartBenchWoodRecord;
import net.minecraft.util.Identifier;
import paulevs.betternether.BetterNether;

public class BNPartBenchRegistry {

    public static void initialise()
    {
        quickReg(new Identifier(Main.MODID, "stalagnate_part_bench_block"), BetterNether.makeID("stalagnate"));
        quickReg2(new Identifier(Main.MODID, "willow_part_bench_block"), BetterNether.makeID("willow"));
        quickReg3(new Identifier(Main.MODID, "rubeus_part_bench_block"), BetterNether.makeID("rubeus"));
        quickReg2(new Identifier(Main.MODID, "wart_part_bench_block"), BetterNether.makeID("wart"));
        quickReg2(new Identifier(Main.MODID, "mushroom_fir_part_bench_block"), BetterNether.makeID("mushroom_fir"));
        quickReg3(new Identifier(Main.MODID, "anchor_tree_part_bench_block"), BetterNether.makeID("anchor_tree"));
        quickReg3(new Identifier(Main.MODID, "nether_sakura_part_bench_block"), BetterNether.makeID("nether_sakura"));
    }

    private static void quickReg(Identifier id, Identifier wood)
    {
        ApiPartBenchRegistry.getInstance().registerPartBenchWood(id,  new PartBenchWoodRecord(
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
        ApiPartBenchRegistry.getInstance().registerPartBenchWood(id,  new PartBenchWoodRecord(
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
        ApiPartBenchRegistry.getInstance().registerPartBenchWood(id,  new PartBenchWoodRecord(
                new Identifier(wood.getNamespace(), wood.getPath()+"_log_side"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log_top"),
                wood.getPath(),
                new Identifier(wood.getNamespace(), wood.getPath()+"_log"),
                new Identifier(wood.getNamespace(), wood.getPath()+"_planks")
        ));
    }
}
