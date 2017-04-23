package lottoClient.source.propertiesWindow;

public class PropertiesController {
	final private PropertiesModel model;
	final private PropertiesView view;
	
	public PropertiesController(PropertiesModel model, PropertiesView view){
		this.model = model;
		this.view = view;

		view.bCancel.setOnAction(Event -> {
			view.stop();
		});
		
	}
}
