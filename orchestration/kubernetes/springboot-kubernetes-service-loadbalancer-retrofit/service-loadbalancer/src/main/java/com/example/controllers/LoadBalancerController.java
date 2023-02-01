package com.example.controllers;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.HelloWorldDto;
import com.example.jsons.HelloWorldJson;
import com.example.retrofits.HelloWorldService;

import retrofit2.Response;

@RestController
public class LoadBalancerController {
	
	private Environment environment;
	private HelloWorldService helloWorldService;
		
	@Autowired
	public LoadBalancerController(Environment environment, HelloWorldService helloWorldService) {
		this.environment = environment;
		this.helloWorldService = helloWorldService;
	}

	@RequestMapping(value="/")
	public HelloWorldJson helloWorld() {
		
		String port = environment.getProperty("local.server.port");		
		HelloWorldDto helloWorldDto = getHelloWorldDto();		
		return new HelloWorldJson(helloWorldDto.getMessage(), port, helloWorldDto.getPort());
		
	}
	
	private HelloWorldDto getHelloWorldDto() {
		
		HelloWorldDto helloWorldDto = new HelloWorldDto();
		
        try {
            Response<HelloWorldDto> bookResponse = helloWorldService.getHelloWorld().execute();
            helloWorldDto = bookResponse.body();
        } catch (IOException e) {
        	System.err.println(e);
        }
        
        return helloWorldDto;
		
	}
	
}