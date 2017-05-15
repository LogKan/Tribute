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
	
	private LinkedList<Integer> winNumber;
	private LinkedList<Integer> winSuperNumber;
	
	// Anzahl zahlen
	private final int maxNumber= 6;
	private final int maxSuperNumber= 1;

	public ClientModel(){
		
	}
	
	public void setLottoWinNumber(LotteryTicket lotteryTicket){
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
				if(lottoMashine.getLotto().get(i) == lotteryTicket.getSelectedSuperLottoNumber().get(j)){
					winSuperNumber.add((Integer) lottoMashine.getLotto().get(i));
				}
			}
		}
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
}
