package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class BookstoreService {

	BookService bookService = new BookService();
	UserService userService = new UserService();
	RentalService rentalService = new RentalService();
	
	// 회원등록 서비스
	// 이름, 전화번호를 전달받아서 회원등록 서비스를 제공한다.
	// 		- User객체를 생성해서 이름과 전화번호를 저장한다.
	//		- 회원등록시 100포인트를 지급한다.
	//		- UserService의 회원등록 기능을 실행한다.
	public void addNewUser(String name, String tel) {
		User user = new User();
		user.name = name;
		user.tel = tel;
		user.point = 100;
		user.isDisabled = false;
		
		userService.insertUser(user);
	}
	
	// 회원조회 서비스
	// 회원번호를 전달받아서 회원번호에 대한 회원정보를 화면에 출력한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.
	public void retrieveUserInfo(int userNo) {
		
	}
	
	// 회원수정 서비스
	// 수정할 회원정보를 전달받아서 해당 회원의 정보를 수정한다.
	//		- UserService의 회원정보 변경기능을 실행해서 회원정보를 수정한다.
	public void modifyUserInfo(User user) {
		
	}
	
	// 회원탈퇴 서비스
	// 탈퇴처리할 회원번호를 전달받아서 해당 회원을 탈퇴처리한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원의 탈퇴여부를 탈퇴처리로 변경한다.
	//		- RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		
	}
	
	// 전체 회원조회 서비스
	// 등록된 모든 회원정보 조회를 처리한다.
	// 		- UserService의 모든 회원정보 조회기능을 실행해서 모든 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.(null체크)
	public void retrieveAllUsers() {
		
	}
	
	// 도서등록 서비스
	// 제목, 저자, 가격을 전달받아서 도서 등록 서비스를 처리한다.
	//		- Book객체를 생성해서 제목, 저자, 가격 정보를 저장한다.
	//		- 재고는 10000권으로 한다.
	// 		- BookService의 도서등록기능을 실행한다.
	public void insertNewBook(String title, String writer, int price) {
		
	}
	
	// 도서 검색 서비스
	// 제목를 전달받아서 도서 검색서비스를 처리한다.
	//		- BookService의 도서 검색기능을 실행해서 책정보를 제공받는다.
	//		- 조회된 책정보를 화면에 출력한다.
	public void searchBooks(String title) {
		
	}
	
	// 도서 정보 수정 서비스
	// 책정보를 전달받아서 책정보 수정서비스를 처리한다.
	//		- BookService의 책정보 수정기능을 실행한다.
	public void modifyBook(Book book) {
		
	}
	
	// 전체도서 조회 서비스
	// 모든 책정보 조회 서비스를 처리한다.
	// 		- BookService의 모든 책조회 기능을 실행한다.
	public void retrieveAllBooks() {
		
	}
	
	// 대여 서비스
	// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
	//		- Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
	//		- 대여여부는 대여중으로 설정한다.
	//		- 책재고 변경하기
	//			- BookService에서 책번호에 해당하는 책정보 조회기능 실행
	//			- 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		
	}
	
	// 반납 서비스
	// 대여번호를 전달받아서 반납 서비스를 처리한다.
	//		- RentalService에서 대여번호에 해당하는 대여정보 조회 기능을 실행
	//		- 조회된 대여정보의 반납여부를 false로 설정한다.
	//		- 사용자포인트 증가, 책재고 변경하기
	//			- UserService에서 사용자번호로 사용자정보 조회하기 실행
	//			- BookService에서 책번호로 책정보 조회하기 실행
	//			- 조회된 사용자의 포인트를 책가격의 1%만큼 증가시키기
	//			- 조회된 책정보의 재고를 1증가시키기
	public void returnBook() {
		
	}
	
	// 대여현황 조회 서비스
	// 모든 대여정보를 조회하는 서비스를 처리한다.
	//		- RentalService의 전체 대여정보조회 기능을 실행한다.
	//		- 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		
	}
	
	
}
