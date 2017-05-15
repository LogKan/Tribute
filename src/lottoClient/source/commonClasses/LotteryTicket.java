package lottoClient.source.commonClasses;

import java.util.LinkedList;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
/**
 * Erzeugen eines Feldes f�r die Auswahl von den Lottozahlen per Mausklick.
 * Erzeugt ein Feld von 1-42 Buttons
 * @author Kaneda
 *
 */
public class LotteryTicket extends GridPane{
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	Configuration config = serviceLocator.getConfiguration();
	
	private GridPane lotteryTicket;
	private GridPane lotteryNumber;
	private GridPane superNumber;
	private LotteryButton lotteryButtonNumber[] = new LotteryButton[Integer.parseInt(config.getOption("MaxNumber"))];
	private LotteryButton lotteryButtonSuperNumber[] = new LotteryButton[Integer.parseInt(config.getOption("MaxSuperNumber"))];
	private LinkedList<Integer> selectedLottoNumber = new LinkedList<>();
	private LinkedList<Integer> selectedSuperLottoNumber = new LinkedList<>();
	private boolean SuperNumberSelectet;
	
	// Anzahl zahlen
	private final int maxNumber= 6;
	private final int maxSuperNumber= 1;
	
	
	/**
	 * Konstruktor f�r das Lotto Nummernfeld.
	 */
	public LotteryTicket() {
		
		this.lotteryNumber = new GridPane();
		this.lotteryNumber.setPadding(new Insets(10));
		this.lotteryNumber.setVgap(5);
		this.lotteryNumber.setHgap(5);

		// Generieren der Buttons in ein Array f�r die Event erkennung
		for(int i=0 ; i < lotteryButtonNumber.length ; i++) {
			lotteryButtonNumber[i] = new LotteryButton(Integer.toString(i+1), "number");
			lotteryButtonNumber[i].setId("buttonLotto");
			lotteryNumber.add(lotteryButtonNumber[i],i%6, i/6);
		}

		this.lotteryTicket = new GridPane();
		this.lotteryTicket.add(this.lotteryNumber, 0, 0);
		this.lotteryTicket.add(this.superNumber(), 0, 1);
		
	}
	
	/**
	 * Generieren der Superzahlen
	 * @return GridPane
	 */
	private GridPane superNumber(){
		this.superNumber = new GridPane();
		this.superNumber.setPadding(new Insets(10));
		this.superNumber.setVgap(5);
		this.superNumber.setHgap(5);
		
		// Generieren der Buttons in ein Array f�r die Event erkennung
				for(int i=0 ; i < lotteryButtonSuperNumber.length ; i++) {
					lotteryButtonSuperNumber[i] = new LotteryButton(Integer.toString(i+1), "superNumber");
					lotteryButtonSuperNumber[i].setId("buttonLottoRadius");
				}
				
				// ADD GridPain
				for (int i = 0; i < lotteryButtonSuperNumber.length; i++) {
					superNumber.add(lotteryButtonSuperNumber[i],i%6, i/6);
				}
		return this.superNumber;
	}
	
	/**
	 * R�ckgabe eines kompletten Lotto Eingabefeldes.
	 * @return GridPane
	 */
	public GridPane getLotteryTicket(){
		return lotteryTicket;
	}
	
	/**
	 * R�ckgabe von LotteryButtons 1-42 f�r Controlling
	 * @return LotteryButton[]
	 */
	public LotteryButton[] getLotteryButton(){
		return lotteryButtonNumber;
	}
	
	/**
	 * R�ckgabe von SuperLotteryButtons 1-6 f�r Controlling
	 * @return LotteryButton[]
	 */
	public LotteryButton[] getSuperButton(){
		return lotteryButtonSuperNumber;
	}
	
	
	/**
	 * Hinzuf�gen und ausewerten der gew�hlten LottoNummern und angabe welche size die Liste haben muss
	 * @param number Nummer f�r hinzuf�gen in der Liste
	 */
	public void setSelectedLottoNumber(LotteryButton b){
			if(selectedLottoNumber.size() < this.getSize()) {
			selectedLottoNumber.addFirst(Integer.parseInt(b.getText()));
			this.buttonStyleSwitcher(b);
		}
}
	
	/**
	 * L�schen einer Nummer aus der Liste LottoNummern
	 * @param number Nummer welche aus der Liste gel�scht wird
	 */
	public void setDeselectedLottoNumber(LotteryButton b){
		if(this.selectedLottoNumber.indexOf(Integer.parseInt(b.getText()))>=0) {
			this.selectedLottoNumber.remove(this.selectedLottoNumber.indexOf(Integer.parseInt(b.getText())));
			this.buttonStyleSwitcher(b);	
		}
	}

	/**
	 * �bergabe der Liste mit den selektierten lottonummern.
	 * @return LinkedList
	 */
	public LinkedList getSelectedLottoNumber(){
		return this.selectedLottoNumber;
	}
	
	public void setSelectSuperNumber(LotteryButton b){
		if(getSwitchSuperNumberButton()) {
			this.selectedSuperLottoNumber.add(Integer.parseInt(b.getText()));
			this.buttonStyleSwitcher(b);
		}
	}
	
	public void setDeselectSuperNumber(LotteryButton b){
		if (this.selectedSuperLottoNumber.contains(Integer.parseInt(b.getText()))) {
			this.selectedSuperLottoNumber.remove(this.selectedSuperLottoNumber.indexOf(Integer.parseInt(b.getText())));
			this.buttonStyleSwitcher(b);
		}
	}
	
	public boolean getSwitchSuperNumberButton(){
		boolean result;
		if(this.selectedSuperLottoNumber.size() < 1) {
			result = true;
		} else {
			result = false; 
		}
		return result;
	}
	
	/**
	 * Style Switsch
	 * @param Button
	 */
	private void buttonStyleSwitcher (LotteryButton b){
		if(b.getTyp().equals("number")) {
			if(selectedLottoNumber.contains(Integer.parseInt(b.getText()))){
				b.setId("buttonLottoSelected");
			} else {
				b.setId("buttonLotto");
			}
		} else {
			if(selectedSuperLottoNumber.contains(Integer.parseInt(b.getText()))) {
				b.setId("buttonLottoSelectedRadius");
			} else {
				b.setId("buttonLottoRadius");
			}
		}
		logger.warning(this.selectedSuperLottoNumber.toString());
	}
	
	/**
	 * 
	 * @return aktueller size Wert unter Ber�cksichtigung der Superzahl;
	 */
	private int getSize(){
		int newSize = this.maxNumber;
		if(SuperNumberSelectet)
			newSize += this.maxSuperNumber;
		return newSize;
	}
	
	public boolean setEnablePlayButton(){
		boolean play = false;
		if(this.selectedLottoNumber.size() == this.maxNumber+this.maxSuperNumber)
			play = true;
		return play;
	}
	
}
