package lottoClient.source.clientApp;

import java.util.Locale;

import javafx.stage.Stage;
import lottoClient.LottoClientApp;
import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;
import lottoClient.source.propertiesWindow.PropertiesController;
import lottoClient.source.propertiesWindow.PropertiesModel;
import lottoClient.source.propertiesWindow.PropertiesView;

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
		
		view.fileProperties.setOnAction(Event -> {
			Stage propertiesStage = new Stage();
			PropertiesModel propertiesModel = new PropertiesModel();
			PropertiesView propertiesView = new PropertiesView(propertiesStage, propertiesModel);
			new PropertiesController (propertiesModel, propertiesView);
			propertiesView.start();
			
		});
		
		view.fileExit.setOnAction(Event -> {
			serviceLocator.getConfiguration().setLocalOption("Language", serviceLocator.getTranslator().getCurrentLocale().getLanguage());
			serviceLocator.getConfiguration().save();
			view.stop();
			
		});
		
	}



}
