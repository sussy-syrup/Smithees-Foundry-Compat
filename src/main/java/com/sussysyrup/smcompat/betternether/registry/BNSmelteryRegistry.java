package com.sussysyrup.smcompat.betternether.registry;

import com.sussysyrup.smitheesfoundry.api.fluid.ApiSmelteryResourceRegistry;
import com.sussysyrup.smitheesfoundry.api.fluid.SmelteryResource;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import paulevs.betternether.BetterNether;

public class BNSmelteryRegistry {

    //cincinnasite

    public static void initialise()
    {
        ApiSmelteryResourceRegistry srregistry = ApiSmelteryResourceRegistry.getInstance();

        srregistry.addIDSmelteryResource(BetterNether.makeID("cincinnasite_ingot"), new SmelteryResource("molten_cincinnasite", FluidConstants.INGOT));
        srregistry.addIDSmelteryResource(BetterNether.makeID("cincinnasite_forged"), new SmelteryResource("molten_cincinnasite", FluidConstants.INGOT*4));
        srregistry.addIDSmelteryResource(BetterNether.makeID("cincinnasite"), new SmelteryResource("molten_cincinnasite", FluidConstants.INGOT));
        srregistry.addIDSmelteryResource(BetterNether.makeID("cincinnasite_block"), new SmelteryResource("molten_cincinnasite", FluidConstants.INGOT*4));
    }

}
