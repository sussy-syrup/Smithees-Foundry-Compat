package com.sussysyrup.smcompat.chisel.registry;

import com.sussysyrup.smcompat.SMCompatMain;
import com.sussysyrup.smcompat.chisel.gui.CChiselScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CScreenRegistry {
    public static ScreenHandlerType<CChiselScreenHandler> CHISEL_SCREEN_HANDLER;

    public static void initialise()
    {
        CHISEL_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier(SMCompatMain.MODID, "chisel_inventory"), CChiselScreenHandler::new);
    }

}
