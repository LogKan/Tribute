package lottoClient.source.commonClasses;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * Copyright oOracle
 * JavaFX Documentation Home
 * http://docs.oracle.com/javafx/2/webview/jfxpub-webview.htm
 */

public class Browser extends Region {
	
	ServiceLocator serviceLocator;
	Logger logger;
	Configuration config;
	URL url;
	
	final WebView browser = new WebView();
    final WebEngine webEngine = browser.getEngine();
    
    public Browser(){
    	serviceLocator = ServiceLocator.getServiceLocator();
    	logger = serviceLocator.getLogger();
    	
    	
    	//apply the styles
        getStyleClass().add("browser");
        // load the web page
        try {
			url = new URL("https://www.google.ch");
		} catch (MalformedURLException e) {
			logger.warning("Error URL");
		}
        webEngine.load(url.toString());
        //add the web view to the scene
        getChildren().add(browser);
    }
    
    private Node createSpacer() {
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        return spacer;
    }
    
    @Override protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser,0,0,w,h,0, HPos.CENTER, VPos.CENTER);
    }
 
    @Override protected double computePrefWidth(double height) {
        return 750;
    }
 
    @Override protected double computePrefHeight(double width) {
        return 500;
    }
    
}
