package com.vladaver87.eventsgenerator.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EventGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(EventGenerator.class);
	
	public Event createEvent(ServiceType serviceType, OriginationPage originationPage, OriginationChannel originationChannel) {
		Event e = new Event();
		e.setEventType("start");
		e.setId(UUID.randomUUID());
		e.setEventTimeStamp(new Date().getTime());
		e.setCreateTime(e.getEventTimeStamp());
		e.setAgentId("undefined");
		e.setEndReason("undefined");
		e.setServiceType(serviceType);
		e.setOriginationPage(originationPage);
		e.setOriginationChannel(originationChannel);
		log.info("Create event from web" + e.toString());	
		return e;
	}	
	
	
	/*
	public Event generateEvent() {
		Event e = new Event();
		e.setEventType("start");
		e.setId(UUID.randomUUID());
		e.setEventTimeStamp(new Date().getTime());
		e.setCreateTime(e.getEventTimeStamp());
		e.setServiceType(this.setRandomServiceType());
		e.setOriginationPage(this.setRandomOriginationPage());
		e.setAgentId("undefined");
		e.setEndReason("undefined");
		e.setOriginationChannel(this.setRandomOriginationChannel());
		log.info(e.toString());	
		return e;
			
	}
	
	private String setRandomServiceType() {
		int choise = new Random().nextInt(3);
		switch (choise) {
			case 0:
				return "new account";

			case 1:
				return "payment";

			case 2:
				return "delivery";
				
			default:			
		}
		
		return null;
	}
	
	private String setRandomOriginationPage() {
		int choise = new Random().nextInt(3);
		switch (choise) {
			case 0:
				return "login";

			case 1:
				return "balance";

			case 2:
				return "transfer";
				
			default:	
		}
		
		return null;
	}
	
	private String setRandomOriginationChannel() {
		int choise = new Random().nextInt(3);
		switch (choise) {
			case 0:
				return "webchat";

			case 1:
				return "sms";

			case 2:
				return "wechat";
				
			default:
		}
		
		return null;
	}

	*/
}
