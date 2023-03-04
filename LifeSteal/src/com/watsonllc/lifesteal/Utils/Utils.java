package com.watsonllc.lifesteal.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.watsonllc.lifesteal.Utils.managers.LifestealManager;

public class Utils {
	public static String chat(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public static void setLivesInHeader(Player player) {
		LifestealManager ls = new LifestealManager(player);
		String name = player.getName();
		int lives = ls.getLives();
		player.setPlayerListName(Utils.chat("&f" + name + " &8[&c" + lives + "&8]"));
	}
}
