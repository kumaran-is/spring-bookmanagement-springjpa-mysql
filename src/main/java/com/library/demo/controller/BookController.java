package com.library.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.ok().body(bookService.getAllBooks());
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		return ResponseEntity.ok().body(bookService.addBook(book));
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
		bookService.removeBook(id);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> modifyBook(
			@PathVariable Long id,
			@RequestParam(required = false) String author,
			@RequestParam(required = false) Long aisle) {
		
		return ResponseEntity.ok().body(bookService.updateBook(id, author, aisle));
	}

}
