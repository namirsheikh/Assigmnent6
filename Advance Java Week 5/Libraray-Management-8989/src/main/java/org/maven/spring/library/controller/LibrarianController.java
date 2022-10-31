package org.maven.spring.library.controller;

import java.util.List;

import org.maven.spring.library.model.Librarian;
import org.maven.spring.library.service1.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class LibrarianController {

	@Autowired
	private LibrarianService userService;

	@GetMapping
	public List<Librarian> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@PostMapping
	public Librarian createUser(@RequestBody Librarian userDetails) {
		return this.userService.saveUser(userDetails);
	}

	@GetMapping("/{name}")
	public Librarian getUserByName(@PathVariable("name") String userName) {
		System.out.println("coming");
		return (Librarian) this.userService.getUserByName(userName);
	}

	@GetMapping("/{name}/{password}")
	public Librarian getUserByNameAndPassword(@PathVariable("name") String userName,
			@PathVariable("password") String userPassword) {
		return (Librarian) this.userService.findByNameAndPassword(userName, userPassword);
	}

}
