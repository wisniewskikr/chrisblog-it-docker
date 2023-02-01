package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.StorageJson;

@RestController
public class StorageController {
	
private Environment environment;	
	
	@Autowired
	public StorageController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/")
	public StorageJson greeting() {
		
		String port = environment.getProperty("local.server.port");
		return new StorageJson("Hello World!", port);
		
	}
	
}