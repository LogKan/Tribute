package ticTacTo.source.ticTacTo;

import javafx.scene.control.Button;
import ticTacTo.source.abstractClasses.Controller;
import ticTacTo.source.commonClasses.ServiceLocator;
import ticTacTo.source.commonClasses.Translator;

public class ClientController extends Controller<ClientModel, ClientView>{
	
	ServiceLocator serviceLocator;
	Translator translator;

	public ClientController(ClientModel model, ClientView view) {
		super(model, view);
		
		serviceLocator = ServiceLocator.getServiceLocator();
		translator = serviceLocator.getTranslator();
		
		for(Button b : view.playGround) {
			b.setOnInputMethodTextChanged(Event -> {
				b.setText("X");
				b.getStyleClass().add("bPlayGround");
			});
		}
		
	
	}
}
