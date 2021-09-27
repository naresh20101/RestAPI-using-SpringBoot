package com.boot.restbook.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.restbook.Model.Book;
@Component
public class BookService {
	private static List<Book> list=new ArrayList<>();
	static {
		list.add(new Book(45,"Java Prograaming","Turab Bajeer"));
		list.add(new Book(48,"Python Prograaming","JK"));
	}
//get all books
	public List<Book> getAllBooks()
	{
		return list;
	}

	//get single book by id
	
	public Book geById(int id)
	{
		Book book=null;
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	//add book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
}
