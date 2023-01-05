package com.sussysyrup.smcompat.chisel.registry;

import com.sussysyrup.smcompat.chisel.item.ChiselToolItem;
import com.sussysyrup.smitheesfoundry.api.itemgroup.ItemGroups;
import com.sussysyrup.smitheesfoundry.registry.ItemsRegistry;
import com.sussysyrup.smitheesfoundry.util.CompatibilityUtil;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class CItemsRegistry {

    public static void initialise()
    {
        CompatibilityUtil.disableDefaultChisel = true;
        ItemsRegistry.FORGE_CHISEL = new ChiselToolItem((new FabricItemSettings()).group(ItemGroups.TOOL_GROUP).maxCount(1), "chisel", null);
    }

}
