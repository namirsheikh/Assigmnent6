package org.springboot.mvc.service;

import java.util.List;

import org.springboot.mvc.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void addBook(Book bookDetails) {
		this.restTemplate.postForEntity("http://localhost:8985/api/books", bookDetails, Book.class);
	}

	@Override
	public void updateBook(Book bookDetails) {
		this.restTemplate.put("http://localhost:8985/api/books" + "/" + bookDetails.getBookId(), bookDetails,
				Book.class);
	}

	@Override
	public List<Book> listBooks() {
		@SuppressWarnings("unchecked")
		List<Book> bookDetails = (List<Book>) this.restTemplate.getForObject("http://localhost:8985/api/books",
				List.class);
		return bookDetails;
	}

	@Override
	public Book getBookById(long bookId) {
		Book bookDetails = this.restTemplate.getForObject("http://localhost:8985/api/books" + "/" + bookId, Book.class);
		return bookDetails;
	}

	@Override
	public void removeBook(long bookId) {
		this.restTemplate.delete("http://localhost:8985/api/books" + "/" + bookId, Book.class);

	}

	@Override
	public Book getBookByBookCode(long bookCode) {
		return this.restTemplate.getForObject("http://localhost:8985/api/books" + "/book/" + bookCode, Book.class);
	}

}
