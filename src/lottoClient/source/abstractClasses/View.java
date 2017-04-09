package lottoClient.source.abstractClasses;

import javafx.scene.Scene;
import javafx.stage.Stage;

public abstract class View<M extends Model> {
	protected Stage stage;
	protected Scene scene;
	protected M model;
	
	protected View(Stage stage, M model){
		this.stage = stage;
		this.model = model;
		
		scene = createGUI();
		stage.setScene(scene);
	}
	
	protected abstract Scene createGUI();
	
	public void start(){
		stage.show();
	}
	
	public void stop(){
		stage.hide();
	}
	
	public Stage getStage(){
		return stage;
	}
	
	
	
	
}
