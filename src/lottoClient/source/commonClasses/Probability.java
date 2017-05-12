package lottoClient.source.commonClasses;

import java.util.logging.Logger;

public class Probability {
	
	ServiceLocator servicelocator = ServiceLocator.getServiceLocator();
	Logger logger = servicelocator.getLogger();
	Configuration config = servicelocator.getConfiguration();
	
	public Probability(){
		
	}

}
