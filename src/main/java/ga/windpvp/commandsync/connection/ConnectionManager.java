package ga.windpvp.commandsync.connection;

import java.io.IOException;

import ga.windpvp.commandsync.SyncPlugin;

public class ConnectionManager {

	private final Connection connection;

	public ConnectionManager(SyncPlugin instance, int port, String name) {
		connection = new Connection();

		try {
			connection.startConnection("127.0.0.1", port);
			sendMessage("name " + name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dispatchCommand(String command) {
		sendMessage("run command " + command);
	}
	
	public void shutdown() {
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
