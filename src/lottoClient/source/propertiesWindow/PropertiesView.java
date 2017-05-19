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
	
	protected Label lLanguage = new Label();
	protected Label lUser = new Label();
	protected TextField fUser = new TextField();
	protected Button bSave = new Button();
	protected Button bCancel = new Button();
	protected ComboBox comboBox;
	protected Label lJackpot = new Label();
	protected TextField fJackpot = new TextField();
	protected Label lMaxNumber = new Label();
	protected TextField fMaxNumber = new TextField();
	protected Label lSelectNumber = new Label();
	protected TextField fSelectNumber= new TextField();
	protected Label lMaxSupernumber = new Label();
	protected TextField fMaxSuperNumber = new TextField();
	protected Label lSelectSuperNumber = new Label();
	protected TextField fSelectSuperNumber = new TextField();
	protected Label lStatus = new Label();
	
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
		lJackpot.setText(translator.getString("program.properties.lJackpot"));
		fJackpot.setText(config.getOption("Jackpot"));

		bSave.setText(translator.getString("program.properties.bSave"));
		bCancel.setText(translator.getString("program.properties.bCancel"));
		
		ObservableList<Locale> language = FXCollections.observableArrayList(
				);
		for (Locale locale: servicelocator.getLocales()){
			language.addAll(locale);			
		}
		
		comboBox = new ComboBox(language);
		comboBox.setValue(config.getOption("Language"));
		
		lMaxNumber.setText(translator.getString("program.properties.lMaxNumber"));
		fMaxNumber.setText(config.getOption("MaxNumber"));
		lSelectNumber.setText(translator.getString("program.properties.lSelectNumber"));
		fSelectNumber.setText(config.getOption("SelectNumber"));
		lMaxSupernumber.setText(translator.getString("program.properties.lMaxSuperNumber"));
		fMaxSuperNumber.setText(config.getOption("MaxSuperNumber"));
		lSelectSuperNumber.setText(translator.getString("program.properties.lSelectSuperNumber"));
		fSelectSuperNumber.setText(config.getOption("SelectSuperNumber"));
		/**
		fMaxNumber.setDisable(true);
		fSelectNumber.setDisable(true);
		fMaxSuperNumber.setDisable(true);
		fSelectSuperNumber.setDisable(true);
		**/
		gridPain.add(lLanguage,0,0);
		gridPain.add(comboBox, 1, 0);
		gridPain.add(lUser, 0, 1);
		gridPain.add(fUser, 1, 1);
		gridPain.add(lJackpot, 0, 2);
		gridPain.add(fJackpot, 1, 2);	
		gridPain.add(lMaxNumber, 0, 3);
		gridPain.add(fMaxNumber, 1, 3);
		gridPain.add(lSelectNumber, 0, 4);
		gridPain.add(fSelectNumber, 1, 4);
		gridPain.add(lMaxSupernumber, 0, 5);
		gridPain.add(fMaxSuperNumber, 1, 5);
		gridPain.add(lSelectSuperNumber, 0, 6);
		gridPain.add(fSelectSuperNumber, 1, 6);
		gridPain.add(bSave, 0, 7);
		gridPain.add(bCancel, 1, 7);
		
		root.setCenter(gridPain);
		root.setBottom(lStatus);
		
		
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
		lJackpot.setText(translator.getString("program.properties.lJackpot"));
		lMaxNumber.setText(translator.getString("program.properties.lMaxNumber"));
		lSelectNumber.setText(translator.getString("program.properties.lSelectNumber"));
		lMaxSupernumber.setText(translator.getString("program.properties.lMaxSuperNumber"));
		lSelectSuperNumber.setText(translator.getString("program.properties.lSelectSuperNumber"));
		bSave.setText(translator.getString("program.properties.bSave"));
		bCancel.setText(translator.getString("program.properties.bCancel"));
	}
	
	public void updateTextsClientView() {
		clientView.updateTexts();
	}

}
