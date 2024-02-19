package com.eunji.book;

public class PaperBookClass extends BookClass{
	int size;
	
	public PaperBookClass() {}
	
	public PaperBookClass(String title, String author, int price, String pubisher, int size) {
		super(title, author, price, pubisher);
		this.size = size;
		
	}
	
	public void sizeInfo() {
		
		
	}

}
