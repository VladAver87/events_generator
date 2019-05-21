package com.vladaver87.eventsgenerator.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.EventsStorage;

@RestController
@RequestMapping("/api")
public class EventRestController {
	
	@Autowired
	private EventsStorage eventsStorage;
	
	@GetMapping("/events")
	public List<Event> getEvents(){
		
		return eventsStorage.getEvents();
	}

}
