package lottoClient.source.commonClasses;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Logger;

import lottoClient.LottoClientApp;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * The singleton instance of this class provide central storage for resources
 * used by the program. It also defines application-global constants, such as
 * the application name.
 * 
 * @author Brad Richards
 */

public class ServiceLocator {
	private static ServiceLocator serviceLocator;
	
	// Application-global constants
    final private Class<?> APP_CLASS = LottoClientApp.class;
    final private String APP_NAME = APP_CLASS.getSimpleName();
    private String ressourceLogo;
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    // Unterstütze Sprachen (for translations)
    final private Locale[] locales = new Locale[] { new Locale("en", "CH", "English"), new Locale("de", "CH", "German") };

    //Resources
    private Logger logger;
    private Configuration configuration;
    private Translator translator;
    private LottoClientApp app;
    
    public static ServiceLocator getServiceLocator() {
        if (serviceLocator == null)
            serviceLocator = new ServiceLocator();
        return serviceLocator;
    } 

    private ServiceLocator() {
        // Standart kunstruktur 
    }
    
    public Class<?> getAPP_CLASS() {
        return this.APP_CLASS;
    }
    
    public String getAPP_NAME() {
        return this.APP_NAME;
    }
    
    public Logger getLogger() {
        return this.logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    
    public Configuration getConfiguration() {
        return this.configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }
    
    public Locale[] getLocales() {
        return locales;
    }
    
    public Translator getTranslator() {
        return translator;
    }
    
    public void setTranslator(Translator translator) {
        this.translator = translator;
    }
    
    public void setRessourceLogo(String ressource){
    	this.ressourceLogo = ressource;
    }
    
    public String getRessourceLogo(){
    	return this.ressourceLogo;
    }
    
    public NumberFormat getNumberFormatCash(){
    	return this.nf;
    }
    
    public String getJackpot(){
    	return JackpotUpdater.getJackpotUpdater().getJackpot();
    }
}
