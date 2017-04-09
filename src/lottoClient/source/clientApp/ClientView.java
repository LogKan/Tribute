package lottoClient.source.clientApp;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;

public class ClientView extends View<ClientModel> {
	
	public Label l1;
	public Button b1;

	public ClientView(Stage stage, ClientModel model) {
		super(stage, model);
		
	}

	@Override
	protected Scene createGUI() {
		
		BorderPane root = new BorderPane();
		l1 = new Label();
		b1= new Button("Save");
		root.setTop(l1);
		root.setCenter(b1);
		Scene scene = new Scene(root);
		return scene;
	}

}
