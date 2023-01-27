package com.example.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.FileService;

@RestController
public class HelloWorldController {
	
	@Value("${file.path}")
	private String filePath;
	
	private FileService fileService;
	
	@Autowired
	public HelloWorldController(FileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(value="/")
	public String helloWorld() throws IOException {		
		
		fileService.writeToFile(filePath, "Hello World!");
		return fileService.readFromFile(filePath.toString());
		
	}
	
}