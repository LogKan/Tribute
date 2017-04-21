package lottoClient.source.clientApp;

import java.util.Locale;

import lottoClient.LottoClientApp;
import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class ClientController extends Controller<ClientModel, ClientView> {
	
	ServiceLocator serviceLocator;

	public ClientController(ClientModel model, ClientView view) {
		super(model, view);
		
		serviceLocator = serviceLocator.getServiceLocator();
		
		view.b1.setOnAction(Event -> {
			serviceLocator.getConfiguration().setLocalOption("Language", serviceLocator.getTranslator().getCurrentLocale().getLanguage());
			serviceLocator.getConfiguration().save();
		});
		
		view.b2.setOnAction(Event -> {
			serviceLocator.setTranslator(new Translator("de"));
			view.updateTexts();
		});
		
		view.b3.setOnAction(Event -> {
			serviceLocator.setTranslator(new Translator("en"));
			view.updateTexts();
		});
		
		view.windowSize.setOnAction(Event -> {
			view.setSize();
			view.updateTexts();
		});
		
		view.fileExit.setOnAction(Event -> {
			serviceLocator.getConfiguration().setLocalOption("Language", serviceLocator.getTranslator().getCurrentLocale().getLanguage());
			serviceLocator.getConfiguration().save();
			view.stop();
			
		});
		
	}



}
