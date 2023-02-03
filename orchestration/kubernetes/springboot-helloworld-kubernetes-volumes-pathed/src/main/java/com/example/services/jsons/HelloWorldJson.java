package com.example.services.jsons;

public class HelloWorldJson {
	
	private String description;
	private String message;
		
	public HelloWorldJson() {}
		
	public HelloWorldJson(String description, String message) {
		this.description = description;
		this.message = message;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	

}
