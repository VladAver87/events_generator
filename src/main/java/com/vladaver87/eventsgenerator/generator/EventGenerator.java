package com.vladaver87.eventsgenerator.generator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.OriginationChannel;
import com.vladaver87.eventsgenerator.model.OriginationPage;
import com.vladaver87.eventsgenerator.model.ServiceType;

@Component
public class EventGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(EventGenerator.class);
	
	public Event createEvent(ServiceType serviceType, OriginationPage originationPage, OriginationChannel originationChannel) {
		Event e = new Event();
		e.setEventType("start");
		e.setId(UUID.randomUUID());
		e.setEventTimeStamp(new Date());
		e.setCreateTime(e.getEventTimeStamp());
		e.setAgentId("undefined");
		e.setEndReason("undefined");
		e.setServiceType(serviceType);
		e.setOriginationPage(originationPage);
		e.setOriginationChannel(originationChannel);
		log.info("Create event from web " + e.toString());	
		return e;
	}	
	
	
	
	public Event generateEvent() {
		Event e = new Event();
		e.setEventType("start");
		e.setId(UUID.randomUUID());
		e.setEventTimeStamp(new Date());
		e.setCreateTime(e.getEventTimeStamp());
		e.setServiceType(this.setRandomServiceType());
		e.setOriginationPage(this.setRandomOriginationPage());
		e.setAgentId("undefined");
		e.setEndReason("undefined");
		e.setOriginationChannel(this.setRandomOriginationChannel());
		log.info(e.toString());	
		return e;
			
	}
	
	public String setRandomEndReason() {
		int choise = new Random().nextInt(2);
		switch (choise) {
			case 0:
				return "NORMAL";

			case 1:
				return "ABNORMAL";
				
			default:			
		}
		
		return null;
	}
	
	private ServiceType setRandomServiceType() {
		int choise = new Random().nextInt(3);
		switch (choise) {
			case 0:
				return ServiceType.NEW_ACCOUNT;

			case 1:
				return ServiceType.PAYMENT;

			case 2:
				return ServiceType.DELIVERY;
				
			default:			
		}
		
		return null;
	}
	
	private OriginationPage setRandomOriginationPage() {
		int choise = new Random().nextInt(3);
		switch (choise) {
			case 0:
				return OriginationPage.LOGIN;

			case 1:
				return OriginationPage.BALANCE;

			case 2:
				return OriginationPage.TRANSFER;
				
			default:	
		}
		
		return null;
	}
	
	private OriginationChannel setRandomOriginationChannel() {
		int choise = new Random().nextInt(3);
		switch (choise) {
			case 0:
				return OriginationChannel.WEBCHAT;

			case 1:
				return OriginationChannel.SMS;

			case 2:
				return OriginationChannel.WECHAT;
				
			default:
		}
		
		return null;
	}

	
}
