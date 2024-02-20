package com.eunji.book;

public class BookClass {
	private String title;
	private String author;
	private int price;
	private String publisher;
	private final float tax = 1.1f;
	
	// 기본 생성자
	public BookClass() {
		
	}
	
	// 초기화 해주는 생성자
	public BookClass(String title, String author, int price, String publisher) {
		this.title = title;
		this.author = author;
		this.price = (int)(price *  tax);
		this.publisher = publisher;
		
	}

	/*
	 * GETTER && SETTER
	 * private 접근제한자는 class 내에서만 사용할 수 있기 때문에
	 * 다른 class에서도 사용하기 위해서는 GETTER와 SETTER를 만들어줘야 한다.
	 */
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
	
	// EBookClass와 PaperBookClass에서 공통적으로 쓰이는 필드를 출력하기 위한 METHOD
	public void bookInfo() {
		System.out.printf("title: %s, author: %s, price: %d, publisher: %s \n", getTitle(), getAuthor(), getPrice(), getPublisher());
		
	}
	


}
