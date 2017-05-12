package lottoClient.source.propertiesWindow;

import java.util.logging.Logger;

import lottoClient.source.clientApp.ClientView;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class PropertiesController {
	final private PropertiesModel model;
	final private PropertiesView view;
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	Translator translator = serviceLocator.getTranslator();
	Configuration config = serviceLocator.getConfiguration();
	
	public PropertiesController(PropertiesModel model, PropertiesView view){
		this.model = model;
		this.view = view;

		view.comboBox.setOnAction(Event -> {
			serviceLocator.setTranslator(new Translator(view.comboBox.getSelectionModel().getSelectedItem().toString()));
			view.updateTexts();
		});
		
		view.bSave.setOnAction(Event -> {
			serviceLocator.getConfiguration().setLocalOption("Language", view.comboBox.getSelectionModel().getSelectedItem().toString());
			config.setLocalOption("User", view.fUser.getText());
			config.setLocalOption("Jackpot", view.fJackpot.getText());
			config.setLocalOption("MaxNumber", view.fMaxNumber.getText());
			config.setLocalOption("SelectNumber", view.fSelectNumber.getText());
			config.setLocalOption("MaxSuperNumber", view.fMaxSuperNumber.getText());
			config.setLocalOption("SelectSuperNumber", view.fSelectSuperNumber.getText());
			config.save();
			view.stop();
			view.updateTextsClientView();
		});
		
		view.bCancel.setOnAction(Event -> {
			view.stop();
		});
		
	}
}
