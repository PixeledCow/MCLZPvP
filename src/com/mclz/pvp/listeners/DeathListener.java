package com.mclz.pvp.listeners;

import com.mclz.pvp.Core;
import com.mclz.pvp.killstreak.KillStreak;
import com.mclz.pvp.killstreak.KillStreakManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
            Player dead = event.getEntity();
            Player killer = dead.getKiller();

            if(killer == null) {
                return;
            }
            else {
                killer.sendMessage(Core.TAG + "You murdered §c" + dead.getDisplayName() + "§6.");

                if(KillStreakManager.getKillStreak(dead) != null){
                    KillStreakManager.getKillStreak(dead).setKills(0);
                }
                if(KillStreakManager.getKillStreak(killer) == null){
                    KillStreak killstreaks = new KillStreak(killer);
                }
                KillStreak killstreaks = KillStreakManager.getKillStreak(killer);
                killstreaks.setKills(killstreaks.getKills() + 1);
                if (killstreaks.getKills() == 3) {
                    killer.sendMessage(Core.TAG + "You're on a §c§l3§c Kill Streak! You have been given speed!");
                    killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1));
                }
                else if (killstreaks.getKills() == 5) {
                    killer.sendMessage(Core.TAG + "You're on a §c§l5§c Kill Streak! Boots Upgraded.");
                    killer.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                }
                else if (killstreaks.getKills() == 10) {
                    Bukkit.broadcastMessage(Core.TAG + "§c§l" + killer.getName() + " §cis on a §c§n10§c Kill Streak!");
                    killer.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 1));
                    killer.sendMessage(Core.TAG + "Awarded STRENGTH!");
                }
                else if (killstreaks.getKills() == 15) {
                    killer.sendMessage(Core.TAG + "You're on a §c§l15§c Kill Streak! Helmet Upgraded, Regen added.");
                    killer.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
                    killer.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 300, 1));
                }
                else if (killstreaks.getKills() == 20) {
                    killer.sendMessage(Core.TAG + "You're on a §c§l20§c Kill Streak! Given Speed!");
                    killer.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
                }
                else if (killstreaks.getKills() == 25) {
                    ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD, 1);
                    dsword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                    dsword.addEnchantment(Enchantment.FIRE_ASPECT, 0);
                    killer.getInventory().addItem(dsword);
                    killer.sendMessage(Core.TAG + "You're on a §c§l25§c Kill Streak! Sword Upgraded.");
                    Bukkit.broadcastMessage(Core.TAG + "§c§l" + killer.getName() + " §cis on a §c§n25§c Kill Streak!");
                }
                else if (killstreaks.getKills() == 50) {
                    killer.sendMessage(Core.TAG + "You're on a §c§l50§c Kill Streak! Upgraded leggings.");
                    killer.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                    Bukkit.broadcastMessage(Core.TAG + "§c§l" + killer.getName() + " §cis on a §c§n50§c Kill Streak!");
                }
                else if (killstreaks.getKills() == 100) {
                    killer.sendMessage(Core.TAG + "You're on a §c§l100§c Kill Streak! :D");
                    Bukkit.broadcastMessage(Core.TAG + "§c§l" + killer.getName() + " §cis on a §c§n100§c Kill Streak!");
                }
            }
        }
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();

    }


}
