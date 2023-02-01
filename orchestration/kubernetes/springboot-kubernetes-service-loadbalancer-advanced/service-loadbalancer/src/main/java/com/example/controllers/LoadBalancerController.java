package com.example.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jsons.DisplayJson;
import com.example.jsons.StorageJson;

@RestController
public class LoadBalancerController {
	
	private Environment environment;
	
	@Value("${storage.service.url}")
	private String storageServiceUrl;
	
	@Autowired
	public LoadBalancerController(Environment environment) {
		this.environment = environment;
	}

	@RequestMapping(value="/")
	public DisplayJson greeting() {
		
//		String displayPort = environment.getProperty("local.server.port");
//		StorageJson storageJson = this.webClient.get()
//	            .uri(storageServiceUrl)
//	            .retrieve()
//	            .bodyToMono(StorageJson.class)
//	            .block();
//		
//		return new DisplayJson(storageJson.getMessage(), displayPort, storageJson.getPort());
		
		return null;
		
	}
	
}