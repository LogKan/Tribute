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
	 * Übergabe der Liste mit den selektierten lottonummern.
	 * @return LinkedList
	 */
	public LinkedList getSelectedLottoNumber(){
		return this.selectedLottoNumber;
	}
	
	public void getWin(){
		
	}
	
	

}
