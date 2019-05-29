package com.vladaver87.eventsgenerator.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

	public Event getById(UUID id) {
		Event event = null;
		for (Event e : events) {
			UUID result = e.getId();
			if (result.equals(id)) {
				event = e;
			}
		}
		return event;
	}
}
