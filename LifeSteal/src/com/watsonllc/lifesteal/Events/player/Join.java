package com.watsonllc.lifesteal.Events.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.watsonllc.lifesteal.Utils.Utils;
import com.watsonllc.lifesteal.Utils.managers.LifestealManager;

public class Join implements Listener {
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		LifestealManager ls = new LifestealManager(player);
		Utils.setLivesInHeader(player);
		
		String message = Utils.chat("&7Created new data for&8: &c" + player.getName());
		String permission = "lifesteal.debug";
		
		if(ls.isNull()) {
			ls.create();
			Bukkit.broadcast(message, permission);
		}
	}
}
