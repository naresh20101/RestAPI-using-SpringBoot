package com.boot.restbook.controller;

import java.util.List;
import java.util.Optional;

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
	public ResponseEntity< List<Book>> getbook()
	{ 
		List<Book> list=bookService.getAllBooks();
		if(list.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	return ResponseEntity.of(Optional.of(list));
	}
	@GetMapping("/getBooks/{id}")
	public ResponseEntity<Book> showBook(@PathVariable("id") int id)
	{
		Book book=bookService.geById(id);
		if(book==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{  Book b=null;
	  try {
		 b=this.bookService.addBook(book);
		 return ResponseEntity.of(Optional.of(b));
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
		
		
	}
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable("id") int id)
	{
		try {
			this.bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> uodateBook(@RequestBody Book book,@PathVariable("id") int id)
	{
		try {
		this.bookService.updateBook(book,id);
		return ResponseEntity.ok().body(book);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	

}
