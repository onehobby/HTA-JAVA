package oop4;

public class Product {

	String name;		//이름
	String maker;		//출판사
	String category;	//카테고리
	int price;			//가격
	double discountRate;//할인율
	int stock; 			//재고량
	boolean isSoldOut;	//절판여부
	
	Product() {
		
	}
	
	// 신제품 객체의 멤버변수 초기화에 적합한 생성자 메소드, 신제품은 가격할인0 솔드아웃이 아니기때문에
	Product(String name, String maker, String category, int price, int stock) {
//		* this()메소드 사용 전 코드
//		this.name = name;
//		this.maker = maker;
//		this.category = category;
//		this.price = price;
//		this.discountRate = discountRate;
//		this.isSoldOut = isSoldOut;
//		this(name, maker, category, price, 0.0, stock ,false);
	}

	// 이월 제품 객체의 멤버변수 초기화에 적합한 생성자 메소드, 이월제품은 솔드아웃이 아니기때문에
	Product(String name, String maker, String category, int price, double discountRate, int stock) {
//		* this()메소드 사용 전 코드
//		this.name = name;
//		this.maker = maker;
//		this.category = category;
//		this.price = price;
//		this.discountRate = discountRate;
//		this.isSoldOut = isSoldOut;
		this(name, maker, category, price, discountRate, stock, false);
	}
	
	
	Product(String name, String maker, String category,
				int price, double discountRate, int stock, boolean isSoldOut) {
		
		this.name = name;
		this.maker = maker;
		this.category = category;
		this.price = price;
		this.discountRate = discountRate;
		this.isSoldOut = isSoldOut;

	}

	// 조회기능
	void display() {
		System.out.println("--------상품정보---------");
		System.out.println("상품이름: " + name);
		System.out.println("제조회사: " + maker);
		System.out.println("카테고리: " + category);
		System.out.println("판매가격: " + price);
		System.out.println("할인비율: " + discountRate);
		System.out.println("재 고 량: " + stock);
		System.out.println("절판여부: " + isSoldOut);
		System.out.println("----------------------");
	}
	
	// 입고량 증가기능
	void add(String name, int amount) {
		Product product = new Product(name, maker, category, price, stock);
		this.name  = name;
		this.maker = maker;
		this.category = category;
		this.price = price;
		this.stock = stock;
		
		
	}
	
	
	
	
}
