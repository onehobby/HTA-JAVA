package com.sample.bookstore.app;


import java.util.List;

import com.sample.bookstore.service.BookstoreService;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class Bookstore {

	public static void main(String[] args) throws Exception {
		
		BookstoreService service = new BookstoreService();
		
		while(true) {
			System.out.println("---------------------------------------------------------------------------");
			System.out.println("1.가입  2.검색  3.책정보  4.주문  5.내주문  6.주문상세 7.문의게시판  0.종료");
			System.out.println("---------------------------------------------------------------------------");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = KeyboardUtil.nextInt();
			
			if (menuNo == 1) {
				System.out.println("[신규 회원가입]");
				
				System.out.print("아이디를 입력하세요: ");
				String id = KeyboardUtil.nextString();
				System.out.print("비밀번호를 입력하세요: ");
				String password = KeyboardUtil.nextString();
				System.out.print("이름을 입력하세요: ");
				String name = KeyboardUtil.nextString();
				System.out.print("이메일을 입력하세요: ");
				String email = KeyboardUtil.nextString();
				
				User user = new User();
				user.setId(id);
				user.setPassword(password);
				user.setName(name);
				user.setEmail(email);
				boolean isSuccess = service.회원가입(user);
				if (isSuccess) {
					System.out.println("### 회원가입이 완료되었습니다.");
				} else {
					System.out.println("!!! 이미 사용중인 아이디입니다.");
				}
				
				
			} else if (menuNo == 2) {
				System.out.println("[책 검색하기]");
				
				System.out.print("키워드를 입력하세요: ");
				String keyword = KeyboardUtil.nextString();
				
				List<Book> books = service.도서검색(keyword);
				if (books.isEmpty()) {
					System.out.println("!!! 검색결과가 존재하지 않습니다.");
				} else {
					System.out.println(books.size() + "권의 책이 조회되었습니다.");
					System.out.println("----------------------------------------------------------------------");
					System.out.println("번호\t제목\t저자\t출판사\t가격");
					System.out.println("----------------------------------------------------------------------");
					for(Book book : books) {
						System.out.print(book.getNo());
						System.out.print(book.getTitle()); 
						System.out.print(book.getWriter()); 
						System.out.print(book.getPublisher()); 
						System.out.println(book.getPrice()); 
					}
				}
				
			} else if (menuNo == 3) {
				System.out.println("[책정보 상세보기]");
				
				System.out.println("조회할 책번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				
				Book book = service.도서상세정보(bookNo);
				if (book == null) {
					System.out.println("!!! 유효한 책 번호가 아닙니다.");
				} else {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("번    호: "+ book.getNo());
					System.out.println("제    목: " + book.getTitle()); 
					System.out.println("저    자: " + book.getWriter()); 
					System.out.println("출 판 사: " + book.getPublisher()); 
					System.out.println("가    격: " + book.getPrice());
					System.out.println("할인가격: " + book.getDiscountPrice());
					System.out.println("재    고: " + book.getStock());
					System.out.println("등 록 일: " + book.getRegisteredDate());
					System.out.println("----------------------------------------------------------------------");
				}
				
			} else if (menuNo == 4) {
				System.out.println("[주문하기]");
				
				System.out.print("주문할 책번호를 입력하세요: ");
				int bookNo = KeyboardUtil.nextInt();
				System.out.print("주문수량을 입력하세요: ");
				int amount = KeyboardUtil.nextInt();
				System.out.print("주문자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				
				boolean isSuccess = service.주문하기(userId, bookNo, amount);
				if(isSuccess) {
					System.out.println("### 주문이 완료되었습니다.");
				} else {
					System.out.println("!!! 주문처리 중 오류가 발생하였습니다.");
				}
				
			} else if (menuNo == 5) {
				System.out.println("[내 주문 보기]");
				
				System.out.print("사용자 아이디를 입력하세요: ");
				String userId = KeyboardUtil.nextString();
				
				List<Order> myOrders = service.내주문조회(userId);
				if (myOrders.isEmpty()) {
					System.out.println("!!! 주문내역이 존재하지 않습니다.");
				} else {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("주문번호\t책제목\t구매수량\t가격");
					System.out.println("----------------------------------------------------------------------");
					for(Order order : myOrders) {
						System.out.print(order.getNo() + "\t");
						System.out.print(order.getBook().getTitle() + "\t");
						System.out.print(order.getAmount() + "\t");;
						System.out.println(order.getPrice());
					}
				} 
				
								
			} else if (menuNo == 6) {
				System.out.println("[주문정보 상세보기]");
				
				System.out.print("주문번호를 입력하세요: ");
				int orderNo = KeyboardUtil.nextInt();
				
				Order order = service.주문상세정보(orderNo);
				if(order == null) {
					System.out.println("!!! 주문번호에 해당하는 주문정보가 존재하지 않습니다.");
				} else {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("주문번호: " + order.getNo());
					System.out.println("사용자명: " + order.getUser().getName());
					System.out.println("제    목: " + order.getBook().getTitle() );
					System.out.println("가    격: " + order.getBook().getPrice());
					System.out.println("구매가격: " + order.getPrice());
					System.out.println("구매수량: " + order.getAmount());
					System.out.println("주문날짜: " + order.getRegisteredDate());
					System.out.println("----------------------------------------------------------------------");
				}
				
			} else if (menuNo == 7) {
				System.out.println("[문의게시판]");
				
				System.out.println("메뉴를 선택하세요");
				System.out.println("-----------------------------------------------");
				System.out.println("1.전체조회  2.등록  3.조회  4.삭제");
				System.out.println("-----------------------------------------------");
				
				int ansMenuNo = KeyboardUtil.nextInt();
				if(ansMenuNo == 1) {
					System.out.println("[문의글 전체조회]");
					
					List<Question> questions = service.모든질문조회();
					
					if (questions.isEmpty()) {
						System.out.println("### 질문이 존재하지않습니다.");
					} else {
						for (Question question : questions) {
							System.out.println("번호: " + question.getNo());
							System.out.println("제목: " + question.getTitle());
							System.out.println("질문자아이디: " + question.getUser().getId());
							System.out.println("내용: " + question.getContent());
							System.out.println("조회수: " + question.getViewCount());
							System.out.println("상태: " + question.getStatus());
							System.out.println("타입: " + question.getType());
							System.out.println("등록날짜: " + question.getRegisteredDate());
						}
					}
				} else if (ansMenuNo == 2) {
					System.out.println("[문의글 등록]");
					
					System.out.print("아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					System.out.print("제목을 입력하세요: ");
					String title = KeyboardUtil.nextString();
					System.out.print("내용을 입력하세요: ");
					String content = KeyboardUtil.nextString();
					System.out.print("질문카테고리를 입력하세요: ");
					String type = KeyboardUtil.nextString();
					
				
					Question question = new Question();
					question.setTitle(title);
					question.setContent(content);
					question.setType(type);
					
					boolean ifSuccess = service.문의등록(userId, question);
					
					if(ifSuccess) {
						System.out.println("문의등록이 완료되었습니다.");
					} else {
						System.out.println("아이디가 일치하지 않습니다.");
					}
					
				} else if (ansMenuNo == 3) {
					System.out.println("[문의글 조회]");
					
					System.out.print("질문번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					
					Question question = service.문의글조회(questionNo);
					
					if(question == null) {
						System.out.println("!!! 해당하는 번호의 문의글이 없습니다.");
					} else {
						System.out.println("번호: " + question.getNo());
						System.out.println("제목: " + question.getTitle());
						System.out.println("질문자아이디: " + question.getUser().getId());
						System.out.println("내용: " + question.getContent());
						System.out.println("조회수: " + question.getViewCount());
						System.out.println("상태: " + question.getStatus());
						System.out.println("타입: " + question.getType());
						System.out.println("등록날짜: " + question.getRegisteredDate());
						System.out.println("답변정보: " + question.getAnswer().getContent());
					}
					
					
				} else if (ansMenuNo == 4) {
					System.out.println("[문의글 삭제]");
					
					System.out.print("질문번호를 입력하세요: ");
					int questionNo = KeyboardUtil.nextInt();
					System.out.print("아이디를 입력하세요: ");
					String userId = KeyboardUtil.nextString();
					
					boolean removePosts = service.문의글삭제(questionNo, userId);
					if(removePosts == false) {
						System.out.println("삭제에 실패하였습니다.");
					} else {
						System.out.println("삭제에 성공하였습니다.");
					}
					
				}
				
			} else if (menuNo == 0) {
				KeyboardUtil.close();
				System.out.println("### 프로그램을 종료합니다.");
				break;
			}
			
			System.out.println();
			System.out.println();
			
		}
	}
}
