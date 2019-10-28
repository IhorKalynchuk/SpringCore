package com.epam.spring.core;

import java.util.Map;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.beans.EventType;
import com.epam.spring.core.loggers.EventLogger;

public class App {

	private Map<EventType, EventLogger> loggersMap;
	private Client client;
	private EventLogger defaultLogger;

	public App(Client client, EventLogger defaultLogger, Map<EventType, EventLogger> loggersMap) {
		super();
		this.client = client;
		this.defaultLogger = defaultLogger;
		this.loggersMap = loggersMap;
		System.out.println("APP is created!!! Default logger is " + defaultLogger.getClass().getName());
	}

	public Map<EventType, EventLogger> getLoggersMap() {
		return loggersMap;
	}

	public void setLoggersMap(Map<EventType, EventLogger> loggersMap) {
		this.loggersMap = loggersMap;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public EventLogger getDefaultLogger() {
		return defaultLogger;
	}

	public void setDefaultLogger(EventLogger defaultLogger) {
		this.defaultLogger = defaultLogger;
	}

	public void logEvent(Event event, EventType type) {
		EventLogger logger = loggersMap.get(type);
		if (logger == null) {
			logger = defaultLogger;
		}
		logger.logEvent(event);
	}

}
