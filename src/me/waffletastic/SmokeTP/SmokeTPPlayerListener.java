package me.waffletastic.SmokeTP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class SmokeTPPlayerListener extends PlayerListener {
	SmokeTP plugin;


	public SmokeTPPlayerListener(SmokeTP instance) {
		this.plugin = instance;
	}
	
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		File configFile = new File(plugin.getDataFolder(),"config.yml");
		FileConfiguration conf = YamlConfiguration.loadConfiguration(configFile);
		if(event.getPlayer().hasPermission("smoketp.smoke")) {
			List<Location> smokeLocations = new ArrayList<Location>();
			smokeLocations.add(event.getFrom());
			smokeLocations.add(event.getFrom().clone().add(0, 1, 0));
			smokeLocations.add(event.getTo());
			smokeLocations.add(event.getTo().clone().add(0, 1, 0));
			SmokeUtil.spawnCloudRandom(smokeLocations, conf.getInt("Smoke Size", 3));
		}
	}
}