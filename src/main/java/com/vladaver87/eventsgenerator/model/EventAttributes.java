package com.vladaver87.eventsgenerator.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class EventAttributes {
	
	private ServiceType serviceType;
	private OriginationPage originationPage;
	private OriginationChannel originationChannel;

	public List<ServiceType> getServiceTypes(){
		List<ServiceType> serviceTypes = new ArrayList<>();
		for (ServiceType type : ServiceType.values()) {
			serviceTypes.add(type);		
		}
		return serviceTypes;
	}
	
	public List<OriginationChannel> getOriginationChannels(){
		List<OriginationChannel> originationChannels = new ArrayList<>();
		for (OriginationChannel channel : OriginationChannel.values()) {
			originationChannels.add(channel);		
		}
		return originationChannels;
	}
	
	public List<OriginationPage> getOriginationPages(){
		List<OriginationPage> originationPages = new ArrayList<>();
		for (OriginationPage page : OriginationPage.values()) {
			originationPages.add(page);		
		}
		return originationPages;
	}
}
