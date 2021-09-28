package com.boot.restbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.restbook.Model.Book;
import com.boot.restbook.Services.BookService;

@RestController
 class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
	public Book getbooks()
	{
		Book book=new Book();
		book.setId(47);
		book.setTitle("The Secret");
		book.setAuthor("Rhonda Byrne");
		
		return book; 
	}
	@GetMapping("/getBooks")
	public List<Book> getbook()
	{
		return this.bookService.getAllBooks();
	}
	@GetMapping("/getBooks/{id}")
	public Book showBook(@PathVariable("id") int id)
	{
		return this.bookService.geById(id);
	}
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book)
	{ 
		Book b=this.bookService.addBook(book);
		return b;
		
	}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id)
	{
		this.bookService.deleteBook(id);
	}
	@PutMapping("/books/{id}")
	public Book uodateBook(@RequestBody Book book,@PathVariable("id") int id)
	{
		this.bookService.updateBook(book,id);
		return book;
	}
	
	

}
