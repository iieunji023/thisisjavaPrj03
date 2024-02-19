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
		System.out.println("1.도서 등록 2.도서 검색 3.도서 삭제 4.도서 확인 5.도서 구입 6.종료");
		int choice = sc.nextInt();
		sc.nextLine();
		
		if(choice == 1) {		// 도서 등록
			regist(bookList);
			
		} else if(choice == 2) {		// 도서 검색(제목, 저자)
			System.out.println("찾으려는 도서의 제목 또는 저자를 검색하세요.");
			String search = sc.nextLine();
			search(bookList, search);
			
		} else if(choice == 3) {		// 도서 삭제(제목)
			System.out.println("삭제하려는 도서의 제목을 입력해주세요.");
			String search = sc.nextLine();
			delete(bookList, search, sc);
			
		} else if(choice == 4) {		// 도서 전체 검색
			searchAll(bookList);
			
		} else if(choice == 5) {		// 도서 구입
			
			
		} else if(choice == 6) {
			System.out.println("프로그램이 종료되었습니다.");
			run = false;
			
		} else {
			System.out.println("다시 입력해주세요");
			
		}
	}
}
	
	/*
	 * 도서 등록 METHOD START
	 */
	public static List<BookClass> regist(List<BookClass> bookList) {
		System.out.println("[BookMain] regist()");

		Scanner sc = new Scanner(System.in);
		
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
			
			System.out.print("[도서등록]size: " );
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
	public static List<BookClass> search(List<BookClass> bookList, String search) {
		System.out.println("[BookMain] search()");
		
		boolean select = false;
		
		// 입력 받은 제목/저자 값으로 배열에 저장되어있는 객체 찾기 + 출력
		for(int i = 0; i < bookList.size(); i++) {
			if(search.equals(bookList.get(i).getAuthor()) || search.equals(bookList.get(i).getTitle())) {
				System.out.printf("\n title: %s \n author: %s \n price: %d \n publisher: %s \n ", bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPrice(), bookList.get(i).getPublisher());

				select = true;
				
//				 if(bookList.get(i) instanceof EBooksClass) {
//						System.out.printf("[instanceof EBooksClass] \n title: %s \n author: %s \n price: %d \n publisher: %s \n ", bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPrice(), bookList.get(i).getPublisher());
//						
//						return bookList;
//						
//				 } else if(bookList.get(i) instanceof PaperBookClass) {
//				System.out.printf("[instanceof Paper] \n title: %s \n author: %s \n price: %d \n publisher: %s \n ", bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPrice(), bookList.get(i).getPublisher());
//
//				return bookList;
//				
//			 }	
			} 
			
				}
		if(!select) {
			System.out.println("해당 도서가 존재하지 않습니다.");
			
		}
		return bookList;
		
	}
	/*
	 * 도서 검색 METHOD END
	 */
	
	/*
	 * 도서 삭제 METHOD START
	 */
	public static void delete(List<BookClass> bookList, String search, Scanner sc) {
		System.out.println("[BookMain] delete()");

		for(int i = 0; i < bookList.size(); i++) {
			if(search.equals(bookList.get(i).getTitle())) {
				
				// 검색한 목록 출력
				bookList = search(bookList, search);
				System.out.println(bookList.get(0) instanceof EBooksClass);
				System.out.println(bookList.get(0) instanceof PaperBookClass);
				
				System.out.println("조회----> " + bookList.get(i).getTitle());
				
				System.out.println("정말 삭제하시겠습니까?(Y/N)");
				String yn = sc.nextLine();
				
				if(yn.equals("Y")) {
					for(int j = 0; j < bookList.size(); j++) {
						if(bookList.get(i) instanceof EBooksClass) {
						bookList.remove(i);
						System.out.printf("%s이(가) 삭제되었습니다. \n", bookList.get(i).getTitle());
						} else if(bookList.get(i) instanceof PaperBookClass) {
							bookList.remove(i);
							System.out.printf("%s이(가) 삭제되었습니다. \n", bookList.get(i).getTitle());
						}
					}
				} else if(yn.equals("N")) {
					System.out.println("취소되었습니다.");
					
					return;
					
				} else {
					System.out.println("Y 또는 N으로 입력하세요");
					
				}
			} else {
				System.out.printf("%s가 존재하지 않습니다. \n", search);
				
				return;
				
			}
		}
	}
	/*
	 * 도서 삭제 METHOD END
	 */
	
	/*
	 * 도서 확인 METHOD START
	 */
	public static List<BookClass> searchAll(List<BookClass> bookList) {
		System.out.println("[BookMain] searchAll()");


		
		if(bookList.size() == 0) {
			System.out.println("등록된 책이 없습니다.");
			
		}

		for(int i = 0; i<bookList.size(); i++) {
			System.out.println(bookList.get(0) instanceof EBooksClass);
			System.out.println(bookList.get(0) instanceof PaperBookClass);
			
			System.out.printf("\n title: %s \n author: %s \n price: %d \n publisher: %s \n ", bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPrice(), bookList.get(i).getPublisher());
			
		}
		return bookList;
		
	}
	/*
	 * 도서 확인 METHOD END
	 */
	

}
