package org.springboot.mvc.service;

import java.util.List;

import org.springboot.mvc.model.Librarian;

public interface LibrarianService {

	public void addUser(Librarian userDetails);

	public List<Librarian> listUsers();

	public Librarian getUserByUsername(String username);

	public Librarian getUserByUsernameAndPassword(String username, String password);

	public String encyptString(String plainText);

}
