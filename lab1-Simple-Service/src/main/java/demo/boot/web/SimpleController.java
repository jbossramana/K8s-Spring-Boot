package demo.boot.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.boot.service.SimpleService;

@RestController
public class SimpleController {

	@Autowired
	SimpleService  simpleService;
	
	
	@GetMapping("/simple")
	public String getMessage()
	{
		String msg = simpleService.getMessageInfo();
		return "Presentation Tier...." +msg;
	}
}
