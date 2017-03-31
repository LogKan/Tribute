package SplashScreen;

import Source.View;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SplashView extends View<SplashModel> {

	public SplashView(Stage stage, SplashModel model) {
        super(stage, model);
        stage.initStyle(StageStyle.TRANSPARENT); // also undecorated
    }

	@Override
	protected Scene create_GUI() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
