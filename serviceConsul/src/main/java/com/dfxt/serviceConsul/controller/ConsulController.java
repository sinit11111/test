package com.dfxt.serviceConsul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulController {
		
	
	@GetMapping("/find")
	public String find() {
		return "调用成功";
	}
}
