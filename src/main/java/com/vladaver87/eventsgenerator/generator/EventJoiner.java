package com.vladaver87.eventsgenerator.generator;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vladaver87.eventsgenerator.model.Event;

@Component
public class EventJoiner {
	
	private static final Logger log = LoggerFactory.getLogger(EventJoiner.class);
	
	public void joining(Event e) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.schedule(new EventJoinJob(e), new Random().nextInt(11), TimeUnit.SECONDS);
		service.shutdown();		
		log.info("Event move to join status " + e.toString());	
	}

}
