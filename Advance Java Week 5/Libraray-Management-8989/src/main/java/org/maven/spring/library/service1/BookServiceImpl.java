package org.maven.spring.library.service1;

import java.util.List;
import java.util.Optional;

import org.maven.spring.library.model.Book;
import org.maven.spring.library.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	public Optional<Book> getBookById(long bookId) {
		return this.bookRepository.findById(bookId);
	}

	public Book getBookByCode(long bookCode) {
		return this.bookRepository.findByBookCode(bookCode);
	}

	public Book saveBook(Book bookDetails) {
		return this.bookRepository.save(bookDetails);
	}

	public void deleteBook(Book existingBook) {
		this.bookRepository.delete(existingBook);
	}

}
