package com.eunji.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookClass bookClass = new BookClass();
		EBooksClass eBooksClass = new EBooksClass();
		PaperBookClass paperBookClass = new PaperBookClass();
		
		List<BookClass> bookList = new ArrayList<BookClass>();
		boolean run = true;
		while(run) {
		System.out.println("1. 도서 등록 2. 도서 검색 3. 도서 삭제 4. 도서 확인 5. 도서 구입 6. 종료");
		int choice = sc.nextInt();
		sc.nextLine();
		
		if(choice == 1) {		// 도서 등록
			regist(bookList);
			
		} else if(choice == 2) {
			// 제목 or 저자 검색
			System.out.println("찾으려는 도서의 제목 또는 저자를 검색하세요.");
			String search = sc.nextLine();
			
			search(bookList, search);
			
		}
	}
}
	
	/*
	 * 도서 등록 METHOD START
	 */
	public static List<BookClass> regist(List<BookClass> bookList) {
		Scanner sc = new Scanner(System.in);
		// BookClass bookClass = new BookClass();
		// EBooksClass eBooksClass = new EBooksClass();
		// PaperBookClass paperBookClass = new PaperBookClass();
		
		System.out.println("1. 전자책 2. 종이책");
		int kind = sc.nextInt();
		sc.nextLine();
		if(kind == 1) {
			System.out.print("[도서등록]title: ");
			String title = sc.nextLine();
			
			System.out.print("[도서등록]author: ");
			String author = sc.nextLine();
			
			System.out.print("[도서등록]price: ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("[도서등록]publisher: ");
			String publisher = sc.nextLine();
			
			System.out.print("[도서등록] 호환기기: " );
			String superDevice = sc.nextLine();
			
			EBooksClass eBooksClass = new EBooksClass(title, author, price, publisher, superDevice);
			bookList.add(eBooksClass);
			
			eBooksClass.deviceInfo();
//			System.out.printf("title: %s, author: %s, price: %d, publisher: %s, superDevice: %s \n", title, author, price, publisher, superDevice);
			
			return bookList;
			
		} else if(kind == 2){
			System.out.print("[도서등록]title: ");
			String title = sc.nextLine();
			
			System.out.print("[도서등록]author: ");
			String author = sc.nextLine();
			
			System.out.print("[도서등록]price: ");
			int price = sc.nextInt();
			sc.nextLine();
			
			System.out.print("[도서등록]publisher: ");
			String publisher = sc.nextLine();
			
			System.out.println("[도서등록]size: " );
			int size = sc.nextInt();
			sc.nextLine();
			
			PaperBookClass paperBookClass = new PaperBookClass(title, author, price, publisher, size);
			 
			bookList.add(paperBookClass);
			System.out.printf("title: %s, author: %s, price: %d, publisher: %s, superDevice: %s \n", title, author, price, publisher, size);
			
			return bookList;
			
		}
		return bookList;
		
	}
	/*
	 * 도서 등록 METHOD END
	 */
	
	/*
	 * 도서 검색 METHOD START
	 */
	public static void search(List<BookClass> bookList, String search) {
		System.out.println(bookList.size());
		
		// 입력 받은 제목/저자 값으로 배열에 저장되어있는 객체 찾기 + 출력
		for(int i = 0; i < bookList.size(); i++) {
			if(search.equals(bookList.get(i).getAuthor()) || search.equals(bookList.get(i).getTitle())) {
				if(bookList.get(i) instanceof EBooksClass) {
				BookClass bookClass = new EBooksClass();
				
			}
			}else {
				System.out.println("해당 도서가 존재하지 않습니다.");
				
			}
			
		}
		
	}

}
