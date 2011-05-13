package net.inabsentia.bukkit.Tinderbox;

import java.util.logging.Logger;

import net.inabsentia.bukkit.Tinderbox.TinBlockListener;
import net.inabsentia.bukkit.Tinderbox.TinPlayerListener;
import net.inabsentia.bukkit.Tinderbox.Commands.TinCommands;


import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class Tinderbox extends JavaPlugin{
	
	private static final Logger logger = Logger.getLogger("Minecraft.Tinderbox");
	public PluginDescriptionFile pdfFile;
	public static PermissionHandler Permissions;

	
	private final TinBlockListener bListener = new TinBlockListener(this);
	private final TinPlayerListener pListener = new TinPlayerListener(this);

	
	@Override
	public void onDisable() {
		logger.info("has been disabled.");
	}

	@Override
	public void onEnable() {
		
        // Get commands
		loadCommands();
		
		// Register events
		registerEvents();
		
		// Set up permissions
		setupPermissions();
		
		// Set up properties
		TinProperties.reload();

		systemMessage("is enabled.");

		
	}
	
	private void registerEvents(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.BLOCK_BREAK, bListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.BLOCK_PLACE, bListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_ITEM_HELD, pListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_INTERACT, pListener, Priority.Normal, this);
	}
	
	private void setupPermissions() {
			Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");
	
	      if (Tinderbox.Permissions == null) {
		      if (test != null) {
		          Tinderbox.Permissions = ((Permissions) test).getHandler();
		          systemMessage("Using Permissions");
		      } else {
		    	  systemMessage("Permission system not detected, defaulting to OP");
	          }
	      }
	 }
	
	public String getName(){
        PluginDescriptionFile pdfFile = this.getDescription();
        return pdfFile.getName();
    }
	
    public String getVersion(){
        PluginDescriptionFile pdfFile = this.getDescription();
        return pdfFile.getVersion();
    }	
    
	public void systemMessage(String message){
		logger.info("["+getName()+" : "+getVersion()+"] "+message);
    }
	
	public Player getPlayer(String name){
		for(Player pl : this.getServer().getOnlinePlayers()){
			if(pl.getName().toLowerCase().startsWith(name.toLowerCase())){
				return pl;
			}
		}
    	return null;
    }
    private void loadCommands(){
    	getCommand("tb").setExecutor(new TinCommands(this));
    	//getCommand("archers").setExecutor(new Archerscommand(this));
    }

}
