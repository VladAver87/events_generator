package com.vladaver87.eventsgenerator.generator;

import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vladaver87.eventsgenerator.model.Event;
import com.vladaver87.eventsgenerator.model.OriginationChannel;
import com.vladaver87.eventsgenerator.model.OriginationPage;
import com.vladaver87.eventsgenerator.model.ServiceType;
import com.vladaver87.eventsgenerator.storage.EventsStorage;

@Component
public class EventGenerator {
	
	private static final Logger log = LoggerFactory.getLogger(EventGenerator.class);
	
	@Value("${count}")
	private Integer count;
	
	@Value("${rate}")
	private Integer rate;
	
	@Autowired
	private EventsStorage eventsStorage;
	
	public Event createEvent(ServiceType serviceType, OriginationPage originationPage, OriginationChannel originationChannel) {
		Event e = new Event();
		e.setEventType("start");
		e.setId(UUID.randomUUID());
		e.setEventTimeStamp(new Date());
		e.setCreateTime(e.getEventTimeStamp());
		e.setAgentId("undefined");
		e.setServiceType(serviceType);
		e.setOriginationPage(originationPage);
		e.setOriginationChannel(originationChannel);
		log.info("Event from web {} is generated", e);	
		return e;
	}	
	
	
	@PostConstruct
	public void generateEvent() {
		int delay = 1000 / rate;
		for (int i = 0; i < count; i++) {
		Event e = new Event();
		e.setEventType("start");
		e.setId(UUID.randomUUID());
		e.setEventTimeStamp(new Date());
		e.setCreateTime(e.getEventTimeStamp());
		e.setServiceType(generateEnum(ServiceType.values()));
		e.setOriginationPage(generateEnum(OriginationPage.values()));
		e.setAgentId("undefined");
		e.setOriginationChannel(generateEnum(OriginationChannel.values()));
		eventsStorage.saveEvent(e);
		log.info("Event {} is generated", e);	
		sleep(delay);
		}
	}
	
    private void sleep(long time){
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }
	
    public <T extends Enum<T>> T generateEnum(T[] values) {
    	int n = new Random().nextInt(values.length);
    	return values[n];
    }

}
