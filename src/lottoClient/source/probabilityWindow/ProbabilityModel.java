package lottoClient.source.probabilityWindow;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import lottoClient.source.abstractClasses.Model;
import lottoClient.source.commonClasses.Configuration;
import lottoClient.source.commonClasses.ServiceLocator;

public class ProbabilityModel extends Model {
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();
	Configuration config = serviceLocator.getConfiguration();
	
	// n
	private int countLottoNumber = Integer.parseInt(config.getOption("MaxNumber"));
	// k
	private int countSelectedLottoNumber;
	// n
	private int countLottoSuperNumber = Integer.parseInt(config.getOption("MaxSuperNumber"));
	// k
	private int countSelectedSuperLottoNumber;
	private BigInteger probability;
	
	/**
	 * Konstruktor ProbabilityModel
	 */
	public ProbabilityModel(){

	}
	
	/**
	 * Warscheindlichkeitsberechung
	 * @param countSelectedLottoNumber
	 * @param countSelectedSuperLottoNumber
	 * @return String
	 */
	public String probability(int countSelectedLottoNumber, int countSelectedSuperLottoNumber)
	{
		this.countSelectedLottoNumber = countSelectedLottoNumber;
		this.countSelectedSuperLottoNumber = countSelectedSuperLottoNumber;
		
		// Berechnung der Warscheindlichkeit
		this.probability = getFactorial(this.countLottoNumber).divide(getFactorial(this.countLottoNumber-this.countSelectedLottoNumber).multiply(getFactorial(this.countSelectedLottoNumber)));
		// Berechnung der Superzahl Warscheindlochkeit inkl. Multiplikation
		this.probability = this.probability.multiply(getBinomial(this.countLottoSuperNumber, this.countSelectedSuperLottoNumber));
		DecimalFormat dec = new DecimalFormat();
		return dec.format(this.probability); 
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
}
