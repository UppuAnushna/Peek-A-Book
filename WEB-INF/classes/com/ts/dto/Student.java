
package com.ts.dto;

public class Student {
	private String bookName;
	private String rollNumber;
	private int edition;
	private String author;
	private int price;
	private int phnNumber;
	private String name;
	private String email;
	private String password;
	private String photo;
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setRollNumber(String rollNumber) {
		this.rollNumber = rollNumber;
	}
	public void setEdition(int  edition) {
		this.edition = edition;
	}
	public void setPhnNumber(int  phnNumber) {
		this.phnNumber = phnNumber;
	}
	public void setName(String  name) {
		this.name = name;
	}
	public void setEmail(String  email) {
		this.email = email;
	}
	public void setAuthor(String  author) {
		this.author = author;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookName() {
		return bookName;
	}
	public String getPhoto() {
		return photo;
	}
	public String getPassword() {
		return password;
	}
	public int getPhnNumber() {
		return phnNumber;
	}
	public String getRollNumber() {
		return rollNumber;
	}
	public int getEdition() {
		return edition;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public String getEmail() {
		return email;
	}
	public int getPrice() {
		return price;
	}
	public String toString() {
		return "Customer [customerId=" + bookName;
	}
}
