package com.mclz.pvp;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ***********************************************************************
 * Copyright PixeledCow (C) 2015. All Rights Reserved.
 * Any code contained within this document, and any associated APIs with similar branding
 * are the sole property of PixeledCow. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the liscense, and void any
 * agreements with you, the third party.
 * Thanks.
 * ************************************************************************
 */

public class Core extends JavaPlugin  {

    public static String TAG = "§4§l[§cPvP§4§l] §6";

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    public static Plugin getPlugin() {
        return Bukkit.getPluginManager().getPlugin("MCLZPvP");
    }
}
