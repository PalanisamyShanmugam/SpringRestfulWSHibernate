package com.javaspringclub.service;

import java.util.List;

import com.javaspringclub.entity.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	public Book getBookInfoById(Long id);
	public void deleteById(long book_id);
	public void addBook(Book book);
	
	//public Book getBookInfoByTitle(String book_title);
	
	

}
