package manage.entity;

import java.io.Serializable;

public class Chat implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String uno;
	private String chat_time;
	private String content;
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getChat_time() {
		return chat_time;
	}
	public void setChat_time(String chatTime) {
		chat_time = chatTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Chat(String uno, String chatTime, String content) {
		super();
		this.uno = uno;
		chat_time = chatTime;
		this.content = content;
	}
	public Chat() {
		super();
	}
	@Override
	public String toString() {
		return "Chat [chat_time=" + chat_time + ", content=" + content
				+ ", uno=" + uno + "]";
	}
}
