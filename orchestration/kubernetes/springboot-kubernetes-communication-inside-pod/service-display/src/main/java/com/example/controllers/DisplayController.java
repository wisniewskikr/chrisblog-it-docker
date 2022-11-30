package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.jsons.DisplayJson;
import com.example.jsons.StorageJson;

@RestController
public class DisplayController {
	
	private Environment environment;

	private WebClient webClient;
	
	@Value("${storage.service.url}")
	private String storageServiceUrl;
	
	@Autowired
	public DisplayController(Environment environment, WebClient webClient) {
		this.environment = environment;
		this.webClient = webClient;
	}

	@RequestMapping(value="/")
	public DisplayJson greeting() {
		
		String displayPort = environment.getProperty("local.server.port");
		StorageJson storageJson = this.webClient.get()
	            .uri(storageServiceUrl)
	            .retrieve()
	            .bodyToMono(StorageJson.class)
	            .block();
		
		return new DisplayJson(storageJson.getMessage(), displayPort, storageJson.getPort());
		
	}
	
}