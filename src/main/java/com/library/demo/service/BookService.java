package com.library.demo.service;

import java.util.List;
import java.util.Optional;

import com.library.demo.model.Book;

public interface BookService {
	
	public Optional<Book> searchBookById(Long id);
	public List<Book> getAllBooks();
	public Book addBook(Book book);
	public void removeBook(Long id);
	public Book updateBook(Long id, String author, Long aisle);

}
