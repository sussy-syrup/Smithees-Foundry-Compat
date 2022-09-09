package com.sussysyrup.smcompat.betternether.registry;

import com.sussysyrup.smitheesfoundry.api.material.ApiMaterialRegistry;
import com.sussysyrup.smitheesfoundry.api.material.Material;
import com.sussysyrup.smitheesfoundry.api.material.MaterialResource;
import com.sussysyrup.smitheesfoundry.api.trait.TraitContainer;
import com.sussysyrup.smitheesfoundry.registry.MaterialRegistry;
import paulevs.betternether.BetterNether;

import java.util.Arrays;
import java.util.List;

public class BNMaterialRegistry {

    //TODO Experiment with Enchantment Traits
    public static void initialise()
    {
        ApiMaterialRegistry.getInstance().registerMaterial("cincinnasite", new Material("cincinnasite", true, "molten_cincinnasite", 2, 512, 0.98F, 6, 2.0F,
                createTraitsList(MaterialRegistry.MAGNETIC2_TRAIT), createTraitsList(), createTraitsList(), createTraitsList(MaterialRegistry.MAGNETIC1_TRAIT)));
        ApiMaterialRegistry.getInstance().registerMaterial("netherruby", new Material("netherruby", false, "empty", 4, 1300, 1.10F, 9, 4.0F,
                createTraitsList(), createTraitsList(), createTraitsList(), createTraitsList()));

        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterNether.makeID("cincinnasite_ingot"), new MaterialResource("cincinnasite", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterNether.makeID("cincinnasite_forged"), new MaterialResource("cincinnasite", 4F));

        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterNether.makeID("nether_ruby"), new MaterialResource("netherruby", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterNether.makeID("nether_ruby_block"), new MaterialResource("netherruby", 9F));
    }

    private static List<TraitContainer> createTraitsList(TraitContainer... containers)
    {
        return Arrays.stream(containers).toList();
    }
}
