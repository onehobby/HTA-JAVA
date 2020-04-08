package oop1;

import java.util.Scanner;

public class OrderDemo1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		Order[] orders = new Order[100];			// 데이터타입이 Order인 객체 100개를 담을 수 있는 배열 생성
		
		while(true) {
			int savePosition = -1;
			System.out.println();
			System.out.println("============================");
			System.out.println("1.조회	2.검색	3.입력	4.종료");
			System.out.println("============================");
			
			System.out.println("번호를 입력하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[고객정보 조회]");
				
				System.out.println("고객명	고객등급	총구매금액	  적립포인트 	사은품");
				System.out.println("============================================");
				
				for (int i = 0; i < savePosition; i++) {
					Order order = orders[i];
					System.out.print(order.name + "\t");
					System.out.print(order.grade + "\t");
					System.out.print(order.price + "\t");
					System.out.print(order.point + "\t");
					System.out.println(order.gift);
				}
			} else if (menuNo == 2) {
				System.out.println("[고객 주문내용 검색]");
				
				System.out.print("검색조건을 입력하세요(N:이름, G:사은품)");
				String option = scanner.next();
				System.out.println("검색내용을 입력하세요");
				String text = scanner.next();
				
				System.out.println("고객명\t고객등급\t총구매금액\t적립포인트\t사은품");
				System.out.println("=====================================================");
				for (int i = 0; i<savePosition; i++) {
					Order order = orders[i];
					
					boolean isFound = false;
					if(option.equals("N") && text.equals(order.name)) {
						isFound = true;
					} else if (option.equals("G") && text.equals(order.gift)) {
						isFound = true;
					}
					if (isFound) {
						System.out.println(order.name + "\t");
						System.out.println(order.grade + "\t");
						System.out.println(order.price + "\t");
						System.out.println(order.point + "\t");
						System.out.println(order.gift + "\t");
					}
				}
			} else if (menuNo == 3) {
				System.out.println("[고객정보 입력]");
				
				System.out.println("고객명을 입력하세요: ");
				String name = scanner.next();
				System.out.println("고객등급(프리미어, 에이스, 베스트, 클래식 중 하나)을 입력하세요: ");
				String grade = scanner.next();
				System.out.println("총 구매금액을 입력하세요: ");
				int price = scanner.nextInt();
				
				int point = 0;
				if (grade.equals("클래식")) {
					point = (int) (price * 0.05);
				} else if(grade.equals("에이스")) {
					point = (int) (price * 0.03); 
				} else if(grade.equals("베스트")) {
					point = (int) (price * 0.02); 
				} else if(grade.equals("클래식")) {
					point = (int) (price * 0.01);
				}
				String gift = "";
				if (price >= 5000000) {
					gift = "숙박권";
				} else if (price >= 1000000) {
					gift = "상품권";
				} else if (price >= 500000) {
					gift = "할인권";
				} else {
					gift = "주차권";
				}
				
				Order order = new Order();
				order.name = name;
				order.grade = grade;
				order.price = price;
				order.point = point;
				order.gift = gift;
				
				orders[savePosition] = order;
				savePosition++;
				
			} else if (menuNo == 4) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		scanner.close();
	}
}
