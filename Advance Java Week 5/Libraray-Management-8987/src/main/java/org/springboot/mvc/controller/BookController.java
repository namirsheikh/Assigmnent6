package org.springboot.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springboot.mvc.helper.DisplayMessageToJSP;
import org.springboot.mvc.model.Author;
import org.springboot.mvc.model.Book;
import org.springboot.mvc.model.Librarian;
import org.springboot.mvc.service.AuthorService;
import org.springboot.mvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;
	

	@RequestMapping("/bookList")
	public String showBookListPage(Model model, HttpSession session) {

		List<Book> bookDetails = this.bookService.listBooks();
		model.addAttribute("books", bookDetails);
		
		Librarian loggedINAdmin = (Librarian) session.getAttribute("user");
		
		System.out.println("user is"+" "+loggedINAdmin);
		if(loggedINAdmin == null) {
		DisplayMessageToJSP message = new DisplayMessageToJSP("OOPS! Session TimeOut...", "error", "alert-warning");
		session.setAttribute("message", message);
		return "redirect:/login";
		}
		else {
		return "bookList";
		}
		
	}

	@GetMapping("/addform")
	public String showAddForm(Model model, HttpSession session) {
		List<Author> authorDetails = this.authorService.listAuthors();
		model.addAttribute("authors", authorDetails);
		return "addBookForm";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute("book") Book bookDetails, Model model) {
		Book existingBook = this.bookService.getBookByBookCode(bookDetails.getBookCode());

		if (existingBook != null) {
			model.addAttribute("message", "Book code should be unique!!");
			List<Author> authorDetails = this.authorService.listAuthors();
			model.addAttribute("existingBook", bookDetails);
			model.addAttribute("authors", authorDetails);
			return "addBookForm";
		}
		this.bookService.addBook(bookDetails);
		return "redirect:/bookList";
	}

	@GetMapping("/editform")
	public String showEditForm(Model model, HttpSession session) {

		List<Author> authorDetails = this.authorService.listAuthors();
		model.addAttribute("authors", authorDetails);
		return "editBookForm";
	}

	@PostMapping("/edit/{id}")
	public String handleEditForm(@PathVariable("id") long bookId, HttpSession session) {
		Book bookDetails = this.bookService.getBookById(bookId);
		session.setAttribute("book", bookDetails);
		return "redirect:/editform";
	}

	@RequestMapping("/delete/{id}")
	public String handleDelete(@PathVariable("id") long bookId) {
		this.bookService.removeBook(bookId);
		return "redirect:/bookList";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book bookDetails) {
		this.bookService.updateBook(bookDetails);
		return "redirect:/bookList";
	}
}
