package com.watsonllc.lifesteal.Events;

import org.bukkit.plugin.PluginManager;

import com.watsonllc.lifesteal.Lifesteal;
import com.watsonllc.lifesteal.Events.player.Death;
import com.watsonllc.lifesteal.Events.player.Join;
import com.watsonllc.lifesteal.Events.player.Login;
import com.watsonllc.lifesteal.Events.player.Quit;
import com.watsonllc.lifesteal.Events.player.Respawn;

public class Events {
	public static void setup() {
		PluginManager pm = Lifesteal.instance.getServer().getPluginManager();
		
		pm.registerEvents(new Death(), Lifesteal.instance);
		pm.registerEvents(new Join(), Lifesteal.instance);
		pm.registerEvents(new Login(), Lifesteal.instance);
		pm.registerEvents(new Quit(), Lifesteal.instance);
		pm.registerEvents(new Respawn(), Lifesteal.instance);
	}
}
