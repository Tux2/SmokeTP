package me.waffletastic.SmokeTP;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class SmokeTPPlayerListener implements Listener {
	SmokeTP plugin;


	public SmokeTPPlayerListener(SmokeTP instance) {
		this.plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		if(event.getPlayer().hasPermission("smoketp.smoke")) {
			List<Location> smokeLocations = new ArrayList<Location>();
			smokeLocations.add(event.getFrom());
			smokeLocations.add(event.getFrom().clone().add(0, 1, 0));
			smokeLocations.add(event.getTo());
			smokeLocations.add(event.getTo().clone().add(0, 1, 0));
			SmokeUtil.spawnCloudRandom(smokeLocations, plugin.smokesize);
		}
	}
}