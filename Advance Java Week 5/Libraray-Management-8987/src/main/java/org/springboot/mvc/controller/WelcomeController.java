package org.springboot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping("/")
	public String getHome() {
		return "<a href=\"/login \"><button>Login</button></a>";
//		return "index";
	}
}
