//$Id$
package com.tester;

import java.io.StringWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;

public class Tester {
	public static void main(String[] args) {
		JsonObject personObject =  Json.createObjectBuilder().
									add("name","Rudra").
									add("isMarried",false).
									add("address","on plane tearth")
									.build();
		StringWriter stringwriter = new StringWriter();
		JsonWriter writer =  Json.createWriter(stringwriter);
		writer.writeObject(personObject);
		writer.close();
		System.out.println(stringwriter.getBuffer().toString());
		
	}
}