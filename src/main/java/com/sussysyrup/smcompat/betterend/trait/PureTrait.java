package com.sussysyrup.smcompat.betterend.trait;

import com.sussysyrup.smitheesfoundry.api.trait.IStatTrait;
import com.sussysyrup.smitheesfoundry.api.trait.TraitContainer;
import net.minecraft.util.Formatting;

public class PureTrait extends TraitContainer implements IStatTrait {
    public PureTrait(String name, Formatting formatting) {
        super(name, formatting);
    }

    @Override
    public int durabilityAdd() {
        return 500;
    }

    @Override
    public float durabilityMultiply() {
        return 1;
    }

    @Override
    public float damageAdd() {
        return 0;
    }

    @Override
    public float damageMultiply() {
        return 1;
    }

    @Override
    public float swingSpeedAdd() {
        return 0;
    }

    @Override
    public float swingSpeedMultiply() {
        return 1;
    }

    @Override
    public float miningSpeedAdd() {
        return 0;
    }

    @Override
    public float miningSpeedMultiply() {
        return 1;
    }

    @Override
    public float miningLevelAdd() {
        return 0;
    }
}
