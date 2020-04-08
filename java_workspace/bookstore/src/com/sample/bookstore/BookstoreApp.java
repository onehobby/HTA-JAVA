package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.User;

public class BookstoreApp {

	public static void main(String[] args) {
	
		BookstoreService service = new BookstoreService();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println();
			System.out.println("[도서 대여점 관리 프로그램]");
			System.out.println("================================================");
			System.out.println(" 1.회원관리  2.도서관리  3.대여관리  0.종료");
			System.out.println("================================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if (menuNo == 1) {
				System.out.println();
				System.out.println("[회원 관리]");
				System.out.println("================================================");
				System.out.println(" 1.등록  2.조회  3.변경  4.탈퇴  5.전체조회 6. 고객대여현황조회");
				System.out.println("================================================");
				
				System.out.print("회원관련 메뉴를 선택하세요: ");
				int userMenuNo = scanner.nextInt();
				
				if (userMenuNo == 1) {
					System.out.println("[신규 회원 등록]");
					
					System.out.print("이름을 입력하세요: ");
					String name = scanner.next();
					System.out.print("전화번호를 입력하세요: ");
					String tel = scanner.next();
					
					service.addNewUser(name, tel);
					System.out.println("### 회원등록이 완료되었습니다.");
					
				} else if (userMenuNo == 2) {
					System.out.println("[회원 조회]");
					System.out.println("회원번호를 입력해주세요");
					int userNo = scanner.nextInt();
					service.retrieveUserInfo(userNo);
					
				} else if (userMenuNo == 3) {
					System.out.println("[회원 정보변경]");
					System.out.println("변경하실 회원의 회원번호를 입력해주세요");
					int userNumber = scanner.nextInt();
					System.out.println("변경하실 이름을 입력해주세요");
					String name = scanner.next();
					System.out.println("변경하실 전화번호를 입력해주세요");
					String tel = scanner.next();
					
					User user = new User(userNumber,name,tel,100,false);
					service.modifyUserInfo(user);
					
				} else if (userMenuNo == 4) {
					System.out.println("[회원탈퇴]");
					System.out.println("탈퇴하실 회원번호를 입력해주세요");
					int userNo = scanner.nextInt();
					service.disabledUser(userNo);
					
				} else if (userMenuNo == 5) {
					System.out.println("[전체회원정보 조회]");
					service.retrieveAllUsers();
				} else if (userMenuNo == 6) {
					System.out.println("[고객 대여현황조회]");
					System.out.println("조회하실 회원의 회원번호를 입력해주세요");
					int userNo = scanner.nextInt();
					
					service.userRentalInfo(userNo);
					
				}
				
			} else if (menuNo == 2) {
				System.out.println();
				System.out.println("[도서 관리]");
				System.out.println("================================================");
				System.out.println(" 1.검색  2.등록  3.수정  4.전체조회 5.도서대여현황조회");
				System.out.println("================================================");
				
				System.out.println("도서관련 메뉴를 선택하세요");
				int bookMenu = scanner.nextInt();
				if(bookMenu == 1) {
					System.out.println("[도서검색]");
					System.out.println("검색하실 책 제목을 입력해주세요");
					String title = scanner.next();
					service.searchBooks(title);
					
				} else if(bookMenu == 2) {
					System.out.println("[도서등록]");
					System.out.println("새로 등록하실 책 제목을 입력해주세요");
					String title = scanner.next();
					System.out.println("새로 등록하실 책의 저자를 입력해주세요");
					String writer = scanner.next();
					System.out.println("새로 등록하실 책의 가격을 입력해주세요");
					int price = scanner.nextInt();
					
					service.insertNewBook(title, writer, price);
					
				} else if(bookMenu == 3) {
					System.out.println("[도서목록 수정]");
					System.out.println("책의 번호를 입력해주세요");
					int no = scanner.nextInt();
					System.out.println("책의 제목을 입력해주세요");
					String title = scanner.next();
					System.out.println("책의 저자를 입력해주세요");
					String writer = scanner.next();
					System.out.println("책의 가격을 입력해주세요");
					int price = scanner.nextInt();
					
					Book book = new Book(no,title,writer,price,10000);
					
					service.modifyBook(book);
					
					
				} else if(bookMenu == 4) {
					System.out.println("[도서전체조회]");
					service.retrieveAllBooks();
					
				} else if(bookMenu == 5) {
					System.out.println("[도서대여현황조회]");
					System.out.println("조회할 책번호를 입력하세요");
					int bookNo = scanner.nextInt();
					
					service.bookRentalInfo(bookNo);
				}
				
				
				
			} else if (menuNo == 3) {
				System.out.println();
				System.out.println("[대여/반납 관리]");
				System.out.println("================================================");
				System.out.println(" 1.대여  2.반납  3.대여현황조회 4.일괄반납 ");
				System.out.println("================================================");
				
				System.out.println("대여/반납관리메뉴를 선택하세요");
				int rentalMenu = scanner.nextInt();
				
				if(rentalMenu == 1) {
					System.out.println("[대여]");
					System.out.println("회원번호를 입력해주세요");
					int userNo = scanner.nextInt();
					System.out.println("대여하실 책의 번호를 입력해주세요");
					int bookNo = scanner.nextInt();
					
					service.rentBook(userNo, bookNo);
					
				} else if(rentalMenu == 2) {
					System.out.println("[반납]");
					System.out.println("대여번호를 입력해주세요");
					int rentalNo = scanner.nextInt();
					
					service.returnBook(rentalNo);
					
				} else if(rentalMenu == 3) {
					System.out.println("[대여현황조회]");
					service.retrieveAllRentals();
				} else if(rentalMenu == 4) {
					System.out.println("[일괄반납처리]");
					System.out.println("회원번호를 입력하세요");
					int userNo = scanner.nextInt();
					service.allReturnBook(userNo);
				}
					
				
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
		
		scanner.close();
	}
}