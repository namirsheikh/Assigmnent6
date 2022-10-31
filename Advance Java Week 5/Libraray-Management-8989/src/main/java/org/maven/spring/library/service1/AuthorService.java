package org.maven.spring.library.service1;

import java.util.List;
import java.util.Optional;

import org.maven.spring.library.model.Author;

public interface AuthorService {

	public List<Author> getAllAuthors();

	public Author saveAuthorDetails(Author authorDetails);

	public void deleteAuthor(Author existingAuthor);

	public Optional<Author> getAuthorById(long authorId);

}
