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
import com.vladaver87.eventsgenerator.model.EventsStorage;

@Controller
public class EventController {

	@Autowired
	private EventGenerator eventGenerator;
	@Autowired
	private EventsStorage eventsStorage;

	@GetMapping("/events")
	public String listEvents(Model model) {

		List<Event> events = eventsStorage.getEvents();

		model.addAttribute("events", events);

		return "listEvents";
	}
	
	@GetMapping("/showFormForCreateEvent")
	public String showFormForCreateEvent(Model model) {
		
		Event event = new Event(null);
		
		List<String> eventsType = eventGenerator.getListEventsType();
		
		model.addAttribute("event", event);
		
		model.addAttribute("eventsType", eventsType);
		
		return "create-event-form";		
	}

	@PostMapping("/saveEvent")
	public String saveCustomer(@ModelAttribute("event") Event event) {

		String eventType = event.getEventType();

		eventsStorage.saveEvent(eventType);

		return "redirect:/events";
	}

}
