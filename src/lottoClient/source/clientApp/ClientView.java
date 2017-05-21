package lottoClient.source.clientApp;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Logger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;
import lottoClient.source.commonClasses.LotteryButton;
import lottoClient.source.commonClasses.LotteryTicket;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class ClientView extends View<ClientModel> {
	
	
	protected Menu file;
	protected MenuItem fileProperties;
	protected MenuItem fileExit;
	protected Menu window;
	protected MenuItem windowProbability;
	protected MenuItem windowSize;
	protected Menu help;
	protected MenuItem helpHelp;
	protected MenuItem helpAbout;	
	protected Label status;
	protected Label lLottoSelected;
	protected Label lLottoSelectedStatus;
	protected Label lLottoMachine;
	protected Label lLottoMachineStatus;
	protected Label lWinNumber;
	protected Label lWinNumberStatus;
	protected Label lWinNumberCount;
	protected Label lWinNumberCountStatus;
	protected Label lJackpot;
	protected Label lJackpotStatus;
	protected Label lCashWin;
	protected Label lCashWinStatus;
	protected Button play;
	protected LotteryTicket t1;

	public ClientView(Stage stage, ClientModel model) {
		super(stage, model);	
	}

	@Override
	protected Scene createGUI() {
		ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
		Logger logger = serviceLocator.getLogger();
		Translator translator = serviceLocator.getTranslator();
		
		stage.setTitle(translator.getString("program.name"));
		
		MenuBar menuBar = new MenuBar();
		file = new Menu(translator.getString("program.menu.file"));
		fileProperties = new MenuItem(translator.getString("program.menu.file.properties"));
		fileExit = new MenuItem(translator.getString("program.menu.file.exit"));
		
		window = new Menu(translator.getString("program.menu.window"));
		windowProbability = new MenuItem();
		windowProbability.setText(translator.getString("program.menu.window.windowProbability"));
		windowSize = new MenuItem();
		if (stage.isFullScreen() == false)
		{
			windowSize.setText(translator.getString("program.menu.window.fullScreen"));
		} else {
			windowSize.setText(translator.getString("program.menu.window.minimizeScreen"));
		}
		
		help = new Menu(translator.getString("program.menu.help"));
		helpHelp = new MenuItem(translator.getString("program.menu.help.help"));
		helpAbout = new MenuItem(translator.getString("program.menu.help.about"));
		
		file.getItems().addAll(fileProperties,fileExit);
		window.getItems().addAll(windowProbability, windowSize);
		
		help.getItems().addAll(helpHelp,helpAbout);
		
		menuBar.getMenus().addAll(file, window, help);
		
		status = new Label("Status");
		GridPane gridPaneNumber = new GridPane();
		GridPane gridPaneStatus = new GridPane();
		VBox controlPane = new VBox();
		HBox display = new HBox();
		
		// Option für eine Schlaufe wenn mehrere Tippmöglichkeiten integriert werden.
		t1 =  new LotteryTicket();
		gridPaneNumber.add(t1.getLotteryTicket(), 0, 0);
		
		
		
		// Status Display
		this.lLottoSelected = new Label();
		this.lLottoSelected.setText(translator.getString("program.main.statusDisplay.lLottoSelected"));
		this.lLottoSelectedStatus = new Label();
		this.lLottoMachine = new Label();
		this.lLottoMachine.setText(translator.getString("program.main.statusDisplay.lLottoMachine"));
		this.lLottoMachineStatus = new Label();
		this.lWinNumber = new Label();
		this.lWinNumber.setText(translator.getString("program.main.statusDisplay.lWinNumber"));
		this.lWinNumberStatus = new Label();
		this.lWinNumberCount = new Label();
		this.lWinNumberCount.setText(translator.getString("program.main.statusDisplay.lWinNumberCount"));
		this.lWinNumberCountStatus = new Label();
		this.lJackpot = new Label();
		this.lJackpot.setText(translator.getString("program.main.statusDisplay.lJackpot"));
		this.lJackpotStatus = new Label();
		this.lJackpotStatus.setText(serviceLocator.getNumberFormatCash().format(Integer.parseInt(serviceLocator.getConfiguration().getOption("Jackpot"))));
		this.lCashWin = new Label();
		this.lCashWin.setText(translator.getString("program.main.statusDisplay.lCashWin"));
		this.lCashWinStatus = new Label();
	
		gridPaneStatus.add(this.lLottoSelected, 1, 0);
		gridPaneStatus.add(this.lLottoSelectedStatus, 2, 0);
		gridPaneStatus.add(this.lLottoMachine, 1, 1);
		gridPaneStatus.add(this.lLottoMachineStatus, 2, 1);
		gridPaneStatus.add(this.lWinNumber, 1, 2);
		gridPaneStatus.add(this.lWinNumberStatus, 2, 2);
		gridPaneStatus.add(this.lWinNumberCount, 1, 3);
		gridPaneStatus.add(this.lWinNumberCountStatus, 2, 3);
		gridPaneStatus.add(this.lJackpot, 1, 4);
		gridPaneStatus.add(this.lJackpotStatus, 2, 4);
		gridPaneStatus.add(this.lCashWin, 1, 5);
		gridPaneStatus.add(this.lCashWinStatus, 2, 5);
		controlPane.getChildren().add(gridPaneStatus);
		//Play Game Button
		this.play = new Button();
		this.play.setText(translator.getString("program.main.button.play"));
		this.play.setDisable(true);
		this.play.getStyleClass().add("buttonPlay");
		
		controlPane.getChildren().add(play);
		
		display.getChildren().add(gridPaneNumber);
		display.getChildren().add(controlPane);
		
		BorderPane root = new BorderPane();
		
		// Erstellung Scene
		root.setTop(menuBar);
		root.setCenter(display);
		root.setBottom(status);
		
		// Erstellen der Scene (node, L, H)
		Scene scene = new Scene(root, 600,400);
		scene.getStylesheets().add(getClass().getResource("Client.css").toExternalForm());
		return scene;
	}
	
	public void updateTexts() {
		Translator translator = ServiceLocator.getServiceLocator().getTranslator();

		// The menu entries
		this.file.setText(translator.getString("program.menu.file"));
		this.fileProperties.setText(translator.getString("program.menu.file.properties"));
		this.fileExit.setText(translator.getString("program.menu.file.exit"));
		this.window.setText(translator.getString("program.menu.window"));
		this.windowProbability.setText(translator.getString("program.menu.window.windowProbability"));
		if (stage.isFullScreen() == false)
		{
			this.windowSize.setText(translator.getString("program.menu.window.fullScreen"));
		} else {
			this.windowSize.setText(translator.getString("program.menu.window.minimizeScreen"));
		}
		this.help.setText(translator.getString("program.menu.help"));
		this.helpHelp.setText(translator.getString("program.menu.help.help"));
		this.helpAbout.setText(translator.getString("program.menu.help.about"));
		this.lLottoSelected.setText(translator.getString("program.main.statusDisplay.lLottoSelected"));
		this.lLottoMachine.setText(translator.getString("program.main.statusDisplay.lLottoMachine"));
		this.lJackpot.setText(translator.getString("program.main.statusDisplay.lJackpot"));
		this.play.setText(translator.getString("program.main.button.play"));
	}
}
