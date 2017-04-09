package lottoClient.source.splashScreen;

import javafx.concurrent.Task;
import lottoClient.source.abstractClasses.Model;

/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */

public class SplashModel extends Model{

	public SplashModel(){
		super();
	}
	
	 final Task<Void> initializer = new Task<Void>() {

		@Override
		protected Void call() throws Exception {
			// Methoden und Werte welche bearbeitet werden sollten im loading werden hier eingetragen!!
			
			// Beispielsschlaufe
			 Integer i = 0;
	            for (; i < 1000000000; i++) {
	                if ((i % 1000000) == 0)
	                    this.updateProgress(i, 1000000000);
	            }
			
			return null;
		}
		 
	 };
	 
	 public void initialize() {
		 new Thread(initializer).start();
	 }
		
}
