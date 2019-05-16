package com.vladaver87.eventsgenerator.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(EventGenerator.class);
	
	public List<Event> generateEvent() {
		List<Event> events = new ArrayList<>();
		Event e = new Event();
		events.add(e);
		log.info(e.toString());	
		return events;
			
	}

}
