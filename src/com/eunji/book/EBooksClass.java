package com.eunji.book;

public class EBooksClass extends BookClass{
	String superDevices;
	
	// 기본 생성자
	public EBooksClass() {
		
	}
	
	// 초기화 시킬 생성자
	public EBooksClass (String title, String author, int price, String publisher, String superDevices) {
		super(title, author, price, publisher);
		this.superDevices = superDevices;
		
	}
	
	public void deviceInfo() {
		// 기존에 저장되어 있는 도서에 호환기기를 추가해야 한다.
		super.bookInfo();
		System.out.printf("superDevices: %s \n", superDevices);
		//System.out.println(super.getAuthor());
		
	}

}
