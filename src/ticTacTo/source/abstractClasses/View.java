package ticTacTo.source.abstractClasses;

import javafx.scene.Scene;
import javafx.stage.Stage;
import lottoClient.source.commonClasses.ServiceLocator;

public abstract class View<M extends Model> {
	
	ServiceLocator serviceLocator;
	
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
	
	public void setSize(){
		if(stage.isFullScreen() == false) {
			stage.setFullScreen(true);
		} else {
			stage.setFullScreen(false);
		}
	}
	
	// true or false
	public boolean getFullScreen(){
		return stage.isFullScreen();
	}
	
	
	
	
}
