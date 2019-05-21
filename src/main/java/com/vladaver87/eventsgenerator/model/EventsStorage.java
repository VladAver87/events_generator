package com.vladaver87.eventsgenerator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventsStorage {
	
	@Autowired
	private EventGenerator eventGenerator;
	
	private List<Event> events = new ArrayList<>();
	
	public List<Event> getEvents(){
		
		return events;
	}
	
	public void saveEvent(String eventType) {
		Event e = eventGenerator.generateEvent(eventType);
		events.add(e);
	}

}
