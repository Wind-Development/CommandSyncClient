package ga.windpvp.commandsync.connection;

import java.io.IOException;

import org.bukkit.scheduler.BukkitRunnable;

import ga.windpvp.commandsync.SyncPlugin;

public class ConnectionManager {

	private final Connection connection;
	private volatile boolean isConnected = false;

	public ConnectionManager(SyncPlugin instance, int port, String name) {
		connection = new Connection();

		// Continuously try to connect to the server
		new BukkitRunnable() {
			
			@Override
			public void run() {
				try {
					connection.startConnection("127.0.0.1", port);
					sendMessage("name " + name);
					cancel();
				} catch (IOException ignored) {
					instance.getLogger().warning("Unable to connect to the Velocity instance");
				}
			}
		}.runTaskTimerAsynchronously(instance, 0, 40);
	}

	public void dispatchCommand(String command) {
		if (isConnected)
			sendMessage("run command " + command);
	}
	
	public void shutdown() {
		if (isConnected)
			sendMessage(".");
	}
	
	private void sendMessage(String message) {
		try {
			connection.sendMessage(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
