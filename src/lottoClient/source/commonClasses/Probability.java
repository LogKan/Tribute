package lottoClient.source.commonClasses;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.logging.Logger;
/**
 * Berechnung Lotto Warscheindlichkeit
 * Ausgabe über die toString Methode
 * @author Fernando Stutz
 * 
 */
public class Probability {
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	Configuration config = serviceLocator.getConfiguration();
	
	// n
	private int countLottoNumber;
	// k
	private int countSelectedLottoNumber;
	// n
	private int countLottoSuperNumber;
	// k
	private int countSelectedSuperLottoNumber;
	private BigInteger probability;
	
	/**
	 * Warscheindlichkeitsberechnung
	 * @param countLottoNumber
	 * @param countSelectedLottoNumber
	 * @param countLottoSuperNumber
	 * @param countSelectedSuperLottoNumber
	 */
	public Probability(int countLottoNumber, int countSelectedLottoNumber,int countLottoSuperNumber, int countSelectedSuperLottoNumber)
	{
		this.countSelectedLottoNumber = countSelectedLottoNumber;
		this.countSelectedSuperLottoNumber = countSelectedSuperLottoNumber;
		this.countLottoNumber = countLottoNumber;
		this.countLottoSuperNumber = countLottoSuperNumber;
		// Berechnung der Warscheindlichkeit
		this.probability = getFactorial(this.countLottoNumber).divide(getFactorial(this.countLottoNumber-this.countSelectedLottoNumber).multiply(getFactorial(this.countSelectedLottoNumber)));
		// Berechnung der Superzahl Warscheindlochkeit inkl. Multiplikation
		this.probability = this.probability.multiply(getBinomial(this.countLottoSuperNumber, this.countSelectedSuperLottoNumber));
	}
	
	/**
	 * Berechnung Fakultät n!
	 * @author http://stackoverflow.com/questions/8992437/stackoverflowerror-computing-factorial-of-a-biginteger
	 * @param num
	 * @return BigInteger
	 */
    private static BigInteger getFactorial(int num) {
        BigInteger fact = BigInteger.valueOf(1);
        for (int i = 1; i <= num; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        return fact;
    }
    /**
     * Berechnung Binomial
     * @author http://stackoverflow.com/questions/2201113/combinatoric-n-choose-r-in-java-math
     * @param N
     * @param K
     * @return BigInteger
     */
    private static BigInteger getBinomial(final int N, final int K) {
        BigInteger ret = BigInteger.ONE;
        for (int k = 0; k < K; k++) {
            ret = ret.multiply(BigInteger.valueOf(N-k))
                     .divide(BigInteger.valueOf(k+1));
        }
        return ret;
    }

	@Override
	/**
	 * Ausgabe mit Trennzeichen.
	 */
	public String toString() {
		DecimalFormat dec = new DecimalFormat();
		return "1:"+dec.format(this.probability);
	}


}
