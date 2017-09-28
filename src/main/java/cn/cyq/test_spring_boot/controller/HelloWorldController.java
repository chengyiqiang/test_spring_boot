package cn.cyq.test_spring_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xx")
public class HelloWorldController {
	
	@RequestMapping("/123")
	public String business123(){
		return "123respone";
	}
	@RequestMapping("/haha")
	public String businesshaha(){
		return "haharespone";
	}
	
}
