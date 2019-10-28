package com.epam.spring.core.loggers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.epam.spring.core.beans.Event;

public class CacheFileEventLogger extends FileEventLogger {
	private int cacheSize;
	private List<Event> cache = new ArrayList<Event>();

	public CacheFileEventLogger(String fileName, int cacheSize) throws IOException {
		super(fileName);
		this.cacheSize = cacheSize;
	}

	@Override
	public void logEvent(Event event) {
		System.out.println("\t\tMessage sent to CacheFileEventLogger");
		cache.add(event);
		if (cache.size() >= cacheSize) {
			writeEventsFromCache();
			cache.clear();
		}
	}

	private void writeEventsFromCache() {
		for (Object element : cache) {
			Event event = (Event) element;
			super.logEvent(event);
		}
	}

	@SuppressWarnings("unused")
	private void destroy() {
		if (!cache.isEmpty()) {
			writeEventsFromCache();
		}
	}
}
