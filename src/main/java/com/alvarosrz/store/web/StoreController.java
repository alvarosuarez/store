package com.alvarosrz.store.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alvarosrz.store.model.StoreResponse;

@RestController
public class StoreController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/start")
	String home() {
		return "Spring Test!";
	}

	@GetMapping("/greeting")
	public StoreResponse greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new StoreResponse(54.54);
		// return new Greeting(counter.incrementAndGet(), String.format(template,
		// name));
	}
}