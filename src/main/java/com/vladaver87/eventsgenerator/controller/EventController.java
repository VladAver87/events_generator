package com.vladaver87.eventsgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.EventGenerator;

@Controller
public class EventController {

	@Autowired
	private EventGenerator eventGenerator;

	@GetMapping("/")
	public String listEvents(Model model) {

		List<Event> events = eventGenerator.getEvents();
		
		List<String> eventsType = eventGenerator.getListEventsType();

		model.addAttribute("events", events);
		
		model.addAttribute("eventsType", eventsType);
		
		Event event = new Event();
		
		model.addAttribute("event", event);

		return "listEvents";
	}

	@PostMapping("/saveEvent")
	public String saveCustomer(@ModelAttribute("event") Event event) {

		String eventType = event.getEventType();

		eventGenerator.saveEvent(eventType);

		return "redirect:/";
	}

}
