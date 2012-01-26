package me.waffletastic.SmokeTP;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SmokeTP extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	int smokesize = 3;
	private final SmokeTPPlayerListener playerListener = new SmokeTPPlayerListener(this);
	
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		File configFile = new File(this.getDataFolder(),"config.yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(configFile);
		smokesize = conf.getInt("Smoke Size", 3);
		conf.set("Smoke Size", smokesize);
		try {
			conf.save(configFile);
		} catch (IOException e) {
			log.info("Could not save config.yml");
		}
		
		pm.registerEvents(playerListener, this);
		
		log.info("SmokeTP by waffletastic and Sluijsens enabled!");
	}
	
	
	public void onDisable() {
		log.info("Oh teh noes! SmokeTP is disabled!");
	}
}