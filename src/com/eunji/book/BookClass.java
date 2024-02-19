package com.eunji.book;

public class BookClass {
	private String title;
	private String author;
	private int price;
	private String publisher;
	private float tax = 1.1f;
	
	// 기본 생성자
	public BookClass() {
		
	}
	
	// 초기화 해주는 생성자
	public BookClass(String title, String author, int price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		
	}

	// GETTER && SETTER
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}
	
	public void bookInfo() {
		System.out.printf("title: %s, author: %s, price: %d, publisher: %s \n", getTitle(), getAuthor(), getPrice(), getPublisher());
		
	}

}
