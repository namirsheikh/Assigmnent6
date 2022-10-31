package org.springboot.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springboot.mvc.helper.DisplayMessageToJSP;
import org.springboot.mvc.model.Librarian;
import org.springboot.mvc.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibrarianController {

	@Autowired
	private LibrarianService userService;

	@RequestMapping("/register")
	public String showRegisterPage() {
		return "register";
	}

	@RequestMapping(value = "/do_register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") Librarian userDetails) {
		userDetails.setPassword(userService.encyptString(userDetails.getPassword()));
		this.userService.addUser(userDetails);
		return "redirect:/login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("message", "Logout SuccessFully !");
		session.setAttribute("user",null);
		session.removeAttribute("user");
		DisplayMessageToJSP message = new DisplayMessageToJSP("Librarian Logout Successfully", "success", "alert-success");
		session.setAttribute("message", message);
		return "redirect:/login";
	}

	@RequestMapping(value = "/checkUserSession", method = RequestMethod.GET)
	public String checkUserSession(HttpSession session) {
		Librarian loggedINAdmin = (Librarian) session.getAttribute("user");
		
		System.out.println("user is"+" "+loggedINAdmin);
		if(loggedINAdmin == null) {
		DisplayMessageToJSP message = new DisplayMessageToJSP("OOPS! Session TimeOut...", "error", "alert-warning");
		session.setAttribute("message", message);
		return "redirect:/login";
		}else {
			return "redirect:/bookList";
		}
	}

}
