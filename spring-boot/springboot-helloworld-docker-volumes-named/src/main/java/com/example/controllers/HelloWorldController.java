package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.FileService;

@RestController
public class HelloWorldController {
	
	@Value("${stored.folder.path}")
	private String folderPath;
	
	@Value("${stored.file.name}")
	private String fileName;
	
	private FileService fileService;
	
	@Autowired
	public HelloWorldController(FileService fileService) {
		this.fileService = fileService;
	}

	@RequestMapping(value="/")
	public String helloWorld() {
		
//		String filePath = folderPath + "\\" + fileName;
		String filePath = fileName;
		fileService.writeToFile(filePath, "Hello World!");
		String message = fileService.readFromFile(filePath);
		return message;
		
	}
	
}