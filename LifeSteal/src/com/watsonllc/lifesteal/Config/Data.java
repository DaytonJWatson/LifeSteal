package com.watsonllc.lifesteal.Config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

import com.watsonllc.lifesteal.Lifesteal;

public class Data {

	public static File dataFile = new File(Lifesteal.instance.getDataFolder(), "data.yml");
	public static YamlConfiguration data = YamlConfiguration.loadConfiguration(dataFile);
	
	public static void create() {
		if(dataFile.exists()) {
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
	
	public static void setString(String path, String string) {
		data.set(path, string);
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
	
	public static String getString(String string) {
		return data.getString(string);
	}
	
	public static int getInt(String path) {
		return data.getInt(path);
	}
	
	public static double getDouble(String path) {
		return data.getDouble(path);
	}
}
