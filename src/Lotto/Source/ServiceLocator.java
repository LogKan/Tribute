package Lotto.Source;

import java.util.Locale;
import java.util.logging.Logger;

public class ServiceLocator {
	private static ServiceLocator serviceLocator;
	
	final private Locale[] locales = new Locale[] { new Locale("en"), new Locale("de") };
	
	//Resources
    private Logger logger;
	
	
	public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null)
            serviceLocator = new ServiceLocator();
        return serviceLocator;
    }
	
	public void setLogger(Logger logger){
		this.logger = logger;
	}
	
	public Logger getLogger(Logger logger){
		return logger;
	}
	

}
