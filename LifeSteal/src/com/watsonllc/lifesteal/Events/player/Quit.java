package com.watsonllc.lifesteal.Events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.watsonllc.lifesteal.Utils.managers.LifestealManager;

public class Quit implements Listener {
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		LifestealManager ls = new LifestealManager(player);
		
		ls.updatePlaytime();
	}
}
