package Lotto.Source;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View {
	 private Model model;
	 private Stage stage;
	 
	 ServiceLocator service = ServiceLocator.getServiceLocator();
	 Translator t = service.getTranslator();
	 
	 public View(Stage stage, Model model) {
	        this.stage = stage;
	        this.model = model;
	 
	 BorderPane root = new BorderPane();
	 
	 Label title = new Label("Lotto");
	 
	 // Hauptmenü Anpassen
	 MenuBar menuBar = new MenuBar();
	 Menu game = new Menu("Test");
	 Menu language = new Menu("Language");
	 
	 // menüItems
	 game.getItems().addAll(new MenuItem("Restart"), new MenuItem("Closed"));
	 language.getItems().addAll(new MenuItem("English"), new MenuItem("German"));
	 
	 menuBar.getMenus().addAll(game, language);
	 
	 root.setTop(menuBar);
	 
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
