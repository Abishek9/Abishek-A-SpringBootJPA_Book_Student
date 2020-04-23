package com.capgemini.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.springboot.cruddemo.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	// no need to write code
}
