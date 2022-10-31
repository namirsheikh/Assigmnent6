package org.maven.spring.library.controller;

import java.util.List;

import org.maven.spring.library.model.Book;
import org.maven.spring.library.service1.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.maven.spring.library.exception.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public List<Book> getAllBooks() {
		return this.bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") long bookId) {
		return this.bookService.getBookById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + bookId));
	}

	@GetMapping("/book/{code}")
	public Book getBookByCode(@PathVariable("code") long bookCode) {
		return this.bookService.getBookByCode(bookCode);
	}

	@PostMapping
	public Book createBook(@RequestBody Book bookDetails) {
		return this.bookService.saveBook(bookDetails);
	}

	@PutMapping("/{id}")
	public Book updateBook(@RequestBody Book bookDetails, @PathVariable("id") long bookId) {
		Book existingBook = this.bookService.getBookById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + bookId));
		existingBook.setBookName(bookDetails.getBookName());
		existingBook.setAuthorName(bookDetails.getAuthorName());
		existingBook.setCreatedDate(bookDetails.getCreatedDate());
		return this.bookService.saveBook(existingBook);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable("id") long bookId) {
		Book existingBook = this.bookService.getBookById(bookId)
				.orElseThrow(() -> new ResourceNotFoundException("Book not found with id :" + bookId));
		this.bookService.deleteBook(existingBook);
		return ResponseEntity.ok().build();
	}

}
