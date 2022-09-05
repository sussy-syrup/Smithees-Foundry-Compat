package com.sussysyrup.smcompat.betterend.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.block.ApiPartBenchRegistry;
import com.sussysyrup.smitheesfoundry.api.block.PartBenchWoodRecord;
import net.minecraft.util.Identifier;
import ru.betterend.BetterEnd;

public class BEPartBenchRegistry {

    public static void initialise()
    {
        quickReg(new Identifier(Main.MODID, "mossy_glowshroom_part_bench_block"), BetterEnd.makeID("mossy_glowshroom"));
        quickReg(new Identifier(Main.MODID, "lucernia_part_bench_block"), BetterEnd.makeID("lucernia"));
        quickReg(new Identifier(Main.MODID, "pythadendron_part_bench_block"), BetterEnd.makeID("pythadendron"));
        quickReg(new Identifier(Main.MODID, "end_lotus_part_bench_block"), BetterEnd.makeID("end_lotus"));
        quickReg(new Identifier(Main.MODID, "lacugrove_part_bench_block"), BetterEnd.makeID("lacugrove"));
        quickReg(new Identifier(Main.MODID, "dragon_tree_part_bench_block"), BetterEnd.makeID("dragon_tree"));
        quickReg(new Identifier(Main.MODID, "tenanea_part_bench_block"), BetterEnd.makeID("tenanea"));
        quickReg(new Identifier(Main.MODID, "helix_tree_part_bench_block"), BetterEnd.makeID("helix_tree"));
        quickReg(new Identifier(Main.MODID, "umbrella_tree_part_bench_block"), BetterEnd.makeID("umbrella_tree"));
        quickReg(new Identifier(Main.MODID, "jellyshroom_part_bench_block"), BetterEnd.makeID("jellyshroom"));
    }

    private static void quickReg(Identifier id, Identifier wood)
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
