package lottoClient.source.commonClasses;

import javafx.scene.control.Button;

public class LotteryButton extends Button {
	
	/**
	 * Konstruktor �ber LotteryButton(String name) oder (LotteryButton(String name, ButtonTyps type) m�glich.
	 * 
	 * Werte f�r Type:
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
	 * * Werte f�r Type:
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
