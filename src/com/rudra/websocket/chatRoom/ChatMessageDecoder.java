//$Id$
package com.rudra.websocket.chatRoom;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;




//import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

// it converts messageObject to chatMessage Object

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {

	@Override
	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ChatMessage decode(final String message) throws DecodeException {
		JsonObject obj = Json.createReader(new StringReader(message))
				.readObject();
		ChatMessage chatMessage = new ChatMessage();
			chatMessage.setName(obj.getString("username"));
			chatMessage.setTimeStamp(new Date());
			chatMessage.setMessage(obj.getString("message"));
		
		
		
		return chatMessage;
		
	}

	@Override
	public boolean willDecode(String arg0) {
		
		return true;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
