package com.api.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.dao.BookRepository;
import com.api.book.entities.Book;
@Component
public class BookServices {
	
	@Autowired
	private BookRepository repository;
	
//	private static List<Book> list=new ArrayList<>();
//	
//	static {
//		list.add(new Book(2, "Java", "Rohit"));
//		list.add(new Book(3, "Python", "Pawan"));
//		list.add(new Book(4, "JS", "Sajan"));
//	}
	
	public List<Book> getAllBooks()
	{
		List<Book>  list = (List<Book>) repository.findAll();
		return list;
	}
	
	public Book getBookById(int id)
	{
		Book book2 = null;
		try {
//			book2 = list.stream().filter(obj -> obj.getId()==id).findFirst().get();
			book2  = repository.findById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book2;
	}
	
	
	public Book addBook(Book b)
	{
//		list.add(b);
		Book save = repository.save(b);
		return save;
	}
	
	
	public void removeBook(int id)
	{
		
//		list = list.stream().filter(obj ->obj.getId()!=id).collect(Collectors.toList());
		repository.deleteById(id);
	}
	
	public Book updateBook(int id,Book book)
	{
//		list = list.stream().map(b -> {
//			if(b.getId()==id)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		Book save = repository.save(book);
		 
		  return save;
	}

}
