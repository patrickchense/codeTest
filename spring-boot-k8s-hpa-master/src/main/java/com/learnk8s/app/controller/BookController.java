package com.learnk8s.app.controller;

import com.learnk8s.app.exp.BookNotFoundException;
import com.learnk8s.app.model.Book;
import com.learnk8s.app.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * learn spring swagger api
 * https://www.baeldung.com/spring-rest-openapi-documentation
 */
@RestController
@RequestMapping("/api/book")
public class BookController {

	@Autowired
	private BookRepository repository;

	@GetMapping("/{id}")
	public Book findById(@PathVariable long id) throws BookNotFoundException {
		return repository.findById(id)
				.orElseThrow(BookNotFoundException::new);
	}

	@GetMapping("/")
	public Collection<Book> findBooks() {
		return repository.getBooks();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book updateBook(@PathVariable("id") final String id, @RequestBody final Book book) {
		return book;
	}
}
