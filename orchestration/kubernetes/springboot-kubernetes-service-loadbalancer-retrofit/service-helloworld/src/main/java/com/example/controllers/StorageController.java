package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;

@RestController
public class StorageController {
	
private Environment environment;
	
	@Value("${helloworld.message}")
	private String message;
	
	@Autowired
	public StorageController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/")
	public HelloWorldDto greeting() {
		
		String port = environment.getProperty("local.server.port");
		return new HelloWorldDto(message, port);
		
	}
	
}