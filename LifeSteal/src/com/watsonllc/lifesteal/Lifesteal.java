package com.watsonllc.lifesteal;

import org.bukkit.plugin.java.JavaPlugin;

import com.watsonllc.lifesteal.Commands.Commands;
import com.watsonllc.lifesteal.Config.Config;
import com.watsonllc.lifesteal.Events.Events;

public class Lifesteal extends JavaPlugin {
	public static Lifesteal instance;

	@Override
	public void onEnable() {
		instance = this;
		
		Commands.setup();
		Config.setup();
		Events.setup();
	}
}