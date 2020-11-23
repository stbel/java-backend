package backend.core.frame.non;

import org.apache.log4j.Logger;

public class LoggerClass {
	private Logger logger;

	protected Logger getLogger() {
		if (logger == null) {
			logger = Logger.getLogger(this.getClass());
		}
		return logger;
	}

	protected void info(String message) {
		getLogger().info(message);
	}

	protected void debug(String message) {
		getLogger().debug(message);
	}

	protected void warn(String message) {
		getLogger().warn(message);
	}
}
