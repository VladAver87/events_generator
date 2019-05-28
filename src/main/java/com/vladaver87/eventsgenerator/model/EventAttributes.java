package com.vladaver87.eventsgenerator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EventAttributes {
	
	private ServiceType serviceType;
	private OriginationPage originationPage;
	private OriginationChannel originationChannel;

}
