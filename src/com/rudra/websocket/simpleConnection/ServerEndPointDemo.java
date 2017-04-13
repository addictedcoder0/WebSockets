//$Id$
package com.rudra.websocket.simpleConnection;
/**
 *  libs : 
 *  		javax.websocket-api-1.1,jar
 *  		
 */
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

	
//@ServerEndpoint("/ws")
public class ServerEndPointDemo {

	@OnOpen
	public void handleOpen(){
		System.out.println("client in now connected");
	}
	
	@OnClose
	public void handleClose(){
		System.out.println("client is disconnected now");
	}
	
	@OnError
	public void handleError(Throwable t){
		
	}
	
	@OnMessage
	public String handleMessage(String message)
	{
		System.out.println("server recieved : "+ message);
		String reply = " i recieved : "+ message ;
		return reply;
	}
	
}





