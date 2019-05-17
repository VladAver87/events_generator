package com.vladaver87.eventsgenerator.model;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Component
@Scope("prototype")
public class Event {
	
	private UUID id;
	private String eventType;
	private long eventTimeStamp;
	private long createTime;
	private Date deliveryTime;
	private Date endTime;
	private String serviceType;
	private String originationPage;
	private String agentId;
	private String endReason;
	private String originationChannel;
	
	
	public Event(String eventType) {
		this.eventType = eventType;
		this.id = UUID.randomUUID();
		this.eventTimeStamp = new Date().getTime();
		this.createTime = eventTimeStamp;
		this.serviceType = setRandomServiceType();
		this.originationPage = setRandomOriginationPage();
		this.agentId = "undefined";
		this.endReason = "undefined";
		this.originationChannel = setRandomOriginationChannel();
		
	}
	
	public Event() {
		this.id = UUID.randomUUID();
		this.eventType = "start";
		this.eventTimeStamp = new Date().getTime();
		this.createTime = eventTimeStamp;
		this.serviceType = setRandomServiceType();
		this.originationPage = setRandomOriginationPage();
		this.agentId = "undefined";
		this.endReason = "undefined";
		this.originationChannel = setRandomOriginationChannel();
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
		}
		
		return null;
	}

}
