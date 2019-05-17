package com.vladaver87.eventsgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.EventGenerator;

@Controller
public class EventController {
	
	@Autowired
	private EventGenerator eventGenerator;
	
	@GetMapping("/")
	public String listEvents(Model model) {
		
		List<Event> events = eventGenerator.getEvents();
		
		model.addAttribute("events", events);
		
		return "listEvents";
	}
	
	@PostMapping("/saveEvent")
	public String saveCustomer(@RequestParam("eventType") String eventType) {
		
		eventGenerator.saveEvent(eventType);
		
		return "redirect:/listEvents";
	}

}
