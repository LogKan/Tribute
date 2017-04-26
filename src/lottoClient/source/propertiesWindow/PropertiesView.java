package lottoClient.source.propertiesWindow;

import java.util.Locale;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lottoClient.source.clientApp.ClientView;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class PropertiesView {
	ServiceLocator servicelocator = ServiceLocator.getServiceLocator();
	Logger logger = servicelocator.getLogger();
	Translator translator = servicelocator.getTranslator();
	Configuration config = servicelocator.getConfiguration();
	
	Label lLanguage = new Label();
	Label lUser = new Label();
	TextField fUser = new TextField();
	Button bSave = new Button();
	Button bCancel = new Button();
	ComboBox comboBox;
	
	private PropertiesModel model;
	private Stage stage;
	private ClientView clientView;
	
	public PropertiesView(Stage stage, PropertiesModel model, ClientView clientView){
		this.stage = stage;
		this.model = model;
		this.clientView = clientView;
		
		stage.setTitle(translator.getString("program.properties.titel"));
		BorderPane root = new BorderPane();
		GridPane gridPain = new GridPane();
		gridPain.setPadding(new Insets(10,10,10,10));
		gridPain.setVgap(10);
		gridPain.setHgap(10);
		
		lLanguage.setText(translator.getString("program.properties.lLanguage"));
		lUser.setText(translator.getString("program.properties.lUser"));
		fUser.setText(config.getOption("User"));
		
		bSave.setText(translator.getString("program.properties.bSave"));
		bCancel.setText(translator.getString("program.properties.bCancel"));
		
		ObservableList<Locale> language = FXCollections.observableArrayList(
				);
		for (Locale locale: servicelocator.getLocales()){
			language.addAll(locale);			
		}
		
		comboBox = new ComboBox(language);
		comboBox.setValue(config.getOption("Language"));
		
		gridPain.add(lLanguage,0,0);
		gridPain.add(comboBox, 1, 0);
		gridPain.add(lUser, 0, 1);
		gridPain.add(fUser, 1, 1);
		gridPain.add(bSave, 0, 3);
		gridPain.add(bCancel, 1, 3);
		
		root.setCenter(gridPain);
		
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	
	public void start(){
		stage.show();
	}
	
	public void stop(){
		stage.hide();
	}
	
	public Stage getStage(){
		return stage;
	}
	
	public void updateTexts() {
		Translator translator = ServiceLocator.getServiceLocator().getTranslator();

		// The menu entries
		stage.setTitle(translator.getString("program.properties.titel"));
		lLanguage.setText(translator.getString("program.properties.lLanguage"));
		lUser.setText(translator.getString("program.properties.lUser"));
		bSave.setText(translator.getString("program.properties.bSave"));
		bCancel.setText(translator.getString("program.properties.bCancel"));		
	}
	
	public void updateTextsClientView() {
		clientView.updateTexts();
	}

}
