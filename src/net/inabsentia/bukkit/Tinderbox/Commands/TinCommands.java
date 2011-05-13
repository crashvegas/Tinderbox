package net.inabsentia.bukkit.Tinderbox.Commands;

import net.inabsentia.bukkit.Tinderbox.Tinderbox;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TinCommands implements CommandExecutor {

	Tinderbox plugin;
	String cmd;

	public TinCommands(Tinderbox instance){
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		
		if (!(sender instanceof Player)) {
            sender.sendMessage("Only players may use this command");
            return true;
        }
		
		Player p = (Player)sender;
		
		
		
		if(args.length > 0){
			
			
			if(args[0] == "lrod" && Tinderbox.Permissions.has(p, "tinderbox.lightningrod")) {
				p.sendMessage(ChatColor.AQUA + "Lightning Rod disabled");
				return true;
			}
			else {
				p.sendMessage(ChatColor.DARK_RED + "You don't have access to this command.");
				return true;
			
			}
			
			
			
		    
		}
		else {
			p.sendMessage("Tinderbox Commands");
		    p.sendMessage("/tb lrod <on|off> - toggle lightning rod on/off");
			
		}
		
		return false;
	}

}
