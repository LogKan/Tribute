package lottoClient.source.clientApp;

import java.util.logging.Logger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class ClientView extends View<ClientModel> {
	
	public Label l1;
	public Button b1;
	public Button b2;
	public Button b3;
	public Menu file;
	public MenuItem fileProperties;
	public MenuItem fileExit;
	public Menu window;
	public MenuItem windowSize;
	

	public ClientView(Stage stage, ClientModel model) {
		super(stage, model);
		
	}

	@Override
	protected Scene createGUI() {
		ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
		Logger logger = serviceLocator.getLogger();
		Translator translator = serviceLocator.getTranslator();
		
		BorderPane root = new BorderPane();
		l1 = new Label(translator.getString("program.menu.file"));
		b1= new Button("save");
		b2= new Button("de");
		b3= new Button("en");
		
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
		
		file.getItems().addAll(fileProperties,fileExit);
		window.getItems().addAll(windowSize);
		menuBar.getMenus().addAll(file, window);
		
		root.setTop(menuBar);
		root.setBottom(l1);
		HBox hBox = new HBox();
		hBox.getChildren().addAll(b1,b2,b3);
		root.setCenter(hBox);
		
		Scene scene = new Scene(root);
		return scene;
	}
	
	protected void updateTexts() {
		Translator translator = ServiceLocator.getServiceLocator().getTranslator();

		// The menu entries
		l1.setText(translator.getString("program.menu.file"));
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
	}

}
