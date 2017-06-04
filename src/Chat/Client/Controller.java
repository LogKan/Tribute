package Chat.Client;

public class Controller {
	private Model model;
	private View view;
	
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

		view.btnConnect.setOnAction(Event -> {
			view.btnConnect.setDisable(true);
			String ipAdress = view.txtIpAddress.getText();
			int port = Integer.parseInt(view.txtPort.getText());
			String name = view.txtName.getText();
			model.connect(ipAdress, port, name);
		});
		
		view.stage.setOnCloseRequest(Event -> model.disconect());
		
		view.btnSend.setOnAction(Event -> {
			model.sendMessage(view.txtChatMessage.getText());
			view.txtChatMessage.setText("");
		});
		
		model.newestMessage.addListener( (o, oldValue, newValue) -> view.txtChatArea.appendText(newValue + "\n") );
	}
}
