package com.example.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
	public String helloWorld() throws IOException {
		
		Path pathFile = Paths.get(folderPath + "/" + fileName);
		System.out.println(pathFile.toAbsolutePath().toString());
		Files.createDirectories(Paths.get(folderPath));
		fileService.writeToFile(pathFile.toString(), "Hello World!");
		String message = fileService.readFromFile(pathFile.toString());
		return message;
		
	}
	
}