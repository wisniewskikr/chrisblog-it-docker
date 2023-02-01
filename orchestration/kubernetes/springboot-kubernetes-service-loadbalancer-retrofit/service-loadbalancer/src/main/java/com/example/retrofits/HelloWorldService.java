package com.example.retrofits;


import com.example.dtos.HelloWorldDto;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HelloWorldService {
	
	@GET("/")
    Call<HelloWorldDto> getHelloWorld();

}
