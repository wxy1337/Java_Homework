package com;

public class Book {
	private String name;
	private String author;
	public double price;
	private String category;
	private boolean state;
	
	public Book(String name, String author, double price, String category, boolean state) {
		this.author = author;
		this.name = name;
		this.price = price;
		this.category = category;
		this.state = state;
	}
	
	public Book() {
		this(10);
	}
	public Book(int i) {
		Person.books = new Book[i];
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
	
}
