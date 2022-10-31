package org.maven.spring.library.service1;

import java.util.List;
import java.util.Optional;

import org.maven.spring.library.model.Author;
import org.maven.spring.library.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	public List<Author> getAllAuthors() {
		return this.authorRepository.findAll();
	}

	public Author saveAuthorDetails(Author authorDetails) {
		return this.authorRepository.save(authorDetails);
	}

	public void deleteAuthor(Author existingAuthor) {
		this.authorRepository.delete(existingAuthor);
	}

	public Optional<Author> getAuthorById(long authorId) {
		return this.authorRepository.findById(authorId);
	}

}
