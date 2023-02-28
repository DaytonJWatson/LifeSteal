package com.watsonllc.lifesteal.Utils.managers;

import org.bukkit.entity.Player;

import com.watsonllc.lifesteal.Config.Config;
import com.watsonllc.lifesteal.Config.Data;

public class DataManager {
	
	static int lives;
	static double maxHealth;
	
	public static void create(Player player) {
		String dataPath = "data." + player.getUniqueId().toString();
		lives = Config.getInt(dataPath + ".lives");
		maxHealth = Config.getDouble(dataPath + ".maxHealth");
		
		Data.setString(dataPath + ".user", player.getName());
		Data.setInt(dataPath + ".lives", lives);
		Data.setDouble(dataPath + ".maxHealth", maxHealth);
	}
}
