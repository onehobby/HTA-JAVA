package com.sample.bookstore.service;

import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Rental;
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
		User userInfo = userService.findUserByNo(userNo);
		if(userInfo == null) {
			System.out.println("올바른 회원번호를 입력해주세요");
		} else {
			System.out.println("회원번호\t이름\t전화번호\t\t보유포인트");
			System.out.print(userInfo.no+"\t");
			System.out.print(userInfo.name+"\t");
			System.out.print(userInfo.tel+"\t");
			System.out.print(userInfo.point+"\t");
		}
	}
	
	// 회원수정 서비스
	// 수정할 회원정보를 전달받아서 해당 회원의 정보를 수정한다.
	//		- UserService의 회원정보 변경기능을 실행해서 회원정보를 수정한다.
	public void modifyUserInfo(User user) {
		userService.updateUser(user);
	}
	
	// 회원탈퇴 서비스
	// 탈퇴처리할 회원번호를 전달받아서 해당 회원을 탈퇴처리한다.
	//		- UserService의 회원조회기능을 실행해서 회원정보를 제공받는다.
	//		- 조회된 회원의 탈퇴여부를 탈퇴처리로 변경한다.
	//		- RentalService의 반납기능을 실행해서 해당 회원이 대여중인 모든 책을 반납처리한다.
	public void disabledUser(int userNo) {
		User disabledUser = userService.findUserByNo(userNo);
		if(disabledUser == null) {
			System.out.println("올바른 회원번호를 입력해주세요");
		} else {
			disabledUser.isDisabled = true;
			rentalService.returnAllRentalByUserNo(userNo);
		}
	}
	
	// 전체 회원조회 서비스
	// 등록된 모든 회원정보 조회를 처리한다.
	// 		- UserService의 모든 회원정보 조회기능을 실행해서 모든 회원정보를 제공받는다.
	//		- 조회된 회원정보를 화면에 출력한다.(null체크)
	public void retrieveAllUsers() {
		User[] allUser = userService.getAllUsers();
		System.out.println("회원번호\t이름\t전화번호\t\t보유포인트");
		for(int i = 0; i < allUser.length; i++) {
			if(allUser[i] == null) {
				break;
			}
			System.out.print(allUser[i].no+"\t");
			System.out.print(allUser[i].name+"\t");
			System.out.print(allUser[i].tel+"\t");
			System.out.println(allUser[i].point+"\t");
		}
	}
	
	// 회원번호를 입력받아서 그 고객이 대여중인 모든 책정보(책번호, 제목, 가격, 대여상태) 출력하기
	public void userRentalInfo(int userNo) {
		
		System.out.println("책번호\t제목\t가격\t대여상태");
		System.out.println("=====================");
		
		Rental[] rentals = rentalService.findRentalByUserNo(userNo);
		for(int i = 0; i < rentals.length; i++) {
			if(rentals[i] == null) {
				break;
			}
			String title = bookService.findBookNameByNo(rentals[i].bookNo);
			int price = bookService.findBookPriceByNo(rentals[i].bookNo);
			
			
			System.out.print(rentals[i].bookNo+"\t");
			System.out.println(title+"\t");
			System.out.println(price+"\t");
			System.out.print(rentals[i].isRent+"\t");
			
		}
	}
	
	// 도서등록 서비스
	// 제목, 저자, 가격을 전달받아서 도서 등록 서비스를 처리한다.
	//		- Book객체를 생성해서 제목, 저자, 가격 정보를 저장한다.
	//		- 재고는 10000권으로 한다.
	// 		- BookService의 도서등록기능을 실행한다.
	public void insertNewBook(String title, String writer, int price) {
		Book book = new Book();
		book.title = title;
		book.writer = writer;
		book.price = price;
		book.stock = 10000;
		
		bookService.insertBook(book);
		
	}
	
	// 도서 검색 서비스
	// 제목를 전달받아서 도서 검색서비스를 처리한다.
	//		- BookService의 도서 검색기능을 실행해서 책정보를 제공받는다.
	//		- 조회된 책정보를 화면에 출력한다.
	public void searchBooks(String title) {
		System.out.println("책번호\t책제목\t저자\t가격\t재고");
		Book[] findBook = bookService.findBookByTitle(title);
		for(int i = 0; i<findBook.length; i++) {
			System.out.print(findBook[i].no+"\t");
			System.out.print(findBook[i].title+"\t");
			System.out.print(findBook[i].writer+"\t");
			System.out.print(findBook[i].price+"\t");
			System.out.println(findBook[i].stock+"\t");
		}
	}
	
	// 도서 정보 수정 서비스
	// 책정보를 전달받아서 책정보 수정서비스를 처리한다.
	//		- BookService의 책정보 수정기능을 실행한다.
	public void modifyBook(Book book) {
		bookService.updateBook(book);
	}
	
	// 전체도서 조회 서비스
	// 모든 책정보 조회 서비스를 처리한다.
	// 		- BookService의 모든 책조회 기능을 실행한다.
	public void retrieveAllBooks() {
		Book[] allBook = bookService.getAllBooks();
		System.out.println("책번호\t책제목\t저자\t가격\t재고");
		for(int i = 0; i < allBook.length; i++) {
			if(allBook[i] == null) {
				break;
			}
			System.out.print(allBook[i].no+"\t");
			System.out.print(allBook[i].title+"\t");
			System.out.print(allBook[i].writer+"\t");
			System.out.print(allBook[i].price+"\t");
			System.out.println(allBook[i].stock);
		}
		
	}
	
	//책번호를 입력받아서 그 책에 대한 대여정보를 출력하는 기능
	public void bookRentalInfo(int bookNo) {
		
		System.out.println("대여번호\t도서번호\t도서제목\t회원번호\t회원이름\t대여상태");
		System.out.println("==========================================");
		
		Rental[] rentals = rentalService.findRentalByBookNo(bookNo);
		for(int i = 0; i < rentals.length; i++) {
			if(rentals[i] == null) {
				break;
			} 
			
			String title = bookService.findBookNameByNo(rentals[i].bookNo);
			String userName = userService.findUserNameByNo(rentals[i].userNo);
			
			System.out.print(rentals[i].no+"\t");
			System.out.print(rentals[i].bookNo+"\t");
			System.out.print(title+"\t");
			System.out.print(rentals[i].userNo+"\t");
			System.out.print(userName+"\t");
			System.out.print(rentals[i].isRent);
			
		}
		
		
	}
	
	// 대여 서비스
	// 사용자번호와 책번호를 전달받아서 대여 서비스를 처리한다.
	//		- Rental객체를 생성해서 사용자번호, 책번호를 저장한다.
	//		- 대여여부는 대여중으로 설정한다.
	//		- 책재고 변경하기
	//			- BookService에서 책번호에 해당하는 책정보 조회기능 실행
	//			- 조회된 책의 재고를 1감소시킨다.
	public void rentBook(int userNo, int bookNo) {
		Rental rental = new Rental();
		rental.userNo = userNo;
		rental.bookNo = bookNo;
		rental.isRent = true;
		
		rentalService.insertRental(rental);
		Book rentalBook = bookService.findBookByNo(bookNo);
		rentalBook.stock -= 1;
		
		
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
	public void returnBook(int rentalNo) {
		
		Rental rentalBook = rentalService.findRentalByNo(rentalNo);
		User findUser = userService.findUserByNo(rentalBook.userNo);
		Book findbook = bookService.findBookByNo(rentalBook.bookNo);
		rentalBook.isRent = false;
		findUser.point += (int)(findbook.price * 0.01);
		findbook.stock += 1;
		
	}
	
	// 대여현황 조회 서비스
	// 모든 대여정보를 조회하는 서비스를 처리한다.
	//		- RentalService의 전체 대여정보조회 기능을 실행한다.
	//		- 조회된 대여정보를 화면에 출력한다. (null체크)
	public void retrieveAllRentals() {
		System.out.println("대여번호\t도서번호\t책제목\t고객번호\t고객명\t상태");
		Rental[] allRental = rentalService.getAllRentals();
		User[] alluser = userService.getAllUsers();
		Book[] allbook = bookService.getAllBooks();
		
		String findBookTitle = "";
		String findUser = "";
		for(int i = 0; i < allRental.length; i++) {
			if(allRental[i] == null) {
				break;
			}
			if(allRental[i].userNo == alluser[i].no) {
				findUser = alluser[i].name;
			}
			if(allRental[i].bookNo == allbook[i].no) {
				findBookTitle = allbook[i].title;
			}
			
			System.out.print(allRental[i].no+"\t");
			System.out.print(allRental[i].bookNo+"\t");
			System.out.print(findBookTitle + "\t");
			System.out.print(allRental[i].userNo+"\t");
			System.out.print(findUser + "\t");
			System.out.print(allRental[i].isRent+"\t");
		}
		
	}
	
	public void allReturnBook(int userNo) {
		
		rentalService.returnAllRentalByUserNo(userNo);
		
	}
	
	
	
	
}