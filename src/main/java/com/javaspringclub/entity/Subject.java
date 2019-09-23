package com.javaspringclub.entity;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6132221244878168943L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long subject_id;
	private String subject_title;
	private int duration_inhours;
	private Book book;
	
	
	/**
	 * @return the subject_id
	 */
	public long getSubject_id() {
		return subject_id;
	}
	/**
	 * @param subject_id the subject_id to set
	 */
	public void setSubject_id(long subject_id) {
		this.subject_id = subject_id;
	}
	/**
	 * @return the subject_title
	 */
	public String getSubject_title() {
		return subject_title;
	}
	/**
	 * @param subject_title the subject_title to set
	 */
	public void setSubject_title(String subject_title) {
		this.subject_title = subject_title;
	}
	/**
	 * @return the duration_inhours
	 */
	public int getDuration_inhours() {
		return duration_inhours;
	}
	/**
	 * @param duration_inhours the duration_inhours to set
	 */
	public void setDuration_inhours(int duration_inhours) {
		this.duration_inhours = duration_inhours;
	}
   
	
	@Access(AccessType.PROPERTY)
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="book_id")
	public Book getBook() {
		return book;
	}
	/**
	 * @param references the references to set
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
	
	
	
	
}
