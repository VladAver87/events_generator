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
import com.vladaver87.eventsgenerator.model.EventGenerator.OriginationChannel;
import com.vladaver87.eventsgenerator.model.EventGenerator.OriginationPage;
import com.vladaver87.eventsgenerator.model.EventGenerator.ServiceType;
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
		
		ServiceType[] serviceTypes = ServiceType.values();
		OriginationPage[] originationPages = OriginationPage.values();
		OriginationChannel[] originationChannels = OriginationChannel.values();
		
		model.addAttribute("serviceTypes", serviceTypes);
		model.addAttribute("originationPages", originationPages);
		model.addAttribute("originationChannels", originationChannels);
		
		return "create-event-form";		
	}

	@PostMapping("/saveEvent")
	public String saveCustomer(@ModelAttribute("serviceTypes") String serviceType, 
		@ModelAttribute("originationPages") String originationPage, @ModelAttribute("originationChannels") String originationChannel) {		
		
		Event event = eventGenerator.createEvent(serviceType, originationPage, originationChannel);

		eventsStorage.saveEvent(event);

		return "redirect:/events";
	}

}
