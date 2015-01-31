package com.mclz.pvp.killstreak;

import org.bukkit.entity.Player;

import java.util.ArrayList;

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
public class KillStreakManager {

    public static ArrayList<KillStreak> killstreaks = new ArrayList<KillStreak>();

    public static KillStreak getKillStreak(Player p){
        for(KillStreak ks : killstreaks){
            if(ks.getPlayer().equals(p)){
                return ks;
            }
        }
        return null;
    }

}
