package com.capgemini.springboot.cruddemo.service;

import java.util.List;

import com.capgemini.springboot.cruddemo.entity.Book;

public interface BookService {

	public List<Book> findAllBooks();

	public Book findBookById(int id);

	public void save(Book book);

	public void deleteById(int id);
}
