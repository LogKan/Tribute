package lottoClient.source.commonClasses;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class LotteryButton extends Button {

	String name;
	boolean selected;
	
	public LotteryButton(String name){
		super(name);
		this.selected = false;
	}
	
	public LotteryButton(String name, Node graphic){
		super(name, graphic);
		this.selected = false;
	}
	
	public boolean getSelected(){
		return this.selected;
	}

	
	public void switchSelected(){
		if(this.selected) {
			this.selected = false;
		} else {
			this.selected = true;
		}
	}
	
}
