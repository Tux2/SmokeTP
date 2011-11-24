package me.waffletastic.SmokeTP;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SmokeTP extends JavaPlugin {
	Logger log = Logger.getLogger("Minecraft");
	private final SmokeTPPlayerListener playerListener = new SmokeTPPlayerListener(this);
	
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		File configFile = new File(this.getDataFolder(),"config.yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(configFile);
		conf.set("Smoke Size", 3);
		conf.getInt("Smoke Size", 3);
		try {
			conf.save(configFile);
		} catch (IOException e) {
			log.info("Could not save config.yml");
		}
		pm.registerEvent(Event.Type.PLAYER_TELEPORT, playerListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_MOVE, playerListener, Priority.Normal, this);
		
		log.info("SmokeTP by waffletastic and Sluijsens enabled!");
	}
	
	
	public void onDisable() {
		log.info("Oh teh noes! SmokeTP is disabled!");
	}
}