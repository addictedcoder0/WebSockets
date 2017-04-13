//$Id$
package com.rudra.websocket.chatRoom;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/", encoders = ChatMessageEncoder.class, decoders = ChatMessageDecoder.class)
public class ChatRoomEndPoint {

	static Set<Session> activeSessions = Collections.synchronizedSet(new HashSet<Session>());
	
	
	@OnOpen
	public void handleOpen(Session userSession){
		activeSessions.add(userSession);
		System.out.println("client in now connected");
	}
	@OnClose
	public void handleClose(Session userSession){
		activeSessions.remove(userSession);
		System.out.println("client is disconnected now");
	}
	@OnError
	public void handleError(Throwable t){
		System.out.println("some error occurred at the server side");
	}
	@OnMessage
	public void handleMessage(Session session, ChatMessage chatMessage) throws IOException
	{
		System.out.println("from on message section");
		for(Session s : session.getOpenSessions()){
		
			if(s.isOpen()){
				try {
					s.getBasicRemote().sendObject(chatMessage);
				} catch (IOException|EncodeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			/*if(userName == null){
			userSession.getUserProperties().put("username",message);
			userSession.getBasicRemote().sendText("you are now connected as "+message);
		}else{
			ChatMessage incomingMessage =  ChatMessageDecoder.handleIncomingMessage(userSession, message);
			String outgoingMessage = ChatMessageEncoder.handleUserResponse(incomingMessage);
			Iterator<Session> iterator =  activeSessions.iterator();
			while(iterator.hasNext()){
				//String outgoingMessage = ChatMessageEncoder.handleUserResponse(incomingMessage);
				iterator.next().getBasicRemote().sendText(outgoingMessage);
			}
		}*/
	}
	}
	
}
