package com.sussysyrup.smcompat.betterend.registry;

import com.sussysyrup.smcompat.betterend.trait.EternalTrait;
import com.sussysyrup.smcompat.betterend.trait.HybridAncientTrait;
import com.sussysyrup.smcompat.betterend.trait.PureTrait;
import com.sussysyrup.smcompat.betterend.trait.ShiftTrait;
import com.sussysyrup.smitheesfoundry.api.material.ApiMaterialRegistry;
import com.sussysyrup.smitheesfoundry.api.material.Material;
import com.sussysyrup.smitheesfoundry.api.material.MaterialResource;
import com.sussysyrup.smitheesfoundry.api.trait.ApiTraitRegistry;
import com.sussysyrup.smitheesfoundry.api.trait.TraitContainer;
import com.sussysyrup.smitheesfoundry.registry.MaterialRegistry;
import net.minecraft.util.Formatting;
import ru.betterend.BetterEnd;

import java.util.Arrays;
import java.util.List;

public class BEMaterialRegistry {

    public static TraitContainer SHIFT_TRAIT = new ShiftTrait("beshift", Formatting.DARK_PURPLE);
    public static TraitContainer ETERNAL_TRAIT = new EternalTrait("beeternal", Formatting.AQUA);
    public static TraitContainer ANCIENT_TRAIT = new HybridAncientTrait("beancient", Formatting.LIGHT_PURPLE);
    public static TraitContainer PURE_TRAIT = new PureTrait("bepure", Formatting.AQUA);

    public static void initialise()
    {
        registerTraits();

        ApiMaterialRegistry.getInstance().registerMaterial("thallasium", new Material("thallasium", true, "molten_thallasium", 2, 320, 1.05F, 7, 1.5F,
                createTraitsList(MaterialRegistry.MAGNETIC2_TRAIT), createTraitsList(PURE_TRAIT), createTraitsList(PURE_TRAIT), createTraitsList(MaterialRegistry.MAGNETIC1_TRAIT)));
        ApiMaterialRegistry.getInstance().registerMaterial("terminite", new Material("terminite", true, "molten_terminite", 3, 1230, 0.9F, 8.5F, 3.0F,
                createTraitsList(MaterialRegistry.REGROWTH_TRAIT), createTraitsList(SHIFT_TRAIT), createTraitsList(MaterialRegistry.BRITTLE_TRAIT), createTraitsList(SHIFT_TRAIT)));
        ApiMaterialRegistry.getInstance().registerMaterial("aeternium", new Material("aeternium", true, "molten_terminite", 5, 2196, 0.96F, 10.0F, 4.5F,
                createTraitsList(), createTraitsList(ANCIENT_TRAIT), createTraitsList(), createTraitsList(ANCIENT_TRAIT)));
        ApiMaterialRegistry.getInstance().registerMaterial("eternalcrystal", new Material("eternalcrystal", false, "empty", 1, 109, 0.5F, 1.0F, 0.5F,
                createTraitsList(MaterialRegistry.BRITTLE_TRAIT), createTraitsList(ETERNAL_TRAIT, MaterialRegistry.CORRODING_TRAIT, MaterialRegistry.BRITTLE_TRAIT), createTraitsList(MaterialRegistry.BRITTLE_TRAIT), createTraitsList(MaterialRegistry.BRITTLE_TRAIT)));

        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("eternal_crystal"), new MaterialResource("eternalcrystal", 0.2F));

        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("thallasium_ingot"), new MaterialResource("thallasium", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("thallasium_forged_plate"), new MaterialResource("thallasium", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("thallasium_nugget"), new MaterialResource("thallasium", 1/9F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("thallasium_block"), new MaterialResource("thallasium", 9F));

        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("aeternium_ingot"), new MaterialResource("aeternium", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("aeternium_forged_plate"), new MaterialResource("aeternium", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("aeternium_block"), new MaterialResource("aeternium", 9F));

        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("terminite_ingot"), new MaterialResource("terminite", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("terminite_forged_plate"), new MaterialResource("terminite", 1F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("terminite_nugget"), new MaterialResource("terminite", 1/9F));
        ApiMaterialRegistry.getInstance().registerIDmaterialResource(BetterEnd.makeID("terminite_block"), new MaterialResource("terminite", 9F));
    }

    private static void registerTraits() {
        ApiTraitRegistry.getInstance().registerTrait("beshift", SHIFT_TRAIT);
        ApiTraitRegistry.getInstance().registerTrait("beeternal", ETERNAL_TRAIT);
        ApiTraitRegistry.getInstance().registerTrait("beancient", ANCIENT_TRAIT);
        ApiTraitRegistry.getInstance().registerTrait("bepure", PURE_TRAIT);
    }

    private static List<TraitContainer> createTraitsList(TraitContainer... containers)
    {
        return Arrays.stream(containers).toList();
    }
}
