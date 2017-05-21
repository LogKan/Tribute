package lottoClient.source.probabilityWindow;

import java.util.logging.Logger;

import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.ServiceLocator;

public class ProbabilityController extends Controller<ProbabilityModel, ProbabilityView> {
	
	protected ProbabilityController(ProbabilityModel model, ProbabilityView view) {
		super(model, view);
		
		view.bClosed.setOnAction(Event -> {
			view.stop();
		});

	}	
}
