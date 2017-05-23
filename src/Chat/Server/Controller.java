package Chat.Server;

import javafx.collections.ListChangeListener;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
		
		view.btnStart.setOnAction(Event -> {
			model.startServer(Integer.parseInt(view.txtPort.getText()));
			view.btnStart.setDisable(true);
		});
		
		view.stage.setOnCloseRequest(Event ->{
			model.stopServer();
		});
		
		model.clients.addListener((ListChangeListener) Event -> {
			view.updateClients();
		});
		
	}
}
