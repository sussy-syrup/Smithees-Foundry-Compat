package com.sussysyrup.smcompat;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

import java.util.ArrayList;
import java.util.List;

public class SMCompatPreLaunch implements PreLaunchEntrypoint {

    public static List<String> modidList = new ArrayList<>();

    public static boolean betterEnd = false;
    public static boolean betterNether = false;
    @Override
    public void onPreLaunch() {
        FabricLoader.getInstance().getAllMods().forEach(modContainer -> modidList.add(modContainer.getMetadata().getId()));

        if(modidList.contains("betterend"))
        {
            betterEnd = true;
        }
        if(modidList.contains("betternether"))
        {
            betterNether = true;
        }
    }
}
