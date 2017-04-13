//$Id$
package com.rudra.websocket.chatRoom;

import javax.websocket.Session;

public class ChatUser {
private Session session;
private ChatMessage user_message;

public Session getSession() {
	return session;
}
public void setSession(Session session) {
	this.session = session;
}
public ChatMessage getUser_message() {
	return user_message;
}
public void setUser_message(ChatMessage user_message) {
	this.user_message = user_message;
}


}
