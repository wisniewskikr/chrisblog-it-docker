package com.example.jsons;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HelloWorldJson {
	
	private String message;
	
	@JsonProperty(value = "LoadBalancer Service port")
	private String loadBalancerPort;
	
	@JsonProperty(value = "LoadBalancer Service uuid")
	private String loadBalancerUuid;	
	
	@JsonProperty(value = "HelloWorld Service port")
	private String helloWorldPort;
	
	@JsonProperty(value = "HelloWorld Service uuid")
	private String helloWorldUuid;
	
	public HelloWorldJson() {}

	public HelloWorldJson(String message, String loadBalancerPort, String loadBalancerUuid, String helloWorldPort,
			String helloWorldUuid) {
		this.message = message;
		this.loadBalancerPort = loadBalancerPort;
		this.loadBalancerUuid = loadBalancerUuid;
		this.helloWorldPort = helloWorldPort;
		this.helloWorldUuid = helloWorldUuid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLoadBalancerPort() {
		return loadBalancerPort;
	}

	public void setLoadBalancerPort(String loadBalancerPort) {
		this.loadBalancerPort = loadBalancerPort;
	}

	public String getLoadBalancerUuid() {
		return loadBalancerUuid;
	}

	public void setLoadBalancerUuid(String loadBalancerUuid) {
		this.loadBalancerUuid = loadBalancerUuid;
	}

	public String getHelloWorldPort() {
		return helloWorldPort;
	}

	public void setHelloWorldPort(String helloWorldPort) {
		this.helloWorldPort = helloWorldPort;
	}

	public String getHelloWorldUuid() {
		return helloWorldUuid;
	}

	public void setHelloWorldUuid(String helloWorldUuid) {
		this.helloWorldUuid = helloWorldUuid;
	}
	
}
