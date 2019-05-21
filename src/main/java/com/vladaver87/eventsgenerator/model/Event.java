package com.vladaver87.eventsgenerator.model;

import java.util.Date;
import java.util.UUID;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Component
@NoArgsConstructor
@Scope("prototype")
public class Event {
	
	private UUID id;
	private String eventType;
	private long eventTimeStamp;
	private long createTime;
	private Date deliveryTime;
	private Date endTime;
	private ServiceType serviceType;
	private OriginationPage originationPage;
	private String agentId;
	private String endReason;
	private OriginationChannel originationChannel;
	

	public Event(ServiceType serviceType, OriginationPage originationPage, OriginationChannel originationChannel) {
		this.serviceType = serviceType;
		this.originationPage = originationPage;
		this.originationChannel = originationChannel;
	}
	
}
