package com.ts.dto;

public class Book {
	private String bookName;
	private	int available;
	private String author;
	private int bookId;
	private int rating;
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRating() {
		return rating;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public int getAvailable() {
		return available;
	}
	public int getBookId() {
		return bookId;
	}
	public String getAuthor() {
		return author;
	}
	public String toString() {
		return (bookName+author) ;
	}
}
