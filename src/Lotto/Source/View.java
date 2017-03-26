package Lotto.Source;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View {
	 private Model model;
	 private Stage stage;
	 
	 public View(Stage stage, Model model) {
	        this.stage = stage;
	        this.model = model;
	 
	 BorderPane root = new BorderPane();
	 
	 Label title = new Label("Lotto");
	 root.setTop(title);
	 
	 Scene scene = new Scene(root);
	
	 stage.setScene(scene);
	 
	 
	 }
	
	public void start() {
		stage.show();
	}
	
	public void stop() {
		stage.hide();
	}
}
