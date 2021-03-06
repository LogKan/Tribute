package lottoClient.source.clientApp;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.Controller;
import lottoClient.source.commonClasses.LotteryButton;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;
import lottoClient.source.helpWindow.Help;
import lottoClient.source.probabilityWindow.ProbabilityWindow;
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
		
		view.windowProbability.setOnAction(Event -> {
				new ProbabilityWindow();
		});
		
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
			about.setGraphic(new ImageView(serviceLocator.getRessourceLogo().toString()));
			about.showAndWait();
		});

		for(LotteryButton b : view.t1.getLotteryButton()){
			b.setOnAction(Event -> {
				this.setSwitchNumber(b);
				view.lLottoSelectedStatus.setText(view.t1.getSelectedLottoNumberString());
			});
		}
		
		for (LotteryButton b : view.t1.getSuperButton()){
			b.setOnAction(Event -> {
				this.setSwitchSuperNumber(b);
				view.lLottoSelectedStatus.setText(view.t1.getSelectedLottoNumberString());
			});
		}
	
		view.play.setOnAction(Event -> {
			view.lLottoMachineStatus.setText(model.setLottoWinNumber(view.t1).toString());
			view.lWinNumberStatus.setText(model.getWinNumberString());
			view.lWinNumberCountStatus.setText(model.getWinCountString());
			view.lCashWinStatus.setText(""+serviceLocator.getNumberFormatCash().format((model.getCashWin())));
		});
		
	}

	/**
	 * Wahl und abwahl der Nummern
	 * @param LotteryButton
	 */
	private void setSwitchNumber(LotteryButton b){

			if(!b.getSelected()) {
				view.t1.setSelectedLottoNumber(b);
				b.switchSelected();
			} else {
				view.t1.setDeselectedLottoNumber(b);
				b.switchSelected();
			}
		this.setSwitchPlay();
	}
	/**
	 * Wahl und abwahl der Super-Nummern
	 * @param LotteryButton
	 */
	private void setSwitchSuperNumber(LotteryButton b){
		if(!b.getSelected()){
			view.t1.setSelectSuperNumber(b);
			b.switchSelected();
		} else {
			view.t1.setDeselectSuperNumber(b);
			b.switchSelected();
		}
		this.setSwitchPlay();
	}
	/**
	 * Aktivierung oder deaktivierung des Play Buttons in der AppView.
	 * Regel aufgrund ob alle Nummern und Super-Nummern erfasst wurden 
	 */
	private void setSwitchPlay(){
		if(view.t1.setEnablePlayButton()) {
			view.play.setDisable(false);
		} else {
			view.play.setDisable(true);
		}
	}
}
