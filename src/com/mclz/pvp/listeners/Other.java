package com.mclz.pvp.listeners;

import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.mclz.pvp.Core;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
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

public class Other implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType() == Material.TNT) {

            Player player = event.getPlayer();

            event.setBuild(true);
            event.setCancelled(false);

            if (player.getInventory().getItemInHand().getAmount() > 1) {
                player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount() - 1);
            } else {
                player.getInventory().setItemInHand(null);
            }
            event.getBlock().setType(Material.AIR);

            TNTPrimed tnt = (TNTPrimed) event.getBlock().getWorld().spawnEntity(event.getBlock().getLocation(), EntityType.PRIMED_TNT);
            tnt.setFuseTicks(30);

            clickClickClick(event.getBlock().getLocation().add(0, 1, 0));
        }
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onExplode(EntityExplodeEvent event) {
        if (event.getEntity() instanceof TNTPrimed) {
            event.blockList().clear();
        }
    }

    @EventHandler
    public void onEntityDamageTrigger(EntityDamageEvent event) {
        if (event.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION || event.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
            event.setDamage(EntityDamageEvent.DamageModifier.RESISTANCE, 5.0);
        }
    }

    private void clickClickClick(final Location location) {
        new BukkitRunnable() {
            float base = 4;
            int times = 0;

            @Override
            public void run() {
                location.getWorld().playSound(location, Sound.CLICK, 40F, base);
                base++;
                base++;

                times++;
                if (times == 3) {
                    this.cancel();
                }
            }
        }.runTaskTimer(Core.getPlugin(), 0L, 7L);
    }
}
