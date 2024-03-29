package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisplayJson {
	
	private String message;
	
	@JsonProperty(value = "display port")
	private String displayPort;
	
	@JsonProperty(value = "storage port")
	private String storagePort;	
	
	public DisplayJson() {}

	public DisplayJson(String message, String displayPort, String storagePort) {
		this.message = message;
		this.displayPort = displayPort;
		this.storagePort = storagePort;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDisplayPort() {
		return displayPort;
	}

	public void setDisplayPort(String displayPort) {
		this.displayPort = displayPort;
	}

	public String getStoragePort() {
		return storagePort;
	}

	public void setStoragePort(String storagePort) {
		this.storagePort = storagePort;
	}	
	
}
