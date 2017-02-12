package net.remind.Model;


public class Message {
	String user_key;
	String type;
	String content;
	boolean isJoin;
	public String getUser_key() {
		return user_key;
	}
	
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setIsJoin(boolean isJoin) {
		this.isJoin = isJoin;
	}
	
}
