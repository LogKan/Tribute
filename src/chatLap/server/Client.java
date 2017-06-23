package chatLap.server;

import java.io.IOException;
import java.net.Socket;

public class Client {
	
	private Socket socket;
	private String name;
	
	public Client(Socket socket){
		this.socket = socket;
	}
	
	public void stop(){
		try {
			this.socket.close();
		} catch (IOException e) {

		}
	}

	@Override
	public String toString() {
		return "Client [socket=" + socket + "]";
	}

	
}
