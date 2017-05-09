package lottoClient.source.commonClasses;

import java.util.LinkedList;
import java.util.Random;
import java.util.logging.Logger;
/**
 * Generieren von Zufallszahlen für ein Lottospiel
 * @author Kaneda
 *
 */
public class LottoMashine {
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	
	// Wie viele Zahlen werden gezogen.
	private int sizeLottoNumber = 6;
	// Anzahl Bälle in der Trommel
	private int counterBall = 42;
	// Eine Superzahl von 1 bis Definierter wert.
	private int superCounter = 6;
	private int lottoNumber;
	private int superNumber;
	private LinkedList<Integer> lottoNumberList = new LinkedList<>();
	private Random rand = new Random();
	
	/**
	 * generieren von Zufallszahlen anhand der Vorgabe.
	 * Die Letzte Zahl entspricht der Superzahl 1-6
	 * @param counter Anzahl Zahlen welche in der Lotto Trommel sind.
	 */
	public LottoMashine(){
		for (int i=0; i<sizeLottoNumber;i++){
			lottoNumber = rand.nextInt(counterBall)+1;
			if(lottoNumberList.contains(lottoNumber)) {
				i--;
			} else {
				lottoNumberList.add(lottoNumber);
			}
		}
		lottoNumberList.addLast(superNumber);
		logger.info("Lotto Machine: "+this.lottoNumberList.toString());
	}
	
	/**
	 * Superzahl generator 1-6
	 */
	{
		superNumber = rand.nextInt(superCounter)+1;
	}

	/**
	 * Rückgabe der Liste mit allen per Zuvall erstellt Zahlen
	 * @return LinkedList 
	 */
	public LinkedList getLotto(){
		return lottoNumberList;		
	}
	
	

}
