package lottoClient.source.splashScreen;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.concurrent.Task;
import lottoClient.source.abstractClasses.Model;
import lottoClient.source.commonClasses.ServiceLocator;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */

public class SplashModel extends Model{
    ServiceLocator serviceLocator;

	public SplashModel(){
		super();
	}
	
	 final Task<Void> initializer = new Task<Void>() {
		@Override
		protected Void call() throws Exception {
			this.updateProgress(1, 4);
			// Methoden und Werte welche bearbeitet werden sollten im loading werden hier eingetragen!!
			
			serviceLocator = ServiceLocator.getServiceLocator();
			this.updateProgress(2, 4);
			
			serviceLocator.setLogger(configureLogging());
			this.updateProgress(3, 4);

			// Beispielsschlaufe
			 Integer i = 0;
	            for (; i < 1000000000; i++) {
	                if ((i % 1000000) == 0)
	                    this.updateProgress(i, 1000000000);
	            }			
	            this.updateProgress(4, 4);
	            return null;
		}
		 
	 };
	 
	 public void initialize() {
		 new Thread(initializer).start();
	 }
		
	 /**
	     * We create a logger with the name of the application, and attach a file
	     * handler to it. All logging should be done using this logger. Messages to
	     * this logger will also flow up to the root logger, and from there to the
	     * console-handler.
	     * 
	     * We set the level of the console-handler to "INFO", so that the console
	     * only receives the more important messages. The levels of the loggers and
	     * the file-handler are set to "FINEST".
	     */
	    private Logger configureLogging() {
	        Logger rootLogger = Logger.getLogger("");
	        rootLogger.setLevel(Level.FINEST);

	        // By default there is one handler: the console
	        Handler[] defaultHandlers = Logger.getLogger("").getHandlers();
	        defaultHandlers[0].setLevel(Level.CONFIG);

	        // Add our logger
	        Logger ourLogger = Logger.getLogger(serviceLocator.getAPP_NAME());
	        ourLogger.setLevel(Level.FINEST);
	        
	        // Add a file handler, putting the rotating files in the tmp directory
	        try {
	            Handler logHandler = new FileHandler(serviceLocator.getAPP_NAME()+".log",
	                    1000000, 9);
	            logHandler.setLevel(Level.FINEST);
	            ourLogger.addHandler(logHandler);
	        } catch (Exception e) { // If we are unable to create log files
	            throw new RuntimeException("Unable to initialize log files: "
	                    + e.toString());
	        }

	        return ourLogger;
	    }
}
