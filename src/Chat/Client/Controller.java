package Chat.Client;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		view.btnConnect.setOnAction(Event -> {
			if(true) {
			String ipAdress = view.txtIpAddress.getText();
			int port = Integer.parseInt(view.txtPort.getText());
			String name = view.txtName.getText();
			model.connect(ipAdress, port, name);
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.showAndWait();
			}
		});
		
		view.stage.setOnCloseRequest(Event -> model.disconect());
		
		view.btnSend.setOnAction(Event -> {
			model.sendMessage(view.txtChatMessage.getText());
			view.txtChatMessage.setText("");
		});
		
		model.newestMessage.addListener( (o, oldValue, newValue) -> view.txtChatArea.appendText(newValue) );
	}
}
