package com.javaspringclub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaspringclub.entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	
	final static String GET_BOOK = "select b.book_id,b.book_title,b.price,b.volume,b.publish_date from book b where b.book_title = :book_title";
	
	@Query(nativeQuery = true, value=GET_BOOK)
    public Book findByBookTitle(@Param("book_title") String book_title);

}

