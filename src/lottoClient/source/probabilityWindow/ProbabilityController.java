package lottoClient.source.probabilityWindow;

import java.util.logging.Logger;

import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.ServiceLocator;

public class ProbabilityController extends Controller<ProbabilityModel, ProbabilityView> {
	
	ServiceLocator serviceLocator;
	Logger logger;

	protected ProbabilityController(ProbabilityModel model, ProbabilityView view) {
		super(model, view);
		
		serviceLocator = ServiceLocator.getServiceLocator();
		logger = serviceLocator.getLogger();
		
		view.bClosed.setOnAction(Event -> {
			view.stop();
			logger.info("Closed Probability");
		});

	}	
}
