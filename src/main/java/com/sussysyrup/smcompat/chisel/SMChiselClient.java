package com.sussysyrup.smcompat.chisel;

import com.matthewperiut.chisel.gui.ChiselScreen;
import com.sussysyrup.smcompat.chisel.registry.CScreenRegistry;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class SMChiselClient {
    
    public static void initialise() {
        ScreenRegistry.register(CScreenRegistry.CHISEL_SCREEN_HANDLER, ChiselScreen::new);
    }
}
