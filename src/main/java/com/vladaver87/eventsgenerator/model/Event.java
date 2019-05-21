package com.vladaver87.eventsgenerator.model;

import java.util.Date;
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

	}

}
