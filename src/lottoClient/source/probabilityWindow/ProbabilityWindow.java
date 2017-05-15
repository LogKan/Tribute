package lottoClient.source.probabilityWindow;

import javafx.stage.Stage;

public class ProbabilityWindow {	
	
	public ProbabilityWindow() {
		Stage probabilityStage = new Stage();
		
		probabilityStage.setResizable(false);
		ProbabilityModel probabilityModel = new ProbabilityModel();
		ProbabilityView probabilityView = new ProbabilityView(probabilityStage, probabilityModel);
		ProbabilityController probabilityController = new ProbabilityController(probabilityModel, probabilityView);
		probabilityView.start();
	}
}