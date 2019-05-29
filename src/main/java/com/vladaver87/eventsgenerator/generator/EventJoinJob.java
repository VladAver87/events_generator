package com.vladaver87.eventsgenerator.generator;

import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.storage.EventsStorage;

public class EventJoinJob implements Runnable{
	
	private Event e;
	
	@Autowired
	private EventsStorage eventsStorage;
	
	public EventJoinJob(Event e) {
		this.e = e;
	}

	private Event joinEvent(Event e) {
		e.setEventType("join");
		e.setDeliveryTime(new Date());
		e.setAgentId("Agent_Id_" + new Random().nextInt(17));
		eventsStorage.saveEvent(e);
		return e;	
	}

	@Override
	public void run() {
		joinEvent(e);
	}

}
