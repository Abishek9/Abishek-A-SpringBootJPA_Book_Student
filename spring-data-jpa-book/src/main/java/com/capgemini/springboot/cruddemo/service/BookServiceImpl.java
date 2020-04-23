package com.capgemini.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.springboot.cruddemo.dao.BookRepository;
import com.capgemini.springboot.cruddemo.entity.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository thebookRepository) {
		bookRepository = thebookRepository;
	}

	@Override
	public List<Book> findAllBooks() {

		return bookRepository.findAll();
	}

	@Override
	public Book findBookById(int id) {

		Optional<Book> result = bookRepository.findById(id);
		Book book = null;
		if (result.isPresent()) {
			book = result.get();
		} else {
			throw new RuntimeException("Didn't find the Book Id :" + id);
		}

		return book;
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}

}
