package lottoClient.source.clientApp;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;

public class ClientView extends View<ClientModel> {

	public ClientView(Stage stage, ClientModel model) {
		super(stage, model);
		
	}

	@Override
	protected Scene createGUI() {
		BorderPane root = new BorderPane();
		Label l1 = new Label("juhu!!!");
		root.setTop(l1);
		Scene scene = new Scene(root);
		return scene;
	}

}
