package lottoClient.source.probabilityWindow;


import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.Probability;
import lottoClient.source.commonClasses.ServiceLocator;

public class ProbabilityView extends View<ProbabilityModel>{
	
	protected ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	protected Logger logger = serviceLocator.getLogger();
	protected Configuration config = serviceLocator.getConfiguration();
	
	

	protected ProbabilityView(Stage stage, ProbabilityModel model) {
		super(stage, model);
	}

	@Override
	protected Scene createGUI() {
		BorderPane root = new BorderPane();
		GridPane gridPane = new GridPane();
		int counter=6*2;
		
		Label title = new Label("Lotto probability");
		
		for(int i=1;i<=6 ;i++){
			for(int j=0;j<=1 ;j++){
				gridPane.add(new Label(i+"-"+j+": "+new Probability(42, i, 6, j).toString()),0,counter--);
			}
		}

		
		root.setTop(title);
		root.setCenter(gridPane);
		
		Scene scene = new Scene(root);
		return scene;
	}

}
