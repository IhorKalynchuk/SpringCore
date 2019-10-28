package com.epam.spring.core.loggers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.epam.spring.core.beans.Event;

public class FileEventLogger implements EventLogger {

	public static final String DEFAULT_ENCODING = "UTF-8";
	private String fileName;
	private File file;

	@Autowired
	public FileEventLogger(@Value("#{LOG_FILE}") String fileName) throws IOException {
		super();
		this.fileName = fileName;
	}

	public void logEvent(Event event) {
		try {
			FileUtils.writeStringToFile(file, event.getFormattedMessage() + "\n", DEFAULT_ENCODING, true);
			System.out.println("\t\tMessage sent to FileEventLogger");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unused")
	private void init() throws IOException {
		this.file = new File(fileName);
		if (!file.exists()) {
			file.createNewFile();
		}

		if (!file.canWrite()) {
			throw new IOException("!!!No rights to write to " + fileName + " file");
		}
	}
}
