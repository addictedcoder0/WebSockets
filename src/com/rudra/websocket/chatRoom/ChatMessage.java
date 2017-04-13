//$Id$
package com.rudra.websocket.chatRoom;

import java.util.Date;

public class ChatMessage {

	private String name;
	private Date timeStamp;
	private String message;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	 public String getMessage() {
		return message;
	}
	 public void setMessage(String message) {
		this.message = message;
	}
	
	
}
