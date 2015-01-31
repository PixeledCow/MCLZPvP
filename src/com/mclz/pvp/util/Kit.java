package com.mclz.pvp.util;

import com.mclz.pvp.Core;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 1/31/15.
 */
public class Kit {

    public static void giveKit(Player player) {
        player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
        player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
        player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
        player.getInventory().setItem(1, new ItemStack(Material.BOW));
        player.getInventory().setItem(2, new ItemStack(Material.FISHING_ROD));

        ItemStack arrows = new ItemStack(Material.ARROW);
        arrows.setAmount(32);

        player.getInventory().setItem(8, arrows);

        ItemStack TNT = new ItemStack(Material.TNT);
        ItemMeta tMeta = TNT.getItemMeta();
        tMeta.setDisplayName("§c§lTNT");
        List<String> lore = new ArrayList<String>();
        lore.add("§7Place it behind you running");
        lore.add("§7from someone and... ");
        lore.add("§7BOOM! They'll blow up!");
        tMeta.setLore(lore);
        TNT.setItemMeta(tMeta);

        if(ProbabilityManager.calculateChance(player)) {
            player.getInventory().setItem(7, TNT);
            player.playSound(player.getLocation(), Sound.ITEM_PICKUP, 1F, 1F);
            player.sendMessage(Core.TAG + "You're lucky! You've been given TNT.");
        }


    }

    public static void upgrade(int tier, Player player) {
        // add tiers (w/ killstreaks)
    }

    public static void reset(Player player) {

    }
}
