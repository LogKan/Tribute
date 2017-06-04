package Chat.Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;

import Chat.commons.ChatMsg;
import Chat.commons.Message;
import javafx.beans.property.SimpleStringProperty;

public class Model {
	protected SimpleStringProperty newestMessage = new SimpleStringProperty();
	
	private Logger logger = Logger.getLogger("");
	private Socket socket;
	private String name;
	
	public Model(){
		
	}
	
	public void connect(String ipAdress, int port, String name){
		logger.info("Connect as "+name);
		this.name = name;
		try {
			socket = new Socket(ipAdress, port);
			
			Runnable r = new Runnable() {
				
				@Override
				public void run() {
					while(true) {
						ChatMsg msg = (ChatMsg) Message.receive(socket);
						newestMessage.set(msg.getName()+": "+msg.getContent());
					}
				}
			};
			Thread t = new Thread(r);
			t.start();
		} catch (Exception e) {
			logger.warning(e.toString());
		}
	}
	
	public void disconect(){
		logger.info("Disconnect");
		if (socket != null){
			try {
				socket.close();
			} catch (IOException e) {
				logger.warning(e.toString());
			}
		}
	}
	
	public void sendMessage(String message){
		logger.info("Send mesage");
	}
	
	public String receiveMessage() {
		logger.info("Receive message");
		return newestMessage.get();
		
	}
}
