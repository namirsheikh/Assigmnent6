package org.springboot.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springboot.mvc.helper.DisplayMessageToJSP;
import org.springboot.mvc.model.Librarian;
import org.springboot.mvc.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class LoginController {

	@Autowired
	private LibrarianService userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/validate")
	public String validateUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model, HttpSession session) {

//		System.out.println(username + password);

		Librarian userDetails = this.userService.getUserByUsernameAndPassword(username,
				userService.encyptString(password));

		System.out.println(userDetails);

		if (userDetails == null) {
			DisplayMessageToJSP message = new DisplayMessageToJSP("Invalid Admin Credential ! try with another",
					"error", "alert-danger");
			session.setAttribute("message", message);
			return "redirect:/login";
		} else {

//		System.out.println(userDetails == null);

			session.setAttribute("user", userDetails);

			return "redirect:/bookList";
		}
	}

}
