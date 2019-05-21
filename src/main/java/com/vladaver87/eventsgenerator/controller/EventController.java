package com.vladaver87.eventsgenerator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.EventAttributes;
import com.vladaver87.eventsgenerator.model.EventGenerator;
import com.vladaver87.eventsgenerator.model.OriginationChannel;
import com.vladaver87.eventsgenerator.model.OriginationPage;
import com.vladaver87.eventsgenerator.model.ServiceType;
import com.vladaver87.eventsgenerator.model.EventsStorage;

@Controller
public class EventController {

	@Autowired
	private EventGenerator eventGenerator;
	@Autowired
	private EventsStorage eventsStorage;
	@Autowired
	private EventAttributes eventAttributes;

	@GetMapping("/events")
	public String listEvents(Model model) {

		List<Event> events = eventsStorage.getEvents();

		model.addAttribute("events", events);

		return "listEvents";
	}
	
	@GetMapping("/showFormForCreateEvent")
	public String showFormForCreateEvent(Model model) {
		
		List<ServiceType> serviceTypes = eventAttributes.getServiceTypes();
		List<OriginationPage> originationPages = eventAttributes.getOriginationPages();
		List<OriginationChannel> originationChannels = eventAttributes.getOriginationChannels();
		
		model.addAttribute("serviceTypes", serviceTypes);
		model.addAttribute("originationPages", originationPages);
		model.addAttribute("originationChannels", originationChannels);
		model.addAttribute("eventAttributes", eventAttributes);
		
		return "create-event-form";		
	}

	@PostMapping("/saveEvent")
	public String saveCustomer(@ModelAttribute("eventAttributes") EventAttributes eventAttributes) {		
		
		Event event = eventGenerator.createEvent(eventAttributes.getServiceType(), eventAttributes.getOriginationPage(),
				eventAttributes.getOriginationChannel());
		
		eventsStorage.saveEvent(event);

		return "redirect:/events";
	}

}
