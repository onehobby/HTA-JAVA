package control;

import java.util.Scanner;

public class IfDemo3 {
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
		/* if ~ else if ~ else if ~ else 문
		 * 3개 이상의 경우의 수를 처리해야 할 때 사용되는 조건문이다.
		 * if(조건식1) {
		 * 		조건식1이 true로 판전될 때 실행된다. 이후 문장의 실행되지 않는다.
		 * } else if (조건식2) {
		 *		조건식2가 true로 판정될 때 실행된다. 이후 문장은 실행되지 않는다. 
		 * } else if (조건식3) {
		 * 		조건식3이 true로 판정될 때 실행된다. 이후 문장은 실행되지 않는다. 
		 * } else {
		 * 		조건식1, 조건식2, 조건식3이 모두 거짓으로 판정될 때 실행된다.
		 * }
		 */
		
		/*
		 * 구매금액의 500만원 이상인 경우 10만원 상품권 지급
		 * 		  100만원 이상인 경우 1만원 상품권 지금
		 * 		  50만원 이상인 경우 커피쿠폰 지급
		 * 		   그 외는 주차할인권 지급
		 */
		
		System.out.print("구매금액을 입력해주세요");
		int pay = sc.nextInt();
		
		if(pay>=5000000) {
			
			System.out.println("10만원 상품권");
		} else if(pay>=1000000) {
			
			System.out.println("1만원 상품권");
		} else if(pay>=500000) {
			
			System.out.println("커피쿠폰");
		} else  {
			
			System.out.println("주차할인권");
			
		}
	}
}
