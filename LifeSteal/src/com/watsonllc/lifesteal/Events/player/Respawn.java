package com.watsonllc.lifesteal.Events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.watsonllc.lifesteal.Utils.Utils;
import com.watsonllc.lifesteal.Utils.managers.LifestealManager;

public class Respawn implements Listener {
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		LifestealManager ls = new LifestealManager(player);
		
		ls.updatePlaytime();
		Utils.setLivesInHeader(player);
	}
}
