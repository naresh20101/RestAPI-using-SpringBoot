package com.boot.restbook.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		try {
		
		
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return book;
		
	}
	//add book
	public Book addBook(Book b)
	{
		list.add(b);
		return b;
	}
	//delete book
	public void deleteBook(int id)
	{
		list=list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
	}
	//update book
	public void updateBook(Book book,int id)
	{
		list=list.stream().map(b->{
			if(b.getId()==id)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
	}
}
