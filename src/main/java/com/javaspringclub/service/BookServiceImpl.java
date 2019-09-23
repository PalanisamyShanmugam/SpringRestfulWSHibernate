package com.javaspringclub.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaspringclub.entity.Book;
import com.javaspringclub.repository.BookRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	// Implementing Constructor based DI
			private BookRepository repository;
			
			public BookServiceImpl() {
				
			}
			
			@Autowired
			public BookServiceImpl(BookRepository repository) {
				super();
				this.repository = repository;
			}

	@Override
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<Book>();
		repository.findAll().forEach(e -> list.add(e));
		return list;
	}

	@Override
	public Book getBookInfoById(Long id) {
		Book book = repository.findById(id).get();
		return book;
	}

	@Override
	public void deleteById(long book_id) {
		repository.deleteById(book_id);
		
	}

	@Override
	public void addBook(Book book) {
		repository.save(book);
		
	}


}
