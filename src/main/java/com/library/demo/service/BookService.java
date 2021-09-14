package com.library.demo.service;

import java.util.List;
import java.util.Optional;

import com.library.demo.model.Book;

public interface BookService {
	
	public Optional<Book> searchBookById(Long id);
	public List<Book> getBooks();
	public void addBook(Book book);
	public void removeBook(Long id);
	public void updateBook(Long id, String author, Long aisle);

}
