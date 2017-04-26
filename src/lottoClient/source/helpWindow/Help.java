package lottoClient.source.helpWindow;

import javafx.stage.Stage;

public class Help extends Thread {
	
	public Help(){
		Stage helpStage = new Stage();
		HelpModel helpModel = new HelpModel();
		HelpView helpView = new HelpView(helpStage, helpModel);
		new HelpController(helpModel, helpView);
		helpView.start();
	}

}
