package com.nsw.transportnsw.services.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Log {

	private static final Logger logger = LoggerFactory.getLogger(Log.class);
	
	public void info(String message) {
		
		logger.info(message);
	}
}
