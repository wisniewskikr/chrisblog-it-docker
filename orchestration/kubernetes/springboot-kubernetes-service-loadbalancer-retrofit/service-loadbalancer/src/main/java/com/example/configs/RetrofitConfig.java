package com.example.configs;

import okhttp3.OkHttpClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.retrofits.HelloWorldService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
	
	@Value("${helloworld.url}")
	private String helloWorldUrl;
	
	private final OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
	
	@Bean
    public HelloWorldService buildServiceBooksEndpoint() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(helloWorldUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClientBuilder.build())
                .build();
        return retrofit.create(HelloWorldService.class);
        
    }

}
