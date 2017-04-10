package lottoClient.source.clientApp;

import lottoClient.LottoClientApp;
import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;

public class ClientController extends Controller<ClientModel, ClientView> {
	
	ServiceLocator serviceLocator;

	public ClientController(ClientModel model, ClientView view) {
		super(model, view);
		
		serviceLocator = serviceLocator.getServiceLocator();
		view.l1.setText(serviceLocator.getConfiguration().getOption("User"));
		
		view.b1.setOnAction(Event -> {
			serviceLocator.getConfiguration().save();
		});
		
	}



}
