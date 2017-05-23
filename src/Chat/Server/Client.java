package Chat.Server;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private Socket socket; 
	
	public Client (Socket socket){
		this.socket = socket;
	}
	
	public void stop() {
		try {
			socket.close();
		} catch (IOException e) {
			// Uninteresting
		}
	}

}
