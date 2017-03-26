package Lotto.Source;

import java.util.Locale;
import java.util.logging.Logger;

import Lotto.Lotto;

public class ServiceLocator {
	private static ServiceLocator serviceLocator;
	
    // Application-global constants
    final private Class<?> APP_CLASS = Lotto.class;
    final private String APP_NAME = APP_CLASS.getSimpleName();
	
	final private Locale[] locales = new Locale[] { new Locale("en"), new Locale("de") };
	
	//Resources
    private Logger logger;
    private Translator translator;
	
	
	public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null)
            serviceLocator = new ServiceLocator();
        return serviceLocator;
    }
	
	public void setLogger(Logger logger){
		this.logger = logger;
	}
	
	public Logger getLogger(){
		return logger;
	}
	
	public Locale[] getLocales() {
        return locales;
    }
	
	public Class<?> getAPP_CLASS() {
        return APP_CLASS;
    }
    
    public String getAPP_NAME() {
        return APP_NAME;
    }
	
    public Translator getTranslator() {
        return translator;
    }

}
