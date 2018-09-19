package com.dfxt.httpProject.controller;


import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dfxt.model.entity.UserInfo;

@RestController
public class HttpClientController {
		
	
		@GetMapping("demo")
		public String demo() {
			RestTemplate rest = new RestTemplate();
			ResponseEntity<List> postForEntity = rest.postForEntity("http://localhost:8080/power/list",null,List.class);
			List<Map<String,Object>> list = postForEntity.getBody();
			String password = (String) list.get(0).get("password");
			System.out.println(""+password);
			return list.toString();
		}
}
