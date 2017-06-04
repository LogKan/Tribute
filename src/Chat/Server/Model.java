package Chat.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	protected ObservableList<Client> clients = FXCollections.observableArrayList();
	
	private Logger logger = Logger.getLogger("");
	private ServerSocket listener;
	private volatile boolean stop = false;
	
	public void startServer(int port){
		logger.info("Start Server");		
		try {
			listener = new ServerSocket(port, 10, null);
			Runnable r = new Runnable() {
				@Override
				public void run() {
					while(!stop){
						try {
							Socket socket = listener.accept();
							Client client = new Client(socket);
							clients.add(client);
						} catch (IOException e) {
							logger.info(e.toString());
						}
					}
				}
			};
			Thread t = new Thread(r, "ServerSocket");
			t.start();
		} catch (IOException e) {
			logger.warning(e.toString());;
		}
	}
	
	public void stopServer(){
		logger.info("Stop Server");
		for (Client c : clients) c.stop();
		this.stop = true;
		if (listener != null) {
			try {
				listener.close();
			} catch (IOException e) {
			}
		}
	}
	
	public ObservableList<Client> geClientList() {
		logger.info("Get client list");
		return clients;
	}
}
