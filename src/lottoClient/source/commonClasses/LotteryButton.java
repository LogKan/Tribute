package lottoClient.source.commonClasses;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;

public class LotteryButton extends ToggleButton {

	String name;
	
	public LotteryButton(String name){
		super(name);
	}
	
	public LotteryButton(String name, Node graphic){
		super(name, graphic);
	}

	
	public void switchDisable(){

	}
	
}
