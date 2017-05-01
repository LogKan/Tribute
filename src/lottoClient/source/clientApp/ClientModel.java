package lottoClient.source.clientApp;

import java.util.LinkedList;

import lottoClient.source.abstractClasses.Model;

public class ClientModel extends Model{
	
	private LinkedList<Integer> selectedLottoNumber = new LinkedList<>();
	private boolean maxSeleted = false;

	public ClientModel(){
		
	}
	/**
	 * Hinzufügen und ausewerten der gewählten LottoNummern
	 */
	public void setSelectedLottoNumber(int number){
		if(selectedLottoNumber.size() < 6) {
			selectedLottoNumber.add(number);
		} else {
			maxSeleted = true;
			System.out.println("dfdf");
		}
	}
	
	public boolean getMaxSelectedLottoNumber(){
		return maxSeleted;
	}
	
}
