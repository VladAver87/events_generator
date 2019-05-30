package com.vladaver87.eventsgenerator.model;

import java.util.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class Event {
	
	private UUID id;
	private String eventType;
	private Date eventTimeStamp;
	private Date createTime;
	private Date deliveryTime;
	private Date endTime;
	private ServiceType serviceType;
	private OriginationPage originationPage;
	private String agentId;
	private EndReason endReason;
	private OriginationChannel originationChannel;
	

	public Event(ServiceType serviceType, OriginationPage originationPage, OriginationChannel originationChannel) {
		this.serviceType = serviceType;
		this.originationPage = originationPage;
		this.originationChannel = originationChannel;
	}
	
}
