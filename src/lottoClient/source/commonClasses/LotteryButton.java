package lottoClient.source.commonClasses;

import javafx.scene.control.Button;

public class LotteryButton extends Button {
	
	/**
	 * Konstruktor über LotteryButton(String name) oder (LotteryButton(String name, ButtonTyps type) möglich.
	 * 
	 * Werte für Type:
	 * number
	 * superNumber
	 * @author Fernando Stutz
	 *
	 */
	private String name;
	private String type;
	private boolean selected;
	/**
	 * Generieren von Lottobutton
	 * @param name
	 */
	public LotteryButton(String name){
		super(name);
		this.selected = false;
	}
	/**
	 * Generieren von Lottobutton
	 * * Werte für Type:
	 * number
	 * superNumber
	 * @param name
	 * @param type
	 */
	public LotteryButton(String name, String type){
		super(name);
		this.selected = false;
		this.type = type;
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
	
	public void setTyp(String type){
		this.type = type;
	}
	
	public String getTyp(){
		return this.type;
	}
	
}
