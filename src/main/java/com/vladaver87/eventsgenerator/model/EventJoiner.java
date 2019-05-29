package com.vladaver87.eventsgenerator.model;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class EventJoiner {
	
	public void joining(Event e) {

		ExecutorService service = Executors.newSingleThreadExecutor();
		service.execute(new EventJoinJob(e));
		service.shutdown();
		try {
			service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}

}
