package lottoClient.source.propertiesWindow;

import lottoClient.source.commonClasses.ServiceLocator;
import lottoClient.source.commonClasses.Translator;

public class PropertiesModel {
	
	protected ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	protected Translator translator = serviceLocator.getTranslator();
	
	public PropertiesModel(){
		
	}
	
	public String getNumber(PropertiesView view){
		String result = "";
		if(Integer.parseInt(view.fMaxNumber.getText()) > 50)
			result += translator.getString("program.properties.lMaxNumber")+" < 50 ";
		if(Integer.parseInt(view.fSelectNumber.getText()) > 10)
			result += translator.getString("program.properties.lSelectNumber")+" < 10 ";
		if(Integer.parseInt(view.fMaxNumber.getText()) < Integer.parseInt(view.fSelectNumber.getText()))
			result += translator.getString("program.properties.lMaxNumber") + " < " + translator.getString("program.properties.lSelectNumber")+" ";	
		if(Integer.parseInt(view.fMaxSuperNumber.getText()) > 10)
			result += translator.getString("program.properties.lMaxSuperNumber")+" < 10 ";
		if(Integer.parseInt(view.fSelectSuperNumber.getText()) > 4)
			result += translator.getString("program.properties.lSelectSuperNumber")+" < 4 ";
		if(Integer.parseInt(view.fMaxSuperNumber.getText()) < Integer.parseInt(view.fSelectSuperNumber.getText()))
			result += translator.getString("program.properties.lMaxSuperNumber") + " < " + translator.getString("program.properties.lSelectSuperNumber")+" ";
			
		return result;
	}

}
