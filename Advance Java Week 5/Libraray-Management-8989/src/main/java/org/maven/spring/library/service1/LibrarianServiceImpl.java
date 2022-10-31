package org.maven.spring.library.service1;

import java.util.List;
import java.util.Optional;

import org.maven.spring.library.model.Librarian;
import org.maven.spring.library.repo.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	private LibrarianRepository userRepository;

	public List<Librarian> getAllUsers() {
		return this.userRepository.findAll();
	}

	public Optional<Librarian> getUserById(long bookId) {
		return this.userRepository.findById(bookId);
	}

	public Librarian getUserByName(String userName) {
		return this.userRepository.findByName(userName);
	}

	public Librarian saveUser(Librarian userDetails) {
		return this.userRepository.save(userDetails);
	}

	public Librarian findByNameAndPassword(String userName, String userPassword) {
		System.out.println("service : "+userName+" "+userPassword);
		return this.userRepository.findByNameAndPassword(userName, userPassword);
	}
}
