package com.example.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${app.message}")
	private String message;

	@RequestMapping(value="/")
	public String helloWorld() {		
		return message;		
	}
	
}