package com.dfxt.serverFind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFindController {
	
		@Autowired
		private ServiceFindInterface service;
		
		@Autowired
		private LoadBalancerClient client;
		
		@GetMapping("/findOne")
		public String findOne() {
			String string = service.find();
			return string;
		}
}
