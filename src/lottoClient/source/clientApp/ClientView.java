package lottoClient.source.clientApp;

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
	
	
	public Menu file;
	public MenuItem fileProperties;
	public MenuItem fileExit;
	public Menu window;
	public MenuItem windowProbability;
	public MenuItem windowSize;
	public Menu help;
	public MenuItem helpHelp;
	public MenuItem helpAbout;	
	public Label status;
	public Label lLottoSelected;
	public Label lLottoSelectedStatus;
	public Label lLottoMachine;
	public Label lLottoMachineStatus;
	public Button play;
	public LotteryTicket t1;

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
		lLottoSelected = new Label();
		lLottoSelected.setText(translator.getString("program.main.statusDisplay.lLottoSelected"));
		lLottoSelectedStatus = new Label();
		lLottoMachine = new Label();
		lLottoMachine.setText(translator.getString("program.main.statusDisplay.lLottoMachine"));
		lLottoMachineStatus = new Label();
		gridPaneStatus.add(lLottoSelected, 1, 0);
		gridPaneStatus.add(lLottoSelectedStatus, 2, 0);
		gridPaneStatus.add(lLottoMachine, 1, 1);
		gridPaneStatus.add(lLottoMachineStatus, 2, 1);
		controlPane.getChildren().add(gridPaneStatus);
		//Play Game Button
		play = new Button();
		play.setText(translator.getString("program.main.button.play"));
		play.setDisable(true);
		play.getStyleClass().add("buttonPlay");
		
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
		file.setText(translator.getString("program.menu.file"));
		fileProperties.setText(translator.getString("program.menu.file.properties"));
		fileExit.setText(translator.getString("program.menu.file.exit"));
		window.setText(translator.getString("program.menu.window"));
		windowProbability.setText(translator.getString("program.menu.window.windowProbability"));
		if (stage.isFullScreen() == false)
		{
			windowSize.setText(translator.getString("program.menu.window.fullScreen"));
		} else {
			windowSize.setText(translator.getString("program.menu.window.minimizeScreen"));
		}
		help.setText(translator.getString("program.menu.help"));
		helpHelp.setText(translator.getString("program.menu.help.help"));
		helpAbout.setText(translator.getString("program.menu.help.about"));
		lLottoSelected.setText(translator.getString("program.main.statusDisplay.lLottoSelected"));
		lLottoMachine.setText(translator.getString("program.main.statusDisplay.lLottoMachine"));
		play.setText(translator.getString("program.main.button.play"));
	}
}
