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
	private final int maxLottoWin6 = 1000000;
	private final int maxLottoWin5 = 1000;
	

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
		if(this.winNumber.size() >= 3) logger.info("LottoMashine: "+lottoMashine);
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
		if(this.winNumber.size() >= 3) logger.info("Win Numbers: "+result);
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
	
	/**
	 * Berechnen des Gewinnes anhand des Jackpotes
	 * @return double
	 */
	public double getCashWin(){
		double CashWin = 0.0;
		int jackpot = Integer.parseInt(serviceLocator.getConfiguration().getOption("Jackpot"));
		if(this.winNumber.size() == 6 && this.winSuperNumber.size() == 1) CashWin = jackpot;
		if(this.winNumber.size() == 6 && this.winSuperNumber.size() == 0)
			if(jackpot > this.maxLottoWin6) {
				CashWin = this.maxLottoWin6;
			} else {
				CashWin = jackpot*3.030303/100;
			}
		if(this.winNumber.size() == 5 && this.winSuperNumber.size() == 1) CashWin = jackpot*0.0303030/100;
		if(this.winNumber.size() == 5 && this.winSuperNumber.size() == 0) 
			if(jackpot > this.maxLottoWin5){
			CashWin = this.maxLottoWin5;
		} else {
			CashWin = jackpot*0.003030/100;
		}
		if(this.winNumber.size() == 4 && this.winSuperNumber.size() == 1) CashWin = jackpot*0.0004545/100;
		if(this.winNumber.size() == 4 && this.winSuperNumber.size() == 0) CashWin = jackpot*0.0002272/100;
		if(this.winNumber.size() == 3 && this.winSuperNumber.size() == 1) CashWin = jackpot*0.0004545/100;
		if(this.winNumber.size() == 3 && this.winSuperNumber.size() == 0) CashWin = jackpot*0.0000303/100;
		if(this.winNumber.size() >= 3) logger.info("CashWin: "+serviceLocator.getNumberFormatCash().format(CashWin));
		return CashWin;
	}
	
}

