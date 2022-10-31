package org.maven.spring.library.service1;

import java.util.List;
import java.util.Optional;

import org.maven.spring.library.model.Book;


public interface BookService {

	public List<Book> getAllBooks();

	public Optional<Book> getBookById(long bookId);

	public Book getBookByCode(long bookCode);

	public Book saveBook(Book bookDetails);

	public void deleteBook(Book existingBook);
}
