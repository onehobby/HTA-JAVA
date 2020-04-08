package com.sample.bookstore;

import java.util.Scanner;

import com.sample.bookstore.service.BookstoreService;

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
				System.out.println(" 1.등록  2.조회  3.변경  4.탈퇴  5.전체조회 ");
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
					
				} else if (userMenuNo == 3) {
					
				} else if (userMenuNo == 4) {
					
				} else if (userMenuNo == 5) {
					
				}
				
			} else if (menuNo == 2) {
				System.out.println();
				System.out.println("[도서 관리]");
				System.out.println("================================================");
				System.out.println(" 1.검색  2.등록  3.수정  4.전체조회");
				System.out.println("================================================");
				
			} else if (menuNo == 3) {
				System.out.println();
				System.out.println("[대여/반납 관리]");
				System.out.println("================================================");
				System.out.println(" 1.대여  2.반납  3.대여현황조회");
				System.out.println("================================================");
				
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
		
		scanner.close();
	}
}
