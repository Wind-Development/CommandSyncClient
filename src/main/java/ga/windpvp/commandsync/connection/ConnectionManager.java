package ga.windpvp.commandsync.connection;

import java.io.IOException;

import ga.windpvp.commandsync.SyncPlugin;

public class ConnectionManager {

	private final Connection connection;

	public ConnectionManager(SyncPlugin instance, int port, String name) {
		connection = new Connection();

		try {
			connection.startConnection("127.0.0.1", port);
			connection.sendMessage("name " + name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void dispatchCommand(String command) {
		try {
			connection.sendMessage("run command " + command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
