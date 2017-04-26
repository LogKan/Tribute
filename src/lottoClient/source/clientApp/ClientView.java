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
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class ClientView extends View<ClientModel> {
	
	
	public Menu file;
	public MenuItem fileProperties;
	public MenuItem fileExit;
	public Menu window;
	public MenuItem windowSize;
	public Menu help;
	public MenuItem helpHelp;
	public MenuItem helpAbout;	
	public Button number[] = new Button[60];

	public ClientView(Stage stage, ClientModel model) {
		super(stage, model);	
	}

	@Override
	protected Scene createGUI() {
		ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
		Logger logger = serviceLocator.getLogger();
		Translator translator = serviceLocator.getTranslator();
		
		stage.setTitle(translator.getString("program.name"));
		
		BorderPane root = new BorderPane();
		
		
		
		MenuBar menuBar = new MenuBar();
		file = new Menu(translator.getString("program.menu.file"));
		fileProperties = new MenuItem(translator.getString("program.menu.file.properties"));
		fileExit = new MenuItem(translator.getString("program.menu.file.exit"));
		
		window = new Menu(translator.getString("program.menu.window"));
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
		window.getItems().addAll(windowSize);
		
		help.getItems().addAll(helpHelp,helpAbout);
		
		menuBar.getMenus().addAll(file, window, help);
		
		GridPane gridPane = new GridPane();
		
		root.setTop(menuBar);
		root.setCenter(gridPane);
		
		Scene scene = new Scene(root);
		return scene;
	}
	
	public void updateTexts() {
		Translator translator = ServiceLocator.getServiceLocator().getTranslator();

		// The menu entries
		file.setText(translator.getString("program.menu.file"));
		fileProperties.setText(translator.getString("program.menu.file.properties"));
		fileExit.setText(translator.getString("program.menu.file.exit"));
		window.setText(translator.getString("program.menu.window"));
		if (stage.isFullScreen() == false)
		{
			windowSize.setText(translator.getString("program.menu.window.fullScreen"));
		} else {
			windowSize.setText(translator.getString("program.menu.window.minimizeScreen"));
		}
		help.setText(translator.getString("program.menu.help"));
		helpHelp.setText(translator.getString("program.menu.help.help"));
		helpAbout.setText(translator.getString("program.menu.help.about"));
	}

}
