package com.occamsrazor.web;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootConfiguration
@Controller
public class HomeController {
	@GetMapping("/")
	public String hello() {
		return "index";//thymeleaf에서는 .html이 디폴트값이기 때문에 안쓴다.
	}
	@GetMapping("/home")
	public String home() {
		return "user";
	}
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
