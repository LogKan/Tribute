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
	

	public ClientView(Stage stage, ClientModel model) {
		super(stage, model);
		
	}

	@Override
	protected Scene createGUI() {
		ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
		Logger logger = serviceLocator.getLogger();
		Translator translator = serviceLocator.getTranslator();
		
		
		
		BorderPane root = new BorderPane();
		l1 = new Label(translator.getString("programm.menu.file"));
		b1= new Button("save");
		b2= new Button("de");
		b3= new Button("en");
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
		l1.setText(translator.getString("programm.menu.file"));
		
	}

}
