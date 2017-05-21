package lottoClient.source.probabilityWindow;

import javafx.stage.Stage;
import lottoClient.source.clientApp.ClientController;

public class ProbabilityWindow extends Thread {	
	
	ProbabilityModel model;
	ProbabilityView view;
	ProbabilityController controller;
	Stage stage;
	
	public ProbabilityWindow() {
		this.stage = new Stage();
		this.stage.setResizable(false);
		this.model = new ProbabilityModel();
		this.view = new ProbabilityView(stage, model);
		this.controller = new ProbabilityController(model, view);
		this.view.start();
		
		view.getStage().setOnCloseRequest(Event ->{
		
		});
		
	}		
}