package com.vladaver87.eventsgenerator.model;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Event {
	
	private int id;
	private String eventType;
	private Date eventTimeStamp;
	private Date createTime;
	private Date deliveryTime;
	private Date endTime;
	private String serviceType;
	private String originationPage;
	private String agentId;
	private String endReason;
	private String originationChannel;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public Date getEventTimeStamp() {
		return eventTimeStamp;
	}
	public void setEventTimeStamp(Date eventTimeStamp) {
		this.eventTimeStamp = eventTimeStamp;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getOriginationPage() {
		return originationPage;
	}
	public void setOriginationPage(String originationPage) {
		this.originationPage = originationPage;
	}
	public String getAgentId() {
		return agentId;
	}
	public void setAgentId(String agentId) {
		this.agentId = agentId;
	}
	public String getEndReason() {
		return endReason;
	}
	public void setEndReason(String endReason) {
		this.endReason = endReason;
	}
	public String getOriginationChannel() {
		return originationChannel;
	}
	public void setOriginationChannel(String originationChannel) {
		this.originationChannel = originationChannel;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", eventType=" + eventType + ", eventTimeStamp=" + eventTimeStamp + ", createTime="
				+ createTime + ", deliveryTime=" + deliveryTime + ", endTime=" + endTime + ", serviceType="
				+ serviceType + ", originationPage=" + originationPage + ", agentId=" + agentId + ", EndReason="
				+ endReason + ", OriginationChannel=" + originationChannel + "]";
	}
	
	

}
