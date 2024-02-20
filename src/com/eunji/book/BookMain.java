package com.eunji.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<BookClass> bookList = new ArrayList<BookClass>();

		boolean run = true;

		while (run) {
			System.out.println("++++++++++도서관리 프로그램++++++++++");
			System.out.println("1.도서 등록  2.도서 검색  3.도서 삭제  4.도서 확인  5.도서 구입  6.종료");
			System.out.print("메뉴선택: ");
			int choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) { // 도서 등록
				regist(bookList);

			} else if (choice == 2) { // 도서 검색(제목, 저자)
				System.out.println("찾으려는 도서의 제목 또는 저자를 검색하세요.");
				String search = sc.nextLine();
				search(bookList, search);

			} else if (choice == 3) { // 도서 삭제(제목)
				System.out.println("삭제하려는 도서의 제목을 입력해주세요.");
				String search = sc.nextLine();
				BookClass removeBookList = delete(bookList, search);
				
				if(removeBookList != null) {
					boolean rm = bookList.remove(removeBookList);
					if(rm) {
						System.out.printf("%s가 삭제되었습니다. \n", removeBookList.getTitle());
						
					}
				}
			} else if (choice == 4) { // 도서 전체 검색
				searchAll(bookList);

			} else if (choice == 5) { // 도서 구입
				System.out.println("구입하려는 도서 제목을 입력해주세요");
				String search = sc.nextLine();

				System.out.println("1.전자책 2.종이책");
				int sel = sc.nextInt();
				sc.nextLine();

				BookClass bookClass1 =  purchase(search, bookList, sel);
				if(bookClass1 == null) {
					System.out.println("구매할 책이 없습니다.");
					
				} else {
					bookList.remove(bookClass1);
					
				}
				
			} else if (choice == 6) {
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

		if (kind == 1) {
			System.out.print("[도서등록]title: ");
			String title = sc.nextLine();

			System.out.print("[도서등록]author: ");
			String author = sc.nextLine();

			System.out.print("[도서등록]price: ");
			int price = sc.nextInt();
			sc.nextLine();

			System.out.print("[도서등록]publisher: ");
			String publisher = sc.nextLine();

			System.out.print("[도서등록] 호환기기: ");
			String superDevice = sc.nextLine();

			EBooksClass eBooksClass = new EBooksClass(title, author, price, publisher, superDevice);
			bookList.add(eBooksClass);

			eBooksClass.deviceInfo();

			return bookList;

		} else if (kind == 2) {
			System.out.print("[도서등록]title: ");
			String title = sc.nextLine();

			System.out.print("[도서등록]author: ");
			String author = sc.nextLine();

			System.out.print("[도서등록]price: ");
			int price = sc.nextInt();
			sc.nextLine();

			System.out.print("[도서등록]publisher: ");
			String publisher = sc.nextLine();

			System.out.print("[도서등록]size: ");
			int size = sc.nextInt();
			sc.nextLine();

			PaperBookClass paperBookClass = new PaperBookClass(title, author, price, publisher, size);
			bookList.add(paperBookClass);

			paperBookClass.sizeInfo();

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
		for (int i = 0; i < bookList.size(); i++) {
			if (search.equals(bookList.get(i).getAuthor()) || search.equals(bookList.get(i).getTitle())) {
				if (bookList.get(i) instanceof EBooksClass ebooksClass) {
					System.out.println("\n ----전자책----");
					ebooksClass.deviceInfo();

					select = true;

				} else if (bookList.get(i) instanceof PaperBookClass paperBookClass) {
					System.out.println("\n ----종이책----");
					paperBookClass.sizeInfo();

					select = true;

				}
			}
		}
		if (!select) {
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
	public static BookClass delete(List<BookClass> bookList, String search) {
		System.out.println("[BookMain] delete()");

		BookClass removeBookList = new BookClass();

		for (int i = 0; i < bookList.size(); i++) {
			if(bookList.size() == 0) {
				System.out.println("등록된 책이 없습니다.");
				
			}
			
			if(!bookList.get(i).getTitle().equals(search)) {
				System.out.printf("%s가 재고에 없습니다. \n", search);
				
			}
			
			if (search.equals(bookList.get(i).getTitle())) {
				System.out.printf("[%d] %b \n", i, bookList.get(i) instanceof EBooksClass);
				System.out.printf("[%d] %b \n", i, bookList.get(i) instanceof PaperBookClass);

				removeBookList = bookList.get(i);
				
				return removeBookList;

			} 
		}
		return removeBookList;

	}
	/*
	 * 도서 삭제 METHOD END
	 */

	/*
	 * 도서 확인 METHOD START
	 */
	public static List<BookClass> searchAll(List<BookClass> bookList) {
		System.out.println("[BookMain] searchAll()");

		if (bookList.size() == 0) {
			System.out.println("등록된 책이 없습니다.");

		}

		for (int i = 0; i < bookList.size(); i++) {
			System.out.printf("\n title: %s \n author: %s \n price: %d \n publisher: %s \n ",
					bookList.get(i).getTitle(), bookList.get(i).getAuthor(), bookList.get(i).getPrice(),
					bookList.get(i).getPublisher());

		}
		return bookList;

	}
	/*
	 * 도서 확인 METHOD END
	 */

	/*
	 * 도서 구입 METHOD START
	 */
	public static BookClass purchase(String search, List<BookClass> bookList, int sel) {
		System.out.println("[BookMain] purchase()");
		for (int i = 0; i < bookList.size(); i++) {
			if (sel == 1) { 				// 전자책인 경우
				if (search.equals(bookList.get(i).getTitle()) && bookList.get(i) instanceof EBooksClass eBookClass) {
					System.out.println("------------------------");
					eBookClass.purchase();
					
					return eBookClass;

				} 
			} if (sel == 2) {		// 종이책인 경우
				if (search.equals(bookList.get(i).getTitle()) && bookList.get(i) instanceof PaperBookClass paperBookClass ) {
					System.out.println("------------------------");
					paperBookClass.purchase();
					
					return paperBookClass;

				} 
			}
		}
		if(bookList.size() == 0) {
			System.out.println("책이 존재하지 않습니다.");
			
		}
		return null;
	}

}
