package com.mclz.pvp.killstreak;

import org.bukkit.entity.Player;

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

public class KillStreak {

    private Player p;
    private int kills;

    public KillStreak(Player p){
        this.p = p;
        this.kills = 0;
        KillStreakManager.killstreaks.add(this);
    }

    public Player getPlayer(){
        return p;
    }

    public int getKills(){
        return kills;
    }

    public void setKills(int kills){
        this.kills = kills;
    }

}
