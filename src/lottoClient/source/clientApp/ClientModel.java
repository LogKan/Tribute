package lottoClient.source.clientApp;

import java.util.LinkedList;
import java.util.logging.Logger;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import lottoClient.source.abstractClasses.Model;
import lottoClient.source.commonClasses.LotteryButton;
import lottoClient.source.commonClasses.LotteryTicket;
import lottoClient.source.commonClasses.LottoMashine;
import lottoClient.source.commonClasses.ServiceLocator;


public class ClientModel extends Model{
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	
	private LinkedList<Integer> winNumber;
	private LinkedList<Integer> winSuperNumber;
	
	// Anzahl zahlen
	private final int maxNumber= 6;
	private final int maxSuperNumber= 1;

	public ClientModel(){
		
	}
	
	public LottoMashine setLottoWinNumber(LotteryTicket lotteryTicket){
		LottoMashine lottoMashine = new LottoMashine();
		winNumber = new LinkedList<>();
		winSuperNumber = new LinkedList<>();
		
		for(int i=0; i < this.maxNumber ; i++){
			for(int j=0; j < this.maxNumber ; j++) {
				if(lottoMashine.getLotto().get(i) == lotteryTicket.getSelectedLottoNumber().get(j)){
					winNumber.add((Integer) lottoMashine.getLotto().get(i));
				}
			}
		}
		
		for(int i=0; i < this.maxSuperNumber ; i++){
			for(int j=0; j < this.maxSuperNumber ; j++) {
				if(lottoMashine.getLottoSuper().get(i) == lotteryTicket.getSelectedSuperLottoNumber().get(j)){
					winSuperNumber.add((Integer) lottoMashine.getLottoSuper().get(i));
				}
			}
		}
		logger.info("LottoMashine: "+lottoMashine);
		return lottoMashine;
	}
	/**
	 * Übereinstimmende normale Zahlen zwischen Auswahl und LottoMaschine
	 * @return LinkedList
	 */
	public LinkedList getWinNumber(){
		return winNumber;
	}
	/**
	 * Übereinstimmende super Zahlen zwischen Auswahl und LottoMaschine
	 * @return LinkedList
	 */
	public LinkedList getWinSuperNumber(){
		return winSuperNumber;
	}
	
	/**
	 * Ausgabe der Korrekten Nummern
	 * @return String
	 */
	public String getWinNumberString(){
		String result="";
		for(int i : this.winNumber){
			result += " "+String.format("%02d", i);
		}
		for(int i : this.winSuperNumber){
			result += " S-"+String.format("%02d", i);
		}
		logger.info("Win Numbers: "+result);
		return result;
	}
	
	/**
	 * Anzahl korrekte Nummer
	 * @return String
	 */
	public String getWinCountString(){
		String result=" ";
		if (this.winNumber.size()>0) {
			result += "N: "+this.winNumber.size();
		}else{
			result += "N: 0";
		}
		if (this.winSuperNumber.size()>0) {
			result += " S: "+this.winSuperNumber.size();
		}else{
			result += " S: 0";
		}
		return result;
	}
	
}

