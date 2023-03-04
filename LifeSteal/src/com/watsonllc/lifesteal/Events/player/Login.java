package com.watsonllc.lifesteal.Events.player;

import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import com.watsonllc.lifesteal.Config.Data;
import com.watsonllc.lifesteal.Utils.Utils;
import com.watsonllc.lifesteal.Utils.managers.LifestealManager;

public class Login implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) {
		Data.reload();
		Player player = event.getPlayer();
		LifestealManager ls = new LifestealManager(player);
		String banDate = null;
		
		if(ls.getBanDate() != null) banDate = ls.getBanDate().toLocaleString();
		
		Date current = new Date();
		String kick = Utils.chat("&cYou are out of lives until&8: &7\n" + banDate + "\n\n&cYou have a play time of&8:&7\n"
				+ ls.getPlaytime());

		
		if(ls.isBanned()) {
			if(ls.getBanDate().after(current))	{
				event.disallow(Result.KICK_OTHER, kick);
			} else {
				ls.setBanned(false);
				ls.resetLives();
				Bukkit.broadcastMessage(Utils.chat("&7Welcome back from the &8dead &c" + player.getName() + "&7!"));
			}
		} else return;
	}
}