package com.vladaver87.eventsgenerator.model;

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

}
