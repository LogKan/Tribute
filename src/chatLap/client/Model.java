package chatLap.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;

public class Model {
	
	private Logger logger = Logger.getLogger("");
	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	private Socket socket;
	
	public Model(){
		
	}
	
	public void connect(String ipAddress, int port, String name){
		try {
			this.socket = new Socket(ipAddress, port);
			logger.info("Connect");
		} catch (Exception e) {
			logger.warning(e.toString());
		}
	}
	
	public void disconnect(){
		logger.info("Disconnect");
			if(this.socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					logger.warning(e.toString());
				}	
		}
	}
	
	public void sendMessage(String message){
		logger.info("Send message");
	}
	
	public String receiveMessage(){
		logger.info("Receive massage");
		return newestMessage.get();
	}
	
}
