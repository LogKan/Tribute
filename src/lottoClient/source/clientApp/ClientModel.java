package lottoClient.source.clientApp;

import java.util.LinkedList;
import java.util.logging.Logger;

import lottoClient.source.abstractClasses.Model;
import lottoClient.source.commonClasses.LotteryButton;
import lottoClient.source.commonClasses.ServiceLocator;


public class ClientModel extends Model{
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	// Anzahl zahlen
	private final int size= 6;
	
	private LinkedList<Integer> selectedLottoNumber = new LinkedList<>();
	private boolean maxSeleted;

	public ClientModel(){
		
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
	
	public void getWin(){
		
	}
	
	

}
