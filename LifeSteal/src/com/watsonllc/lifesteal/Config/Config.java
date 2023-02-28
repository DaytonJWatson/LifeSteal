package com.watsonllc.lifesteal.Config;

import com.watsonllc.lifesteal.Lifesteal;
import com.watsonllc.lifesteal.Utils.Utils;

public class Config {
	public static void setup() {
		create();
		Data.create();
	}
	
	public static void create() {
		Lifesteal.instance.getConfig().options().copyDefaults();
		Lifesteal.instance.saveDefaultConfig();
	}
	
	public static void save() {
		Lifesteal.instance.saveConfig();
	}
	
	public static String getString(String path) {
		return Utils.chat(Lifesteal.instance.getConfig().getString(path));
	}
	
	public static int getInt(String path) {
		return Lifesteal.instance.getConfig().getInt(path);
	}
	
	public static double getDouble(String path) {
		return Lifesteal.instance.getConfig().getDouble(path);
	}
}
