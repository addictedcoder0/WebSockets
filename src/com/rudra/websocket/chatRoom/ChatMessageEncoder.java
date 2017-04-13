//$Id$
package com.rudra.websocket.chatRoom;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

// it converts ChatMessage Object into Json-Object

public class ChatMessageEncoder implements Encoder.Text<ChatMessage>{

	
	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String encode(final ChatMessage chatMessage) throws EncodeException {
		return Json.createObjectBuilder()
				.add("message", chatMessage.getMessage())
				.add("username", chatMessage.getName())
				.add("received", chatMessage.getTimeStamp().toString()).build()
				.toString();
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
