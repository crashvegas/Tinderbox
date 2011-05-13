package net.inabsentia.bukkit.Tinderbox.Commands;

import net.inabsentia.bukkit.Tinderbox.Tinderbox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TinCommands implements CommandExecutor {

	Tinderbox plugin;

	public TinCommands(Tinderbox instance){
		this.plugin = instance;
	}
	
	@Override
	public boolean onCommand(CommandSender player, Command command, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
