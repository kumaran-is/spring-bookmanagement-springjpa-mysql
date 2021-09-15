package com.library.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.demo.exception.ResourceAlreadyExistsException;
import com.library.demo.exception.ResourceNotFoundException;
import com.library.demo.model.Book;
import com.library.demo.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Optional<Book> searchBookById(Long id) {
		
		return bookRepository.findById(id);
		
	}
	
	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}
	
	@Override
	public Book addBook(Book book) { 
		Optional<Book>  bookOptional = bookRepository.findBookByIsbn(book.getIsbn());
		
		if(bookOptional.isPresent()) {
			log.error("Book with isbn " + book.getIsbn() + "  already available in the library");
			throw new ResourceAlreadyExistsException("Book with isbn " + book.getIsbn() + "  already available in the library");
		}
		
		return bookRepository.save(book);
	}
	
	@Override
	public void removeBook(Long id) { 
		
		boolean exists = bookRepository.existsById(id);
		if(!exists) {
			log.error("Book with id " + id + " does not exists");
			throw new ResourceNotFoundException("Book with id " + id + " does not exists");
		}
		
		bookRepository.deleteById(id);
		
	}
	
	@Override
	public Book updateBook(Long id, String author, Long aisle) {
		
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> 
				{
					log.error("Book with id " + id + " does not exists");
					throw new ResourceNotFoundException("Book with id " + id + " does not exists"); 
				});
		
		if(author != null  && !Objects.equals(book.getAuthor(),  author)) {
			book.setAuthor(author);
		}
		
		if(aisle != null && !Objects.equals(book.getAisle(),  aisle)) {
			book.setAisle(aisle);
		}
		bookRepository.save(book);
		
		return book;
	}
}
