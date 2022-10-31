package org.springboot.mvc.service;

import java.util.List;

import org.springboot.mvc.model.Book;

public interface BookService {

	public void addBook(Book bookDetails);

	public void updateBook(Book bookDetails);

	public List<Book> listBooks();

	public Book getBookById(long bookId);

	public Book getBookByBookCode(long bookCode);

	public void removeBook(long bookId);

}
