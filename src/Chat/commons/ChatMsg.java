package Chat.commons;

public class ChatMsg extends Message{

	private String name;
	private String content;
	
	public ChatMsg(String name, String content) {
		super(MessageType.Chat);
		this.name = name;
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}
}
