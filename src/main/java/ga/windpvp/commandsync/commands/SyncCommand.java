package ga.windpvp.commandsync.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ga.windpvp.commandsync.SyncPlugin;

public class SyncCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		String finalCommand = "";

		StringBuilder builder = new StringBuilder(finalCommand);

		for (String arg : args) {
			builder.append(arg);
			builder.append(" ");
		}

		SyncPlugin.getInstance().getConnectionManager().dispatchCommand(finalCommand);

		return true;
	}

}
