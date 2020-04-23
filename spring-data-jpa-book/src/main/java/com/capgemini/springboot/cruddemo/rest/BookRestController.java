package com.capgemini.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.cruddemo.entity.Book;
import com.capgemini.springboot.cruddemo.service.BookService;

@RestController
@RequestMapping("/api")
public class BookRestController {

	private BookService bookService;

	@Autowired
	public BookRestController(BookService thebookService) {
		bookService = thebookService;
	}

	// expose "/books" to return list of books
	@GetMapping("/books")
	public List<Book> findAllBooks() {

		return bookService.findAllBooks();
	}

	// add mapping for GET /books/{bookId}
	@GetMapping("/books/{bookId}")
	public Book getBook(@PathVariable int bookId) {

		Book book = bookService.findBookById(bookId);

		if (book == null) {
			throw new RuntimeException("Book Id not found:" + bookId);
		}

		return book;
	}

	// add mapping for POST /books - add new book
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {

		// also just in case they pass an id in JSON .... set id to 0
		// this is to force a save of new item .... instead of update
		book.setId(0);

		bookService.save(book);

		return book;
	}

	// add mapping for PUT /books - update book
	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {

		bookService.save(book);
		return book;
	}

	// add mapping for DELETE /books/{bookId} - delete book
	@DeleteMapping("/books/{bookId}")
	public String deleteBook(@PathVariable int bookId) {

		Book thebook = bookService.findBookById(bookId);

		// throw exception if null
		if (thebook == null) {
			throw new RuntimeException("Book Id not found:" + bookId);
		}
		bookService.deleteById(bookId);

		return "Deleted book id :" + bookId;

	}
}
