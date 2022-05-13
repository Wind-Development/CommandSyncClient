package ga.windpvp.commandsync;

import org.bukkit.plugin.java.JavaPlugin;

import ga.windpvp.commandsync.commands.SyncCommand;
import ga.windpvp.commandsync.connection.ConnectionManager;

public class SyncPlugin extends JavaPlugin {

	private static SyncPlugin INSTANCE;

	private ConnectionManager manager;

	@Override
	public void onEnable() {
		// Save default config
		this.saveDefaultConfig();

		// Set static instance
		SyncPlugin.INSTANCE = this;

		// Register the example command
		this.getCommand("sync").setExecutor(new SyncCommand());

		// Initialize connection
		manager = new ConnectionManager(INSTANCE, getConfig().getInt("sync-server-port"),
				getConfig().getString("name"));
	}

	public static SyncPlugin getInstance() {
		return SyncPlugin.INSTANCE;
	}

	public ConnectionManager getConnectionManager() {
		return manager;
	}
}