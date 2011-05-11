package net.inabsentia.bukkit.Tinderbox;

import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerListener;

public class TinPlayerListener extends PlayerListener{
	
	public static Tinderbox plugin; 
	public TinPlayerListener(Tinderbox instance) { 
        plugin = instance;
	}
	
	public void onItemHeldChange(PlayerItemHeldEvent event) {
		
	}
	
	public void onPlayerInteract(PlayerInteractEvent event){
		
	}
}
