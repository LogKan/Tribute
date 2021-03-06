package lottoClient.source.abstractClasses;

public abstract class Controller<M extends Model, V extends View> {
	protected M model;
	protected V view;
	
	protected Controller(M model, V view) {
		this.model = model;
		this.view = view;
	}

}

