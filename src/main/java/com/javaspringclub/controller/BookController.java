package com.javaspringclub.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaspringclub.entity.Book;
import com.javaspringclub.repository.BookRepository;
import com.javaspringclub.service.BookService;

@Controller
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	BookRepository bookRepository;
	
	public BookController() {

	}

	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	
	@RequestMapping(value = "/home",method = RequestMethod.POST)
	public ModelAndView home(ModelAndView model) {
		System.out.println("Begin home in HomeController");
		model.setViewName("home");
		return model;							
			
	}	
	
	@RequestMapping(value = "/exit",method = RequestMethod.POST)
	public ModelAndView exit(HttpServletResponse response) throws IOException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("exit");
		return mv;
	}
	
	
	//Add a Book
	
	@RequestMapping(value = "/addBook",method = RequestMethod.POST)
		public ModelAndView addBook(ModelAndView model) {
			System.out.println("Begin addBook in MenuController");
			
			model.setViewName("addBook");
			
			return model;							
				
		}	
		
		@RequestMapping(value = "/addBookInfo",method = RequestMethod.POST)
		public ModelAndView addBookInfo(@RequestParam("book_id") String book_id,@RequestParam("book_title") String book_title,
				@RequestParam("price") String price,@RequestParam("volume") String volume,@RequestParam("publish_date") String publish_date,
				HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
			System.out.println("Start addBookInfo in BookController");
			
			Book book = new Book();
			book.setBook_id(Long.parseLong(book_id));
			book.setBook_title(book_title);
			book.setPrice(Double.valueOf(price));
			book.setVolume(Integer.parseInt(volume));
			book.setPublish_date(publish_date);
			bookService.addBook(book);
			
			
			List<Book> bookList = bookService.getAllBooks();
			System.out.println("addBookInfo bookList in BookController: "+bookList.size());
			
			model.addObject("bookList",bookList);
			model.setViewName("addBook");
			
			System.out.println("End addBookInfo in BookController");
			return model;					
			
			
		}
	
	
	
	@RequestMapping(value = "/getBookInfoId",method = RequestMethod.POST)
	public ModelAndView getBookInfo() {
		System.out.println("Begin getBookInfo in BookController");
		ModelAndView model = new ModelAndView();
		model.setViewName("getBookById");
		model.addObject("isVisible", false);
		return model;							
			
	}			

	@RequestMapping(value = "/getBookInfoById",method = RequestMethod.POST )
	public ModelAndView getBookInfoById(@RequestParam("book_id") String book_id,HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
		System.out.println("Begin getBookInfoById BookController");
		
		System.out.println("BookId in getBookInfoById Bookcontroller: "+book_id);
		Book book = bookService.getBookInfoById(Long.parseLong(book_id));
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book);
		
		System.out.println("getBookInfoById bookList in BookController: "+bookList);
		model.addObject("bookList",bookList);
		model.addObject("isVisible", true);
		model.addObject("book_id", book_id);
		model.setViewName("getBookById");
		
		return model;							
			
	}	
	
	
	
	//Delete 
	
		//Delete a Book
			@RequestMapping(value = "/deleteBook",method = RequestMethod.POST)
			public ModelAndView deleteBook() {
				System.out.println("Begin deleteBook in BookController");
				ModelAndView model = new ModelAndView();
				model.setViewName("deleteBook");
				
				model.addObject("isVisible", false);
				return model;							
					
			}	
			
				@RequestMapping(value = "/deleteBookInfo",method = RequestMethod.POST)
					public ModelAndView deleteBookInfo(@RequestParam("book_id") String book_id,HttpServletRequest request, HttpServletResponse response) {
						System.out.println("Begin OtherContactController getPharmacyList() ");
						ModelAndView model = new ModelAndView();
						
						System.out.println("BookId in deleteBookInfo MenuController: "+book_id);
						bookService.deleteById(Long.parseLong(book_id));
					
						
						List<Book> bookList = bookService.getAllBooks();
						System.out.println("deleteBookInfo bookList in BookController: "+bookList.size());
						model.addObject("bookList",bookList);
						model.addObject("isVisible", true);
						model.addObject("book_id", book_id);
						model.setViewName("deleteBook");
						
						return model;							
							
					}	
				
				
				
				@RequestMapping(value = "/getBookByTitle",method = RequestMethod.POST)
				public ModelAndView getBookByTitle() {
					System.out.println("Begin getBookByTitle in BookController");
					ModelAndView model = new ModelAndView();
					model.setViewName("getBookByTitle");
					model.addObject("isVisible", false);
					return model;							
						
				}			

				@RequestMapping(value = "/findByBookTitle",method = RequestMethod.POST )
				public ModelAndView findByBookTitle(@RequestParam("book_title") String book_title,HttpServletRequest request, HttpServletResponse response, ModelAndView model) {
					System.out.println("Begin findByBookTitle BookController");
					
					System.out.println("BookTitle in findByBookTitle Bookcontroller: "+book_title);
					Book book = bookRepository.findByBookTitle(book_title);
					List<Book> bookList = new ArrayList<Book>();
					bookList.add(book);
					
					System.out.println("findByBookTitle bookList in BookController: "+bookList);
					model.addObject("bookList",bookList);
					model.addObject("isVisible", true);
					model.addObject("book_title", book_title);
					model.setViewName("getBookByTitle");
					
					return model;							
						
				}	
				

}
