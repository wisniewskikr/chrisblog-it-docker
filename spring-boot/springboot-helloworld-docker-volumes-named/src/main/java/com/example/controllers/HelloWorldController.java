package com.example.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		
		String contentMessage = getContentMessage();
		fileService.writeToFile(filePath, contentMessage);
		return contentMessage;
		
	}
	
	private String getContentMessage() {
		
		List<String> list = getContentList();
		
		int index = list.size() + 1;
		list.add("Hello World " + index);
		String contentMessage = String.join(", ", list);
		
		return contentMessage;
		
	}
	
	private List<String> getContentList() {
		
		List<String> list = new ArrayList<String>();
		
		String content = fileService.readFromFile(filePath.toString());
		if (content != null && !"".equals(content)) {
			
			content = fileService.readFromFile(filePath.toString());
			list = new ArrayList<String>(Arrays.asList(content.split(",")));
			
		}
		
		return list;
		
	}
	
}