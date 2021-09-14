package com.library.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.model.Book;
import com.library.demo.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	public Optional<Book> searchBookById(Long id) {
		
		return bookRepository.findById(id);
		
	}
	
	public List<Book> getBooks() {
		
		return bookRepository.findAll();
	}
	
	public void addBook(Book book) { 
		Optional<Book>  bookOptional = bookRepository.findBookByIsbn(book.getIsbn());
		
		if(bookOptional.isPresent()) {
			throw new IllegalStateException("Book already been added");
		}
		
		bookRepository.save(book);
	}
	

	public void removeBook(Long id) { 
		
		boolean exists = bookRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("Book with id " + id + " does not exists");
		}
		
		bookRepository.deleteById(id);
		
	}
	
	@Transactional
	public void updateBook(Long id, String author, Long aisle) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException("Book with id " + id + " does not exists"));
		
		if(author != null  && !Objects.equals(book.getAuthor(),  author)) {
			book.setAuthor(author);
		}
		
		if(aisle != null && !Objects.equals(book.getAisle(),  aisle)) {
			book.setAisle(aisle);
		}
	}
}
