package com.watsonllc.lifesteal.Config;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import com.watsonllc.lifesteal.Lifesteal;

public class Data {

	public static File dataFile = new File(Lifesteal.instance.getDataFolder(), "data.yml");
	public static YamlConfiguration data = YamlConfiguration.loadConfiguration(dataFile);
	
	public static void create() {
		if(!dataFile.exists()) {
			try {
				data.save(dataFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void save() {
		try {
			data.save(dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void reload() {
		try {
			data.load(dataFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	public static void set(String path, Object object) {
		data.set(path, object);
		save();
	}
	
	public static void setString(String path, String string) {
		data.set(path, string);
		save();
	}
	
	public static void setBoolean(String path, boolean bool) {
		data.set(path, bool);
		save();
	}
	
	public static void setInt(String path, int num) {
		data.set(path, num);
		save();
	}
	
	public static void setDouble(String path, double maxHealth) {
		data.set(path, maxHealth);
		save();
	}
	
	public static Date get(String path) {
		return data.getObject(path, Date.class);
	}
	
	public static String getString(String path) {
		return data.getString(path);
	}
	
	public static boolean getBoolean(String path) {
		return data.getBoolean(path);
	}
	
	public static int getInt(String path) {
		return data.getInt(path);
	}
	
	public static double getDouble(String path) {
		return data.getDouble(path);
	}
}
