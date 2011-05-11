package net.inabsentia.bukkit.Tinderbox;

import java.util.logging.Logger;

import net.inabsentia.bukkit.Tinderbox.TinBlockListener;
import net.inabsentia.bukkit.Tinderbox.TinPlayerListener;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Tinderbox extends JavaPlugin{
	
	private static final Logger logger = Logger.getLogger("Minecraft.Tinderbox");
	public PluginDescriptionFile pdfFile;
	
	private final TinBlockListener bListener = new TinBlockListener(this);
	private final TinPlayerListener pListener = new TinPlayerListener(this);

	
	public Logger getLogger() {
        return logger;
    }
	
	@Override
	public void onDisable() {
		pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " has been disabled.");
	}

	@Override
	public void onEnable() {
		pdfFile = this.getDescription();
		logger.info(pdfFile.getName() + " v" + pdfFile.getVersion() + " is enabled!");
		
		getDataFolder().mkdirs();
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_BREAK, bListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, bListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_ITEM_HELD, pListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, pListener, Priority.Normal, this);
		
	}

}
