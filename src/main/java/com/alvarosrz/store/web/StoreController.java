package com.alvarosrz.store.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alvarosrz.store.model.exception.ProductNotFoundException;
import com.alvarosrz.store.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService service;

	@GetMapping("/start")
	String home() {
		return "Spring Test!";
	}

	@PutMapping(path = "/buy", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buy(@RequestBody Collection<String> products) {
		try {
			return new ResponseEntity<Object>(service.getPrice(products), HttpStatus.OK);
		} catch (ProductNotFoundException e) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}