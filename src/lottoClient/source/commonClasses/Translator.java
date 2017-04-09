package lottoClient.source.commonClasses;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class Translator {
	private ServiceLocator serviceLocator;
	private Logger logger = serviceLocator.getLogger();
	
	protected Locale currentLocale;
	private ResourceBundle resourceBundle;
	
	protected Translator(String localeString){
		Locale locale = Locale.getDefault();
		if (localeString != null) {
			Locale[] availableLocales = serviceLocator.getLocales();
			for (int i =0; i < availableLocales.length; i++){
				String tmpLang = availableLocales[i].getLanguage();
				if (localeString.substring(0, tmpLang.length()).equals(tmpLang)) {
					locale = availableLocales[i];
	            	break;
	                }
			}
		}
		// Load the resource strings
        resourceBundle = ResourceBundle.getBundle(serviceLocator.getAPP_CLASS().getName(), locale);
        Locale.setDefault(locale); // Change VM default (for dialogs, etc.)
        currentLocale = locale;
        
        logger.info("Loaded resources for " + locale.getLanguage());			
	}
	 /**
     * Return the current locale; this is useful for formatters, etc.
     */
    public Locale getCurrentLocale() {
        return currentLocale;
    }
    /**
     * Public method to get string resources, default to "--" *
     */
    public String getString(String key) {
        try {
            return resourceBundle.getString(key);
        } catch (MissingResourceException e) {
            logger.warning("Missing string: " + key);
            return "--";
        }
    }
}
