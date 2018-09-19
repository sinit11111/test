package com.dfxt.serverFind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@EnableDiscoveryClient(autoRegister=true)
@RestController
@SpringBootApplication
@Configuration
@EnableFeignClients(defaultConfiguration=FeignClientsConfiguration.class)
public class ServerFindApplication {
	
	@Autowired
	DiscoveryClient client;
	@Autowired
	RestTemplate rest;
	
	public static void main(String[] args) {
		SpringApplication.run(ServerFindApplication.class, args);
	}
	
	@GetMapping("/getservice")
	public Object getService() {
		return client.getServices();
	}
	@GetMapping("/home")
	public String home() {
		String postForObject = rest.getForObject("http://service2/find", String.class);
		return postForObject;
	}
}
