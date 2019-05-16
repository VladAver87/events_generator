package com.vladaver87.eventsgenerator.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


public class EventGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(EventGenerator.class);
	
	public Event generateEvent() {
		Event e = new Event();
		log.info(e.toString());	
		return e;
			
	}

}
