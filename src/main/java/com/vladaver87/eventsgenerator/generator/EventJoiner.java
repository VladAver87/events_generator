package com.vladaver87.eventsgenerator.generator;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vladaver87.eventsgenerator.model.EndReason;
import com.vladaver87.eventsgenerator.model.Event;

@Component
public class EventJoiner {

	@Autowired
	private EventGenerator eventGenerator;
	
	public void joining(Event e) {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.schedule(new Runnable() {

			@Override
			public void run() {
				if (e.getEventType().equals("end")) {
					service.shutdown();
				} else {
					e.setEventType("join");
					e.setDeliveryTime(new Date());
					e.setAgentId("Agent_Id_" + new Random().nextInt(17));
					service.schedule(new Runnable() {

						@Override
						public void run() {
							e.setEventType("end");
							e.setEndTime(new Date());
							e.setEndReason(eventGenerator.generateEnum(EndReason.values()));
						}

					}, new Random().nextInt(15), TimeUnit.SECONDS);

				}

				service.shutdown();
			}

		}, new Random().nextInt(11), TimeUnit.SECONDS);

	}

}
