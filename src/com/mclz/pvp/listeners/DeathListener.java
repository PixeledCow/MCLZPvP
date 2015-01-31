package com.mclz.pvp.listeners;

import com.mclz.pvp.Core;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

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

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        if(!(event.getEntity() instanceof Player)) {
            return;
        }
        else {
            Player player = event.getEntity();
            Player killer = player.getKiller();

            if(killer == null) {
                return;
            }
            else {
                killer.sendMessage(Core.TAG + "You murdered §c" + player.getDisplayName() + "§6.");
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

    }


}
