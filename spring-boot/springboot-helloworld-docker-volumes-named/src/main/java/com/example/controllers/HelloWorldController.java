package com.example.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.services.FileService;
import com.example.services.jsons.HelloWorldJson;

@RestController
public class HelloWorldController {
	
	@Value("${file.path.not.volume}")
	private String filePathNotVolume;
	
	@Value("${file.path.volume}")
	private String filePathVolume;
	
	private FileService fileService;
	
	@Autowired
	public HelloWorldController(FileService fileService) {
		this.fileService = fileService;
	}
	
	@RequestMapping(value="/")
	public void init(HttpServletResponse response) throws IOException {	
		response.sendRedirect("/not-stored-as-volume");
	}

	@RequestMapping(value="/not-stored-as-volume")
	public HelloWorldJson notStoredAsVolume() throws IOException {		
		
		String contentMessage = getContentMessage(filePathNotVolume);
		fileService.writeToFile(filePathNotVolume, contentMessage);
		return new HelloWorldJson("File not stored as Volume. Press F5 to add new Greeting.", contentMessage);
		
	}
	
	@RequestMapping(value="/stored-as-volume")
	public HelloWorldJson storedAsVolume() throws IOException {		
		
		String contentMessage = getContentMessage(filePathVolume);
		fileService.writeToFile(filePathVolume, contentMessage);
		return new HelloWorldJson("File stored as Volume. Press F5 to add new Greeting.", contentMessage);
		
	}
	
	private String getContentMessage(String path) {
		
		List<String> list = getContentList(path);
		
		int index = list.size() + 1;
		list.add("Hello World " + index);
		String contentMessage = String.join(", ", list);
		
		return contentMessage;
		
	}
	
	private List<String> getContentList(String path) {
		
		List<String> list = new ArrayList<String>();
		
		String content = fileService.readFromFile(path);
		if (content != null && !"".equals(content)) {
			
			content = fileService.readFromFile(path);
			list = new ArrayList<String>(Arrays.asList(content.split(",")));
			
		}
		
		return list;
		
	}
	
}