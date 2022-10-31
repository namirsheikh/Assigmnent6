package org.maven.spring.library.controller;

import java.util.List;

import org.maven.spring.library.exception.ResourceNotFoundException;
import org.maven.spring.library.model.Author;
import org.maven.spring.library.service1.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping
	public List<Author> getAllAuthors() {
		return authorService.getAllAuthors();
	}

	@PostMapping
	public Author createAuthor(@RequestBody Author authorDetails) {
		return this.authorService.saveAuthorDetails(authorDetails);
	}

	@PutMapping("/{id}")
	public Author updateAuthor(@RequestBody Author authorDetails, @PathVariable("id") long authorId) {
		Author existingAuthor = this.authorService.getAuthorById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found with id :" + authorId));
		existingAuthor.setAuthorName(authorDetails.getAuthorName());
		return this.authorService.saveAuthorDetails(existingAuthor);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Author> deleteAuthor(@PathVariable("id") long authorId) {
		Author existingAuthor = this.authorService.getAuthorById(authorId)
				.orElseThrow(() -> new ResourceNotFoundException("Author not found with id :" + authorId));
		this.authorService.deleteAuthor(existingAuthor);
		return new ResponseEntity<Author>(existingAuthor, HttpStatus.OK);
	}

}
