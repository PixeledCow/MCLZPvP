package com.mclz.pvp.util;

import org.bukkit.entity.Player;

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

public class ProbabilityManager {

    private static float generateRandomChance() {
        Random r = new Random();
        return r.nextFloat();
    }

    public static boolean calculateChance(Player player) {
        if (generateRandomChance() <= 0.3F) {
            return true;
        } else {
            return false;
        }
    }
}
