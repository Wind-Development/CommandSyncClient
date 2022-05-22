package ga.windpvp.commandsync.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection {

	public Socket clientSocket;
	public PrintWriter out;
	public BufferedReader in;
	
	public Connection(String ip, int port) {
		try {
			clientSocket = new Socket(ip, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isConnected() {
		return clientSocket.isConnected();
	}

	public void sendMessage(String msg) throws IOException {
		out.println(msg);
	}
}
