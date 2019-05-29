package com.vladaver87.eventsgenerator.generator;

import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.vladaver87.eventsgenerator.model.Event;

@Component
public class ManualEventTypeChanger {
	
	
	public void changeEventType(Event e) {
		if (e.getEventType().equals("start")) {
			e.setEventType("join");
			e.setDeliveryTime(new Date());
			e.setAgentId("Agent_Id_" + new Random().nextInt(17));
		} else if (e.getEventType().equals("join")) {
			e.setEventType("end");
			e.setEndTime(new Date());
			e.setEndReason("NORMAL");
		}		
	}

}
