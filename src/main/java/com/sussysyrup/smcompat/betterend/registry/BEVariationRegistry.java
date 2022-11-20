package com.sussysyrup.smcompat.betterend.registry;

import com.sussysyrup.smitheesfoundry.Main;
import com.sussysyrup.smitheesfoundry.api.block.ApiVariationRegistry;
import com.sussysyrup.smitheesfoundry.api.block.VariationMetalRecord;
import com.sussysyrup.smitheesfoundry.api.block.VariationWoodRecord;
import net.minecraft.util.Identifier;
import ru.betterend.BetterEnd;

public class BEVariationRegistry {

    public static void initialise()
    {
        quickReg(new Identifier(Main.MODID, "mossy_glowshroom"), BetterEnd.makeID("mossy_glowshroom"));
        quickReg(new Identifier(Main.MODID, "lucernia"), BetterEnd.makeID("lucernia"));
        quickReg(new Identifier(Main.MODID, "pythadendron"), BetterEnd.makeID("pythadendron"));
        quickReg(new Identifier(Main.MODID, "end_lotus"), BetterEnd.makeID("end_lotus"));
        quickReg(new Identifier(Main.MODID, "lacugrove"), BetterEnd.makeID("lacugrove"));
        quickReg(new Identifier(Main.MODID, "dragon_tree"), BetterEnd.makeID("dragon_tree"));
        quickReg(new Identifier(Main.MODID, "tenanea"), BetterEnd.makeID("tenanea"));
        quickReg(new Identifier(Main.MODID, "helix_tree"), BetterEnd.makeID("helix_tree"));
        quickReg(new Identifier(Main.MODID, "umbrella_tree"), BetterEnd.makeID("umbrella_tree"));
        quickReg(new Identifier(Main.MODID, "jellyshroom"), BetterEnd.makeID("jellyshroom"));

        quickRegMetal(new Identifier(Main.MODID, "aeternium"), BetterEnd.makeID("aeternium"));
        quickRegMetal(new Identifier(Main.MODID, "thallasium"), BetterEnd.makeID("thallasium"));
        quickRegMetal(new Identifier(Main.MODID, "terminite"), BetterEnd.makeID("terminite"));
    }

    private static void quickReg(Identifier id, Identifier wood)
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
