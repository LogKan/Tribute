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
	Configuration config = serviceLocator.getConfiguration();
	
	// Wie viele Zahlen werden gezogen.
	private int sizeLottoNumber = Integer.parseInt(config.getOption("SelectNumber"));
	// Anzahl Bälle in der Trommel
	private int counterBall = Integer.parseInt(config.getOption("MaxNumber"));
	// Wie viele Super-Zahlen werden gezogen.
	private int sizeLottoSuperNumber = Integer.parseInt(config.getOption("SelectSuperNumber"));
	// Eine Superzahl von 1 bis Definierter wert.
	private int counterSuperBall = Integer.parseInt(config.getOption("MaxSuperNumber"));
	
	private int lottoNumber;
	private int superNumber;
	private LinkedList<Integer> lottoNumberList = new LinkedList<>();
	private LinkedList<Integer> lottoSuperNumberList = new LinkedList<>();
	private Random rand = new Random();
	
	/**
	 * generieren von Zufallszahlen anhand der Vorgabe.
	 * Die Letzte Zahl entspricht der definierten Superzahl.
	 * @param counter Anzahl Zahlen welche in der Lotto Trommel sind.
	 */
	public LottoMashine(){
		for (int i=0; i<this.sizeLottoNumber;i++){
			this.lottoNumber = rand.nextInt(this.counterBall)+1;
			if(this.lottoNumberList.contains(this.lottoNumber)) {
				i--;
			} else {
				this.lottoNumberList.add(lottoNumber);
			}
		}
		for (int i=0; i<this.sizeLottoSuperNumber;i++){
			this.superNumber = rand.nextInt(this.counterSuperBall)+1;
			if(this.lottoSuperNumberList.contains(this.superNumber)) {
				i--;
			} else {
				this.lottoSuperNumberList.add(superNumber);
			}
		}
	}

	/**
	 * Rückgabe der Liste mit allen per Zuvall erstellt Zahlen ohne Super-Zahlen
	 * @return LinkedList 
	 */
	public LinkedList getLotto(){
		return this.lottoNumberList;		
	}
	
	/**
	 * Rückgabe der Liste mit allen per Zuvall erstellt Super-Zahlen
	 * @return LinkedList 
	 */
	public LinkedList getLottoSuper(){
		return this.lottoSuperNumberList;		
	}
	
	
	@Override
	public String toString() {
		String toString = "";
		for (int i : this.lottoNumberList){
			toString += " "+i;
		}
		for (int i : this.lottoSuperNumberList){
			toString += " S-"+i;
		}
		return toString;
	}

}
