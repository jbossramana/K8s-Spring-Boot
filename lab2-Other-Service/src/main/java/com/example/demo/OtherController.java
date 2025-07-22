package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OtherController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/other")
	public String getOtherMsg()
	{
		String msg = restTemplate.getForObject("http://simple-rest-api:8080/simple",String.class);
	    return msg + "called from otherservice";
	}
	
}
