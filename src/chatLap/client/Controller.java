package chatLap.client;

import javafx.beans.InvalidationListener;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;

public class Controller {
	
	private Model model;
	private View view;
	
	public Controller(Model model, View view){
		this.model = model;
		this.view = view;
	
		view.btnConnect.setOnAction(Event ->{
			String ipAddress = view.txtIpAddress.getText();
			int port = Integer.parseInt(view.txtPort.getText());
			String name = view.txtName.getText();
			model.connect(ipAddress, port, name);
			view.btnConnect.setDisable(true);
		});
		
		view.stage.setOnCloseRequest(Event -> {
			model.disconnect();
		});
		
		view.btnSend.setOnAction(Event -> {
			String message = view.txtChatMessage.getText();
			model.sendMessage(message);
			view.txtChatMessage.clear();
		});
		
		model.newestMessage.addListener((old, oldvalue, newValue) -> {
			view.txtChatArea.setText(newValue+"\n");
		});
		
	
	}

}
