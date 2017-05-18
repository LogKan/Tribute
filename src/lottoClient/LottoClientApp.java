package lottoClient;


import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import lottoClient.source.clientApp.ClientController;
import lottoClient.source.clientApp.ClientModel;
import lottoClient.source.clientApp.ClientView;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.splashScreen.SplashController;
import lottoClient.source.splashScreen.SplashModel;
import lottoClient.source.splashScreen.SplashView;

public class LottoClientApp extends Application {

	private static LottoClientApp mainApp;
	private SplashView splashView;
	private ClientView view;
	private ServiceLocator serviceLocator; // resources, after initialization

	
	public static void main(String[] args) {
		ServiceLocator.getServiceLocator().setRessourceLogo(LottoClientApp.class.getResource("swiss_lotto_logo.png").toString());
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
	 
	 protected static LottoClientApp getMainProgram() {
	        return mainApp;
	    }

}
