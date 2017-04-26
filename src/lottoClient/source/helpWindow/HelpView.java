package lottoClient.source.helpWindow;


import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import lottoClient.source.commonClasses.Browser;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class HelpView {
	ServiceLocator servicelocator = ServiceLocator.getServiceLocator();
	Logger logger = servicelocator.getLogger();
	Translator translator = servicelocator.getTranslator();
	Configuration config = servicelocator.getConfiguration();
	
	private HelpModel model;
	private Stage stage;
		
	public HelpView(Stage stage, HelpModel model){
		this.model = model;
		this.stage = stage;
		
		stage.setTitle("Help Window");
		Scene scene = new Scene(new Browser(),750,500, Color.web("#666970"));
		stage.setScene(scene);
	}
	
	public void start(){
		stage.show();
	}
	
	public void stop(){
		stage.hide();
	}
	
}
