package lottoClient.source.commonClasses;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
/**
 * Erzeugen eines Feldes für die Auswahl von den Lottozahlen per Mausklick.
 * Erzeugt ein Feld von 1-42 Buttons
 * @author Kaneda
 *
 */
public class LotteryTicket extends GridPane{
	
	private GridPane lotteryTicket;
	private GridPane lotteryNumber;
	private GridPane superNumber;
	private LotteryButton lotteryButtonNumber[] = new LotteryButton[42];
	private LotteryButton lotteryButtonSuperNumber[] = new LotteryButton[6];
	private int selected;
	/**
	 * Konstruktor für das Lotto Nummernfeld.
	 */
	public LotteryTicket() {
		
		this.lotteryNumber = new GridPane();
		this.lotteryNumber.setPadding(new Insets(10));
		this.lotteryNumber.setVgap(5);
		this.lotteryNumber.setHgap(5);

		// Generieren der Buttons in ein Array für die Event erkennung
		for(int i=0 ; i < lotteryButtonNumber.length ; i++) {
			lotteryButtonNumber[i] = new LotteryButton(Integer.toString(i+1));
			lotteryButtonNumber[i].getStyleClass().add("buttonLotto");
		}
		
		// ADD GridPain
		for (int i = 0; i < lotteryButtonNumber.length; i++) {
			lotteryNumber.add(lotteryButtonNumber[i],i%6, i/6);
		}
		this.lotteryTicket = new GridPane();
		this.lotteryTicket.add(this.lotteryNumber, 0, 0);
		this.lotteryTicket.add(this.superNumber(), 0, 1);
		
	}
	
	/**
	 * Rückgabe eines kompletten Lotto Eingabefeldes.
	 * @return GridPane
	 */
	public GridPane getLotteryTicket(){
		return lotteryTicket;
	}
	
	public LotteryButton[] getLotteryButton(){
		return lotteryButtonNumber;
	}
	
	public LotteryButton[] getSuperButton(){
		return lotteryButtonSuperNumber;
	}
	
	public GridPane superNumber(){
		this.superNumber = new GridPane();
		this.superNumber.setPadding(new Insets(10));
		this.superNumber.setVgap(5);
		this.superNumber.setHgap(5);
		
		// Generieren der Buttons in ein Array für die Event erkennung
				for(int i=0 ; i < lotteryButtonSuperNumber.length ; i++) {
					lotteryButtonSuperNumber[i] = new LotteryButton(Integer.toString(i+1));
					lotteryButtonSuperNumber[i].getStyleClass().add("buttonLotto");
				}
				
				// ADD GridPain
				for (int i = 0; i < lotteryButtonSuperNumber.length; i++) {
					superNumber.add(lotteryButtonSuperNumber[i],i%6, i/6);
				}
		return this.superNumber;
	}
	
}
