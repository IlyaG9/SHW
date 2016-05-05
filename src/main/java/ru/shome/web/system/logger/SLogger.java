package ru.shome.web.system.logger;

import java.io.IOException;
import java.sql.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SLogger {

	private static SLogger instance = null;

	private SLogger() {
	}

	public enum ErrLevel {
		ERROR, WARNING, INFO

	}

	public static synchronized SLogger getSLogger() {

		if (instance == null) {
			instance = new SLogger();
		}
		return instance;
	}

	public synchronized void log(ErrLevel ei, Class<?> clazz, String message) {
		Logger lg = Logger.getLogger(clazz.getName());
		switch (ei) {
		case ERROR:
			logError(clazz, message);
			break;
		case WARNING:
			logError(clazz, message);
			lg.info(clazz.getName().concat(": ").concat(message));
			break;
		case INFO:

			lg.info(clazz.getName().concat(": ").concat(message));
			break;
		}

	}

	private synchronized void logError(Class<?> clazz, String message) {
		Logger lg = Logger.getLogger(clazz.getName());
		FileHandler fh = null;
		try {
			fh = new FileHandler("logs/" +new Date(new java.util.Date().getTime()).toString()+".txt");
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			lg.addHandler(fh);
			lg.info(clazz.getName().concat(": ").concat(message));
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
}
