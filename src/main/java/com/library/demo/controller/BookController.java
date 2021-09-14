package com.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.demo.model.Book;
import com.library.demo.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getBooks() {
		
		return bookService.getAllBooks();
	}
	
	@PostMapping
	public void addBook(@RequestBody Book book) {
		
		bookService.addBook(book);
	}
	

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id) {
		
		bookService.removeBook(id);
	}
	
	@PutMapping("/{id}")
	public void modifyBook(
			@PathVariable Long id,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) Long aisle) {
		
		bookService.updateBook(id, author, aisle);
	}

}
