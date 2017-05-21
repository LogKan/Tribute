package ticTacTo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import ticTacTo.source.commonClasses.ServiceLocator;
import ticTacTo.source.splashScreen.SplashController;
import ticTacTo.source.splashScreen.SplashModel;
import ticTacTo.source.splashScreen.SplashView;
import ticTacTo.source.ticTacTo.ClientController;
import ticTacTo.source.ticTacTo.ClientModel;
import ticTacTo.source.ticTacTo.ClientView;

public class TicTacTo extends Application {
	
	private static TicTacTo mainApp;
	private SplashView splashView;
	private ClientView view;
	private ServiceLocator serviceLocator; // resources, after initialization

	public static void main(String[] args) {
		launch(args);
	}
	
	public void init() {
        if (mainApp == null) {
        	mainApp = this;
        } else {
            Platform.exit();
        }
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Create and display the splash screen and model
        SplashModel splashModel = new SplashModel();
        splashView = new SplashView(primaryStage, splashModel);
        new SplashController(this, splashModel, splashView);
        splashView.start();

        // Display the splash screen and begin the initialization
        splashModel.initialize();
		
	}
	
	public void startApp(){
		Stage appStage = new Stage();
		ClientModel model = new ClientModel();
		view = new ClientView(appStage, model);
		new ClientController(model, view);
		
		serviceLocator = ServiceLocator.getServiceLocator();
		
		splashView.stop();
		splashView = null;
		
		view.start();
		serviceLocator.getLogger().info("Client App Start" );
	}
	
	 public void stop() {
		 //serviceLocator.getConfiguration().save();
	        if (view != null) {
	            // Make the view invisible
	            view.stop();
	        }
	 }
	 
	 protected static TicTacTo getMainProgram() {
	        return mainApp;
	    }
}
