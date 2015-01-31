package com.mclz.pvp.listeners;

import com.mclz.pvp.Core;
import com.mclz.pvp.util.Kit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

public class JoinListener implements Listener {

    public static List<String> tips = new ArrayList<String>();

    static {
        tips.add("Use your fishing rod, you might find it useful.");
        tips.add("If you're low on health, don't hesitate to run away and take a break from fighting.");
        tips.add("Kill streak rewards can be very useful.");
        tips.add("Fire is useful, if you're running away place it behind you.");
        tips.add("Strafing is key to fighting efficiently.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        Kit.giveKit(player);
        player.sendMessage(Core.TAG + "Welcome to PvP §c" + player.getName() + "§6.");
        player.sendMessage(Core.TAG + "PvP Tip: §c" + getRndm());

    }

    private String getRndm() {
        return tips.get(new Random().nextInt(tips.size()));
    }
}
