package ticTacTo.source.ticTacTo;

import java.util.logging.Logger;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ticTacTo.source.abstractClasses.View;
import ticTacTo.source.commonClasses.ServiceLocator;
import ticTacTo.source.commonClasses.Translator;


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
		
		BorderPane root = new BorderPane();
		
		// Erstellung Scene
		root.setTop(menuBar);
		
		// Erstellen der Scene (node, L, H)
		Scene scene = new Scene(root, 600,400);
		scene.getStylesheets().add(getClass().getResource("Client.css").toExternalForm());
		return scene;
	}
	
	public void updateTexts() {
		Translator translator = ServiceLocator.getServiceLocator().getTranslator();

	}
}
