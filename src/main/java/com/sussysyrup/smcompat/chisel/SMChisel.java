package com.sussysyrup.smcompat.chisel;

import com.sussysyrup.smcompat.chisel.registry.CItemsRegistry;
import com.sussysyrup.smcompat.chisel.registry.CScreenRegistry;

public class SMChisel {

    public static void initialise()
    {
        CItemsRegistry.initialise();
        CScreenRegistry.initialise();
    }

}
