package lottoClient.source.commonClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.logging.Logger;

public class JackpotUpdater {
	
	private static JackpotUpdater jackpotUpdater;
	private Logger logger;
	private String urlString = "https://www.swisslos.ch/de/home.html";
	private String indexRowString = "jackpot___value cf";
	private String indexColummString = "data-jackpot=";
	private String jackpot = "0";
	
    public static JackpotUpdater getJackpotUpdater() {
        if (jackpotUpdater == null)
        	jackpotUpdater = new JackpotUpdater();
        return jackpotUpdater;
    } 
    
    public JackpotUpdater(){
    }
	
	private void setJackpotUpdate(){
		logger = ServiceLocator.getServiceLocator().getLogger();
		URL url = null;
		BufferedReader inReader = null;
		String lineIn;
		LinkedList<String> list = new LinkedList<>();
		
		try {
			url = new URL(urlString);
			URLConnection con = url.openConnection();
			InputStreamReader isr = new InputStreamReader(con.getInputStream());
			inReader = new BufferedReader(isr);

	        while ((lineIn = inReader.readLine()) != null) {
	        	//Suche nach der richtigen Zeile
	        	if(lineIn.contains(indexRowString))
	        		list.add(lineIn);
	        }
	        	
			String lottoString = list.getFirst().trim();
			int intPosition = lottoString.lastIndexOf(indexColummString);
			jackpot = lottoString.substring(intPosition+indexColummString.length()+1, lottoString.length()-2);
			logger.info("Jackpot Web update successful"); 
			} catch (Exception e) {
				logger.warning("Connection Failed "+e);
			} finally {
				if(inReader !=  null)
					try {
						inReader.close();
					} catch (IOException e) {
						logger.warning("BufferedReader Faild "+e);
					}
					
		}
	}
	
	public String getJackpot(){
			this.setJackpotUpdate();					
		return this.jackpot;		
	}
}
	
