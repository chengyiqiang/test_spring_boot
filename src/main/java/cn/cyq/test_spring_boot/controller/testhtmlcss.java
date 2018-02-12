package cn.cyq.test_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class testhtmlcss {
	@RequestMapping(value = {"/","/gethome"})
	public String getHomePageString (){
		return "123";
	}
	
	@RequestMapping(value = {"/get323"})
	public String getCssPage(){
		return "323";
	}
	

}
