package org.maven.spring.library.service1;

import java.util.List;
import java.util.Optional;

import org.maven.spring.library.model.Librarian;

public interface LibrarianService {
	
	public List<Librarian> getAllUsers();
	
	public Optional<Librarian> getUserById(long bookId);
	
	public Librarian saveUser(Librarian userDetails);
	
	public Librarian getUserByName(String userName);
	
	public Librarian findByNameAndPassword(String userName, String userPassword);

}
