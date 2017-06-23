package chatLap.commons;

import java.util.logging.Logger;

public abstract class Message {
	
	private static Logger logger = Logger.getLogger("");
	
	private MessageType type;
	private String name;
	private String content;
	
	public Message(MessageType type){
		this.type = type;
	}
	
	public void send(){
		logger.info("Send Message");
	}
	
	public static Message receive(){
		logger.info("Receive Message");
		return null;
	}
	
	public MessageType getType(){
		return this.type;
	}
	
	

}
