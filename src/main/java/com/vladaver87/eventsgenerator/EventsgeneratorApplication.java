package com.vladaver87.eventsgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vladaver87.eventsgenerator.model.EventGenerator;

@SpringBootApplication
public class EventsgeneratorApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EventsgeneratorApplication.class, args);
		EventGenerator eventGenerator = new EventGenerator();
		eventGenerator.generateEvent();
	}

}
