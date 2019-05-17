package com.vladaver87.eventsgenerator.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventGenerator {
	
	private List<Event> events = new ArrayList<>();
	private static final Logger log = LoggerFactory.getLogger(EventGenerator.class);
	
	public List<Event> generateEvent() {
		Event e = new Event();
		events.add(e);
		log.info(e.toString());	
		return events;
			
	}
	
	public List<Event> getEvents(){
	
		return events;
	}
	
	public void saveEvent(String eventType) {
		Event e = new Event(eventType);
		events.add(e);
	}
	
	public List<String> getEventType() {
		List<String> eventsType = new ArrayList<>();	
		eventsType.add("start");
		eventsType.add("join");
		eventsType.add("end");
		
		return eventsType;
	}
}
