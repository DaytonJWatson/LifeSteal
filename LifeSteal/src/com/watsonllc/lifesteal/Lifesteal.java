package com.watsonllc.lifesteal;

import org.bukkit.plugin.java.JavaPlugin;

public class Lifesteal extends JavaPlugin {
	public static Lifesteal instance;
	
	@Override
	public void onEnable() {
		instance = this;
	}
	
}
