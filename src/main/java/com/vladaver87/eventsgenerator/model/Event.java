package com.vladaver87.eventsgenerator.model;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
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

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventType=" + eventType + ", eventTimeStamp=" + eventTimeStamp + ", createTime="
				+ createTime + ", deliveryTime=" + deliveryTime + ", endTime=" + endTime + ", serviceType="
				+ serviceType + ", originationPage=" + originationPage + ", agentId=" + agentId + ", endReason="
				+ endReason + ", originationChannel=" + originationChannel + "]";
	}

}
