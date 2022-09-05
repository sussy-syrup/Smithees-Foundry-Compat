package com.sussysyrup.smcompat.betterend.trait;

import com.sussysyrup.smitheesfoundry.api.trait.IStatTrait;
import com.sussysyrup.smitheesfoundry.api.trait.TraitContainer;
import net.minecraft.util.Formatting;

public class HybridAncientTrait extends TraitContainer implements IStatTrait {
    public HybridAncientTrait(String name, Formatting formatting) {
        super(name, formatting);
    }

    @Override
    public int durabilityAdd() {
        return 0;
    }

    @Override
    public float durabilityMultiply() {
        return 1;
    }

    @Override
    public float damageAdd() {
        return 1;
    }

    @Override
    public float damageMultiply() {
        return 1.3F;
    }

    @Override
    public float swingSpeedAdd() {
        return 0.5F;
    }

    @Override
    public float swingSpeedMultiply() {
        return 1;
    }

    @Override
    public float miningSpeedAdd() {
        return 1.2F;
    }

    @Override
    public float miningSpeedMultiply() {
        return 1.1F;
    }

    @Override
    public float miningLevelAdd() {
        return 0;
    }
}
