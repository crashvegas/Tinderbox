package net.inabsentia.bukkit.Tinderbox;


import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class TinBlockListener extends BlockListener{
	public static Tinderbox plugin; 
	public TinBlockListener(Tinderbox instance) { 
        plugin = instance;
	}

	public void onBlockBreak(BlockBreakEvent event) {

	}
	
	public void onBlockPlace(BlockPlaceEvent event) {

	}
}
