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
	
	// 도서 등록 시 호환기기를 출력하기 위한 METHOD
	public void deviceInfo() {
		// 기존에 저장되어 있는 도서에 호환기기를 추가해야 한다.
		System.out.printf("""
						제목: %s
						저자: %s
						가격: %d
						출판사: %s
						호환기기: %s
						  """, super.getTitle(), super.getAuthor(), super.getPrice(), super.getPublisher(), superDevices);
		
	}
	
	// 구매 METHOD
	public void purchase() {
		// 구매 도서, 가격
		System.out.printf("%s의 가격은 %d입니다. \n", super.getTitle(), super.getPrice());
		System.out.printf("호환되는 기기는 %s입니다. \n", superDevices);
		
		
	}

}
