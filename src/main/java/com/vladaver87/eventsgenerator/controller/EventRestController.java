package com.vladaver87.eventsgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.EventGenerator;

@RestController
@RequestMapping("/")
public class EventRestController {
	
	@Autowired
	private EventGenerator eventGenerator;
	
	@GetMapping("/events")
	public List<Event> getEvents(){
		
		return eventGenerator.generateEvent();
	}

}
