package chatLap.commons;

public class ChatMsg extends Message {
	String name;
	String content;
	
	public ChatMsg(String name, String content){
		super(MessageType.Chat);
		this.name = name;
		this.content = content;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getContent(){
		return this.content;
	}
	
}
