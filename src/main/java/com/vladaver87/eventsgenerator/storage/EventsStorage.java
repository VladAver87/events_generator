package com.vladaver87.eventsgenerator.storage;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.vladaver87.eventsgenerator.model.Event;

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
