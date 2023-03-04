package com.watsonllc.lifesteal.Utils.managers;

import java.util.Date;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import com.watsonllc.lifesteal.Config.Data;
import com.watsonllc.lifesteal.Utils.Utils;

public class LifestealManager {
	Player player;
	String playerName;
	String dataPath;
	String playtime;
	Date unbanDate;
	boolean banned;
	double health;
	int lives;
	int deaths;

	public LifestealManager(Player player) {
		this.player = player;
		if (player != null)
			this.dataPath = "data." + player.getUniqueId().toString();
	}

	public void create() {
		this.playerName = player.getName();
		this.health = 20.0;
		this.lives = 3;
		this.deaths = 0;
		this.banned = false;
		this.unbanDate = null;
		updatePlaytime();

		Data.setString(dataPath + ".user", playerName);
		Data.setDouble(dataPath + ".health", health);
		Data.setBoolean(dataPath + ".banned", banned);
		Data.set(dataPath + ".unbanDate", unbanDate);
		Data.setString(dataPath + ".playtime", playtime);
		Data.setInt(dataPath + ".lives", lives);
		Data.setInt(dataPath + ".deaths", deaths);
	}

	public boolean isNull() {
		if (!Data.data.contains(dataPath)) {
			return true;
		} else
			return false;
	}

	public void remove() {
		Data.setString(dataPath, null);
	}

	public double getHealth() {
		this.health = Data.getDouble(dataPath + ".health");
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
		Data.setDouble(dataPath + ".health", this.health);
	}

	public int getLives() {
		this.lives = Data.getInt(dataPath + ".lives");
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
		Data.setInt(dataPath + ".lives", this.lives);
	}

	public void resetLives() {
		this.lives = 3;
		Data.setInt(dataPath + ".lives", lives);
	}

	public void addLife() {
		this.lives = getLives();
		lives++;
		Data.setInt(dataPath + ".lives", lives);
	}

	public void takeLife() {
		this.lives = getLives();
		lives--;
		Data.set(dataPath + ".lives", lives);
	}

	public int getDeaths() {
		this.deaths = Data.getInt(dataPath + ".deaths");
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
		Data.setInt(dataPath + ".deaths", this.deaths);
	}

	public void addDeath() {
		this.deaths = getDeaths();
		deaths++;
		Data.setInt(dataPath + ".deaths", deaths);
	}

	public void setBanned(boolean banned) {
		this.banned = banned;
		updatePlaytime();

		if (banned == true) {
			Date banEndTime = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);
			Data.set(dataPath + ".unbanDate", banEndTime);
			player.kickPlayer(
					Utils.chat("&c\"Death is a debt we all must pay.\" - Euripides" + "\n&7come back in 24 hours"));
		} else if (banned == false)
			Data.set(dataPath + ".unbanDate", null);
		Data.setBoolean(dataPath + ".banned", banned);
	}

	public boolean isBanned() {
		if (Data.getBoolean(dataPath + ".banned")) {
			return true;
		} else
			return false;
	}

	public Date getBanDate() {
		return Data.get(dataPath + ".unbanDate");
	}

	public void updatePlaytime() {
		long ticks = player.getStatistic(Statistic.PLAY_ONE_MINUTE);
		long minutes = ticks / 1200;
		this.playtime = minutes + " minutes";
		Data.setString(dataPath + ".playtime", this.playtime);
	}

	public String getPlaytime() {
		this.playtime = Data.getString(dataPath + ".playtime");
		return playtime;
	}
}