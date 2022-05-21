package ga.windpvp.commandsync.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ga.windpvp.commandsync.SyncPlugin;
import net.md_5.bungee.api.ChatColor;

public class SyncCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		StringBuilder builder = new StringBuilder();

		for (String arg : args) {
			builder.append(arg);
			builder.append(" ");
		}

		SyncPlugin.getInstance().getConnectionManager().dispatchCommand(builder.toString());
		
		sender.sendMessage(ChatColor.GREEN + "Synced command " + builder.toString() + " to the Velocity instance!");

		return true;
	}

}
