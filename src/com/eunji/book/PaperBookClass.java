package com.eunji.book;

public class PaperBookClass extends BookClass{
	// 필드
	int size;
	
	// 기본 생성자
	public PaperBookClass() {}
	
	public PaperBookClass(String title, String author, int price, String pubisher, int size) {
		super(title, author, price, pubisher);
		this.size = size;
		
	}
	
	// 도서 등록 시 페이지를 출력하는 METHOD
	public void sizeInfo() {
		System.out.printf("""
				제목: %s
				저자: %s
				가격: %d
				출판사: %s
				페이지 수: %d
				  """, super.getTitle(), super.getAuthor(), super.getPrice(), super.getPublisher(), size);
		
	}

	// 구매 METHOD
	public void purchase() {
		System.out.printf("%s의 가격은 %d입니다. 총 페이지는 %d입니다. \n", super.getTitle(), super.getPrice(), size);
		
		
	}

}
