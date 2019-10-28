package com.epam.spring.core.loggers;

import java.util.List;

import com.epam.spring.core.beans.Event;

public class CombinedEventLogger implements EventLogger {

	private List<EventLogger> loggers;

	public CombinedEventLogger(List<EventLogger> loggers) {
		super();
		this.loggers = loggers;
	}

	public void logEvent(Event event) {
		System.out.println("\t\t!!!! Message sent to CombinedEventLogger");
		for (EventLogger eventLogger : loggers) {
			eventLogger.logEvent(event);
		}
	}
}
