package com.vladaver87.eventsgenerator.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class EventsStorage {
	
	private List<Event> events = new ArrayList<>();
	
	public List<Event> getEvents(){
		
		return events;
	}
	
	public void saveEvent(Event event) {

		events.add(event);
	}

}
