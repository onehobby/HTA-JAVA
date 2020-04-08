package com.sample.bookstore.vo;

public class Book {

	public int no;					//책번호	
	public String title;			//책제목
	public String writer;			//저자
	public int price;				//가격
	public int stock;				//재고
	
	public Book() {}
	
	public Book(int no, String title, String writer, int price, int stock) {
		super();
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.price = price;
		this.stock = stock;
	}
	


	
	
	
	
}
