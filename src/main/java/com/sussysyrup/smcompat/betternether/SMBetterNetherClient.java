package com.sussysyrup.smcompat.betternether;

import com.sussysyrup.smcompat.betternether.client.registry.BNFluidRegistryClient;
import com.sussysyrup.smcompat.betternether.client.registry.BNMaterialRegistryClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class SMBetterNetherClient {

    public static void initialise()
    {
        BNMaterialRegistryClient.clientInit();
        BNFluidRegistryClient.clientInit();
    }

}
