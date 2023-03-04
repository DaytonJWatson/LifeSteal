package com.watsonllc.lifesteal.Events.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import com.watsonllc.lifesteal.Utils.Utils;
import com.watsonllc.lifesteal.Utils.managers.LifestealManager;

public class Death implements Listener {
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		Player victim = event.getEntity();
		Player killer = event.getEntity().getKiller();
		
		if(victim != null) {
			LifestealManager lsVictim = new LifestealManager(victim);
			lsVictim.updatePlaytime();
			lsVictim.addDeath();
			lsVictim.takeLife();
			
			if(lsVictim.getLives() <= 0) lsVictim.setBanned(true);
			
			Location loc = victim.getLocation();
			loc.getWorld().strikeLightning(loc);
			
			String vName = victim.getName();
			String deathMessage = "&c" + vName + " died!";
			event.setDeathMessage(Utils.chat(deathMessage));
		}
		
		if(killer != null) {
			LifestealManager lsKiller = new LifestealManager(killer);
			lsKiller.addLife();
		} else return;
	}
}