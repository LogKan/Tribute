package lottoClient.source.commonClasses;

import java.util.LinkedList;
import java.util.logging.Logger;
import java.util.Iterator;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
/**
 * Erzeugen eines Feldes für die Auswahl von den Lottozahlen per Mausklick.
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
	private int maxNumber;
	private int maxSuperNumber;
	
	
	/**
	 * Konstruktor für das Lotto Nummernfeld.
	 */
	public LotteryTicket() {
		// Definierung Anzahl maximaler Selektionen
		this.maxNumber = Integer.parseInt(config.getOption("SelectNumber"));
		this.maxSuperNumber = Integer.parseInt(config.getOption("SelectSuperNumber"));
		// Scene Elemente
		this.lotteryNumber = new GridPane();
		this.lotteryNumber.setPadding(new Insets(10));
		this.lotteryNumber.setVgap(5);
		this.lotteryNumber.setHgap(5);

		// Generieren der Buttons in ein Array für die Event erkennung
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
		
		// Generieren der Buttons in ein Array für die Event erkennung
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
	 * Rückgabe eines kompletten Lotto Eingabefeldes.
	 * @return GridPane
	 */
	public GridPane getLotteryTicket(){
		return lotteryTicket;
	}
	
	/**
	 * Rückgabe von LotteryButtons 1-42 für Controlling
	 * @return LotteryButton[]
	 */
	public LotteryButton[] getLotteryButton(){
		return lotteryButtonNumber;
	}
	
	/**
	 * Rückgabe von SuperLotteryButtons 1-6 für Controlling
	 * @return LotteryButton[]
	 */
	public LotteryButton[] getSuperButton(){
		return lotteryButtonSuperNumber;
	}
	
	
	/**
	 * Hinzufügen und ausewerten der gewählten LottoNummern und angabe welche size die Liste haben muss
	 * @param number Nummer für hinzufügen in der Liste
	 */
	public void setSelectedLottoNumber(LotteryButton b){
			if(selectedLottoNumber.size() < this.maxNumber) {
			selectedLottoNumber.addFirst(Integer.parseInt(b.getText()));
			this.buttonStyleSwitcher(b);
		}
}
	
	/**
	 * Löschen einer Nummer aus der Liste LottoNummern
	 * @param Button
	 */
	public void setDeselectedLottoNumber(LotteryButton b){
		if(this.selectedLottoNumber.indexOf(Integer.parseInt(b.getText()))>=0) {
			this.selectedLottoNumber.remove(this.selectedLottoNumber.indexOf(Integer.parseInt(b.getText())));
			this.buttonStyleSwitcher(b);	
		}
	}
	
	/**
	 * Hinzufügen einer Nummer in die Liste LottoSuperNummern
	 * @param LotteryButton
	 */
	public void setSelectSuperNumber(LotteryButton b){
		if(getSwitchSuperNumberButton()) {
			this.selectedSuperLottoNumber.add(Integer.parseInt(b.getText()));
			this.buttonStyleSwitcher(b);
		}
	}
	
	/**
	 * Löschen einer Nummer aus der Liste LottoSuperNummern
	 * @param LotteryButton
	 */
	public void setDeselectSuperNumber(LotteryButton b){
		if (this.selectedSuperLottoNumber.contains(Integer.parseInt(b.getText()))) {
			this.selectedSuperLottoNumber.remove(this.selectedSuperLottoNumber.indexOf(Integer.parseInt(b.getText())));
			this.buttonStyleSwitcher(b);
		}
	}
	
	/**
	 * Auswerten ob die Maximalanzahl an Supernummern gewählt wurde.
	 * true = Maximum erreicht | false = maximum noch nicht erreicht. 
	 * @return boolean
	 */
	public boolean getSwitchSuperNumberButton(){
		boolean result;
		if(this.selectedSuperLottoNumber.size() < this.maxSuperNumber) {
			result = true;
		} else {
			result = false; 
		}
		return result;
}
	
	/**
	 * Ansicht des LotteryButton situativ anpassen für Selektierung.
	 * @param LotteryButton
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
	}
	
	/**
	 * Aktivieren des Play Button wen Parameter erfüllt sind.
	 * @return boolean
	 */
	public boolean setEnablePlayButton(){
		boolean play = false;
		if(this.selectedLottoNumber.size() == this.maxNumber && this.selectedSuperLottoNumber.size() == this.maxSuperNumber)
			play = true;
		return play;
	}
	
	/**
	 * Liste aller Selektierten Nummern ohne Super-Nummern
	 * @return LinkedList
	 */
	public LinkedList getSelectedLottoNumber(){
		return this.selectedLottoNumber;
	}
	 /**
	  *  * Liste aller Selektierten Super-Nummern
	  * @return LinkedList
	  */
	public LinkedList getSelectedSuperLottoNumber(){
		return this.selectedSuperLottoNumber;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getSelectedLottoNumberString(){
		String getString="";
		for(Integer i : this.selectedLottoNumber){
			getString += " ["+i+"]";
		}
		if(this.selectedSuperLottoNumber.size()>0){
			for(Integer i : this.selectedSuperLottoNumber){
				getString += " [S-"+i+"]";
			}	
		}
		
		return getString;
	}
	
}
