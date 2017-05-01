package lottoClient.source.commonClasses;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class LotteryTicket extends GridPane{
	
	private GridPane lotteryTicket;
	private LotteryButton lotteryButtonNumber[] = new LotteryButton[42];
	private int selected;
	
	public LotteryTicket() {
		
		this.lotteryTicket = new GridPane();
		this.lotteryTicket.setPadding(new Insets(10));
		this.lotteryTicket.setVgap(5);
		this.lotteryTicket.setHgap(5);

		// Generieren der Buttons in ein Array für die Event erkennung
		for(int i=0 ; i < lotteryButtonNumber.length ; i++) {
			lotteryButtonNumber[i] = new LotteryButton(Integer.toString(i+1));
		}
		
		// ADD GridPain
		for (int i = 0; i < lotteryButtonNumber.length; i++) {
			lotteryTicket.add(lotteryButtonNumber[i],i%6, i/6);
		}
		
		getLotteryTicket().getStylesheets().add(getClass().getResource("LotteryTicket.css").toExternalForm());		
	}
	
	// Rückgabe des GredPain
	public GridPane getLotteryTicket(){
		return lotteryTicket;
	}
	
	public LotteryButton[] getLotteryButton(){
		return lotteryButtonNumber;
	}
}
