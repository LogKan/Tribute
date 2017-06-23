package chatLap.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	
	private Logger logger = Logger.getLogger("");
	protected ObservableList<Client> clients = FXCollections.observableArrayList();
	private ServerSocket listener;
	private boolean stop = false;
	
	public Model(){
		
	}
	
	public void start(int port){
		try {
			listener = new ServerSocket(port, 10, null);
			Runnable r = new Runnable(){

				@Override
				public void run() {
					while(!stop){
						try {
							Socket socket = listener.accept();
							Client client = new Client(socket);
							clients.add(client);
						} catch (Exception e) {
						}
					}
					
				}
				
			};
			Thread t = new Thread(r, "Socket");
			t.start();
		} catch (IOException e) {
		}
		logger.info("Start Server");
	}
	
	public void stop(){
		for (Client c : clients) {
			c.stop();
		}
		stop = true;
		if (this.listener != null) {
			try {
				listener.close();
			} catch (IOException e) {
			}
			logger.info("Stop Server");
		}
	}
	
	public ObservableList<Client> getClientList(){
		logger.info("getClient List");
		return clients;
	}
}
