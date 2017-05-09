package lottoClient.source.clientApp;

import java.util.LinkedList;
import java.util.Locale;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import lottoClient.LottoClientApp;
import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.LotteryButton;
import lottoClient.source.commonClasses.LottoMashine;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;
import lottoClient.source.helpWindow.Help;
import lottoClient.source.propertiesWindow.PropertiesController;
import lottoClient.source.propertiesWindow.PropertiesModel;
import lottoClient.source.propertiesWindow.PropertiesView;

public class ClientController extends Controller<ClientModel, ClientView>{
	
	ServiceLocator serviceLocator;
	Translator translator;

	public ClientController(ClientModel model, ClientView view) {
		super(model, view);
		
		serviceLocator = serviceLocator.getServiceLocator();
		translator = serviceLocator.getTranslator();
		
		
		view.windowSize.setOnAction(Event -> {
			view.setSize();
			view.updateTexts();
		});
		
		view.fileProperties.setOnAction(Event -> {
			Stage propertiesStage = new Stage();
			PropertiesModel propertiesModel = new PropertiesModel();
			PropertiesView propertiesView = new PropertiesView(propertiesStage, propertiesModel, view);
			new PropertiesController (propertiesModel, propertiesView);
			propertiesView.start();
			
		});
		
		view.fileExit.setOnAction(Event -> {
			view.stop();
			
		});
		
		view.helpHelp.setOnAction(Event -> {
			new Help();
		});
		
		view.helpAbout.setOnAction(Event -> {
			Alert about = new Alert(AlertType.INFORMATION);
			about.setTitle(translator.getString("program.menu.help.about.titel"));
			about.setHeaderText(translator.getString("program.menu.help.about.titel.header"));
			about.setContentText(translator.getString("program.menu.help.about.titel.message"));
			about.showAndWait();
		});

		for(LotteryButton b : view.t1.getLotteryButton()){
			b.setOnAction(Event -> {
				this.buttonRule(b);
				view.lLottoSelectedStatus.setText(model.getSelectedLottoNumber().toString());
			});
		}
		
		for (LotteryButton b : view.t1.getSuperButton()){
			b.setOnAction(Event -> {
				System.out.println("Hurtz "+b.getText());
			});
		}
	
		view.play.setOnAction(Event -> {
			LottoMashine lottoMashine = new LottoMashine();
			view.lLottoMachineStatus.setText(lottoMashine.getLotto().toString());
		});
		
	}

	/**
	 * Auswählen 6 Buttons mit Abwahl und neuwahl.
	 * @param b LotteryButton Klasse
	 */
	private void buttonRule(LotteryButton b){
		if(!model.getMaxSelectedLottoNumber()) {
			if(!b.getSelected()) {
				model.setSelectedLottoNumber(Integer.parseInt(b.getText()));
				b.switchSelected();
				b.setId("buttonLottoSelected");
			} else {
				model.setDeselectedLottoNumber(Integer.parseInt(b.getText()));
				b.switchSelected();
				b.setId("buttonLotto");
			}
			if (model.getMaxSelectedLottoNumber())  {
				view.play.setDisable(false);
			}
		} else {
			if(b.getSelected()) {
				model.setDeselectedLottoNumber(Integer.parseInt(b.getText()));
				b.switchSelected();
				b.setId("buttonLotto");
				model.setMaxSelectedLottoNumber();
				view.play.setDisable(true);
			}
		}	
	}


}
