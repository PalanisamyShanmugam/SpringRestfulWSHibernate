package com.javaspringclub.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long book_id;
	private String book_title;
    private double price;
    private int volume;
    private String publish_date;
	/**
	 * @return the book_id
	 */
	public long getBook_id() {
		return book_id;
	}
	/**
	 * @param book_id the book_id to set
	 */
	public void setBook_id(long book_id) {
		this.book_id = book_id;
	}
	/**
	 * @return the book_title
	 */
	public String getBook_title() {
		return book_title;
	}
	/**
	 * @param book_title the book_title to set
	 */
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	/**
	 * @param volume the volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	/**
	 * @return the publish_date
	 */
	public String getPublish_date() {
		return publish_date;
	}
	/**
	 * @param publish_date the publish_date to set
	 */
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
    
    
    
    
    
	

}
