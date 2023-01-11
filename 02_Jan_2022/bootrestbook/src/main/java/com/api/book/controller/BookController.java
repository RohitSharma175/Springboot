package com.api.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Book;
import com.api.book.service.BookServices;

//@Controller  when you use controller then you have to use @ResponseBody for return msg as it 

@RestController
public class BookController {
	
	@Autowired
	private BookServices service;
	
//	@RequestMapping(value="/books", method = RequestMethod.GET)
//	@ResponseBody
//	this crossOrigin is used for ract front end it will hite 
	@CrossOrigin
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks()
	{
//		Book b1 = new Book(1, "Java", "Rohit");
//		return "this is testing book first";
		List<Book> list = service.getAllBooks();
		if(list.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id)
	{
		Book bookById = service.getBookById(id);
		if(bookById==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(bookById));
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book b)
	{
		
		Book addBook = null;
		try {
			addBook = service.addBook(b);
			return ResponseEntity.status(HttpStatus.CREATED).body(addBook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	@CrossOrigin
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{
		try {
			System.out.println("iii");
			service.removeBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	@CrossOrigin
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book b,@PathVariable("id") int id)
	{
		Book updateBook= null;
		try {
			updateBook = service.updateBook(id, b);
			return  ResponseEntity.ok().body(updateBook);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

}
