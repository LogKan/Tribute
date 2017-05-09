package lottoClient.source.commonClasses;

import java.util.LinkedList;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
/**
 * Erzeugen eines Feldes f�r die Auswahl von den Lottozahlen per Mausklick.
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
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	// Anzahl zahlen
	private final int size= 6;
	private LinkedList<Integer> selectedLottoNumber = new LinkedList<>();
	private boolean maxSeleted;
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
	 * R�ckgabe eines kompletten Lotto Eingabefeldes.
	 * @return GridPane
	 */
	public GridPane getLotteryTicket(){
		return lotteryTicket;
	}
	
	/**
	 * R�ckgabe der lotteryButtonNumber
	 * @return LotteryButton
	 */
	public LotteryButton[] getLotteryButton(){
		return lotteryButtonNumber;
	}
	
	/**
	 * R�ckgabe der getSuperButton
	 * @return LotteryButton
	 */
	public LotteryButton[] getSuperButton(){
		return lotteryButtonSuperNumber;
	}
	
	/**
	 * R�ckgabe deiner Gridpane mit den Superzahlen.
	 * @return GridPane
	 */
	public GridPane superNumber(){
		this.superNumber = new GridPane();
		this.superNumber.setPadding(new Insets(10));
		this.superNumber.setVgap(5);
		this.superNumber.setHgap(5);
		
		// Generieren der Buttons in ein Array f�r die Event erkennung
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
	/**
	 * Hinzuf�gen und ausewerten der gew�hlten LottoNummern und angabe welche size die Liste haben muss
	 * @param number Nummer f�r hinzuf�gen in der Liste
	 */
	public void setSelectedLottoNumber(int number){
		if(selectedLottoNumber.size() < size) {
			maxSeleted = false;
			selectedLottoNumber.addFirst(number);
			logger.info("select "+number+" size:"+this.selectedLottoNumber.size());
			if(selectedLottoNumber.size() == size) {
				maxSeleted = true;
			}
		}
	}
	
	/**
	 * L�schen einer Nummer aus der Liste LottoNummern
	 * @param number Nummer welche aus der Liste gel�scht wird
	 */
	public void setDeselectedLottoNumber(int number){
		if(this.selectedLottoNumber.indexOf(number)>=0)
			this.selectedLottoNumber.remove(this.selectedLottoNumber.indexOf(number));
		logger.info("deselect "+number+" size:"+this.selectedLottoNumber.size());
	}
	/**
	 * Wurden die gesamtanzahl der definierten Zahlen erfasst
	 * @return boolean
	 */
	public boolean getMaxSelectedLottoNumber(){
		return maxSeleted;
	}
	
	/**
	 * MaxSelected auf false setzen
	 */
	public void setMaxSelectedLottoNumber(){
		maxSeleted = false;
	}
	
	/**
	 * �bergabe der Liste mit den selektierten lottonummern.
	 * @return LinkedList
	 */
	public LinkedList getSelectedLottoNumber(){
		return this.selectedLottoNumber;
	}	
}
