package lottoClient.source.probabilityWindow;

import javafx.application.Platform;
import javafx.stage.Stage;

public class ProbabilityWindow extends Thread {	
	
	protected static ProbabilityWindow main;
	
	public ProbabilityWindow() {
		Stage probabilityStage = new Stage();
		probabilityStage.setResizable(false);
		ProbabilityModel probabilityModel = new ProbabilityModel();
		ProbabilityView probabilityView = new ProbabilityView(probabilityStage, probabilityModel);
		ProbabilityController probabilityController = new ProbabilityController(probabilityModel, probabilityView);
		probabilityView.start();	
	}	
}