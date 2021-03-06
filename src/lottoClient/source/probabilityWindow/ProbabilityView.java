package lottoClient.source.probabilityWindow;


import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lottoClient.source.abstractClasses.View;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class ProbabilityView extends View<ProbabilityModel>{
	
	protected ServiceLocator serviceLocator;
	protected Logger logger;
	protected Configuration config;
	protected Translator translator;
	private int countSelectedLottoNumber;
	private int countSelectedSuperLottoNumber;
	
	protected Button bClosed;
	
	protected ProbabilityView(Stage stage, ProbabilityModel model) {
		super(stage, model);

	}

	@Override
	protected Scene createGUI() {
		this.serviceLocator = serviceLocator.getServiceLocator();
		this.config = serviceLocator.getConfiguration();
		this.translator = serviceLocator.getTranslator();
		
		this.countSelectedLottoNumber = Integer.parseInt(config.getOption("SelectNumber"));
		this.countSelectedSuperLottoNumber = Integer.parseInt(config.getOption("SelectSuperNumber"));
		
		
		
		BorderPane root = new BorderPane();
		GridPane gridPane = new GridPane();
		HBox box = new HBox();
		int counter = this.countSelectedLottoNumber * (this.countSelectedSuperLottoNumber+1);
		
		Label title = new Label(translator.getString("program.propbability.title"));
		title.setId("title");
		
		gridPane.setPadding(new Insets(10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		
		for(int i=1;i<=this.countSelectedLottoNumber ;i++){
			for(int j=0;j<=this.countSelectedSuperLottoNumber ;j++){
				gridPane.add(new Label(""+i+" "), 0, counter);
				if(j>0)
					gridPane.add(new Label(""+j+" "), 1, counter);
				gridPane.add(new Label("1 : "+model.probability(i, j)),3,counter--);
			}
		}
		
		root.setTop(title);
		box.getChildren().add(gridPane);
		box.setAlignment(Pos.CENTER);
		root.setAlignment(title, Pos.CENTER);
		root.setCenter(box);
		bClosed = new Button();
		bClosed.setText(translator.getString("program.propbability.button.closed"));
		root.setBottom(bClosed);
		root.setAlignment(bClosed, Pos.TOP_CENTER);
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("probability.css").toExternalForm());
		return scene;
	}

}
