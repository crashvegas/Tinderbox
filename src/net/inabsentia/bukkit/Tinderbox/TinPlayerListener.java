package net.inabsentia.bukkit.Tinderbox;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

public class TinPlayerListener extends PlayerListener{
	
	public static Tinderbox plugin; 
	public TinPlayerListener(Tinderbox instance) { 
        plugin = instance;
	}
	
	public void onItemHeldChange(PlayerItemHeldEvent event) {
		Player p = event.getPlayer();
		ItemStack item = p.getInventory().getContents()[event.getNewSlot()];

		if(item == null){
			return;
		}

		if(item.getType() == Material.STICK){
			
		}
	}
	
	public void onPlayerInteract(PlayerInteractEvent event){
		Player p = event.getPlayer();
		ItemStack item = p.getItemInHand();
		Material m = item.getType();
		
		if(m == Material.STICK) {
			Block b = p.getTargetBlock(null, 100);
			World world = p.getWorld();
			if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
				world.strikeLightning(new Location (world, b.getX(), b.getY(),b.getZ()));
			}
			else if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
				world.spawnCreature(new Location (world, b.getX(), b.getY(),b.getZ()), CreatureType.PIG);
			}
			
		}		
	}
}
