package com.sussysyrup.smcompat.betterend.registry;

import com.sussysyrup.smitheesfoundry.api.fluid.ApiSmelteryResourceRegistry;
import com.sussysyrup.smitheesfoundry.api.fluid.SmelteryResource;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import ru.betterend.BetterEnd;

public class BESmelteryRegistry {

    public static void initialise()
    {
        ApiSmelteryResourceRegistry srregistry = ApiSmelteryResourceRegistry.getInstance();

        srregistry.addIDSmelteryResource(BetterEnd.makeID("ender_dust"), new SmelteryResource("molten_enderdust", FluidConstants.INGOT));

        SmelteryResource thallasium1 = new SmelteryResource("molten_thallasium", FluidConstants.INGOT);

        srregistry.addIDSmelteryResource(BetterEnd.makeID("thallasium_raw"), thallasium1);
        srregistry.addIDSmelteryResource(BetterEnd.makeID("thallasium_ore"), thallasium1);
    }

}
