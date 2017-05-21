package ticTacTo.source.splashScreen;

import javafx.concurrent.Worker;
import ticTacTo.TicTacTo;
import ticTacTo.source.abstractClasses.Controller;



/**
 * Copyright 2015, FHNW, Prof. Dr. Brad Richards. All rights reserved. This code
 * is licensed under the terms of the BSD 3-clause license (see the file
 * license.txt).
 * 
 * @author Brad Richards
 */

public class SplashController extends Controller<SplashModel, SplashView>{

	public SplashController(final TicTacTo main, SplashModel model, SplashView view) {
		super(model, view);
		
		// Verknüfung der Progressbar von Java FX
		view.progress.progressProperty().bind(model.initializer.progressProperty());
		
		// anhand der Fortschritte der Progressbar sehe ich wie weit die Ressourcen geladen wuren.
		
		model.initializer.stateProperty().addListener((observable, oldValue, newValue)->{
			if(newValue == Worker.State.SUCCEEDED)
				main.startApp();
		});
		
	}

}
