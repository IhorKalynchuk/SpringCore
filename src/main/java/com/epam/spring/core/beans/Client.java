package com.epam.spring.core.beans;

import java.util.HashMap;
import java.util.Map;

public class Client {

	private String id;
	private String fullName;
	private String greeting;

	private static Map<String, String> clients = new HashMap();

	static {
		clients.put("1", "Igor Kalynchuk");
		clients.put("2", "Vsevolod Kalynchuk");
		clients.put("3", "Bogdan Kalynchuk");
		clients.put("4", "Yana Kalynchuk");
		clients.put("5", "Zlata Kalynchuk");
	}

	public Client(String id, String fullName) {
		super();
		this.id = id;
		this.fullName = fullName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	private String setFullName(String id) {
		try {
			return clients.get(id);
		} catch (Exception e) {
			return "Unknown User";
		}
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", fullName=" + fullName + "]";
	}

}
