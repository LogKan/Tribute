package ticTacTo.source.ticTacTo;

import java.util.logging.Logger;
import ticTacTo.source.abstractClasses.Model;
import ticTacTo.source.commonClasses.ServiceLocator;



public class ClientModel extends Model{
	
	ServiceLocator serviceLocator = ServiceLocator.getServiceLocator();
	Logger logger = serviceLocator.getLogger();

	public ClientModel(){
		
	}
	
	
}

