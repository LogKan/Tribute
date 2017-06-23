package chatLap.server;

import java.util.logging.Logger;

import javafx.collections.ListChangeListener;

public class Controller {
	
	private Model model;
	private View view;
	private Logger logger = Logger.getLogger("");
	
	public Controller(Model model, View view){
		
		view.btnStart.setOnAction(Event ->{
			model.start(Integer.parseInt(view.txtPort.getText()));
			view.btnStart.setDisable(true);
		});
		
		view.stage.setOnCloseRequest(Event -> {
			model.stop();
		});
		
		model.clients.addListener((ListChangeListener<Client>) Event -> {
			view.updateClients();
		});
			
	}

}
