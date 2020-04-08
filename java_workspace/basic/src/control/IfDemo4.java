package control;

import java.util.Scanner;

public class IfDemo4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		/*
		 * 고객의 등급(일반, 로얄, 플래티넘 중 하나)과 총구매금액을 입력 받는다.
		 * 고객의 등급인 플래티넘인 경우 구매금액의 10%를 할인한다.
		 * 고객의 등급인 로얄인 경우 구매금액의 3%를 할인한다.
		 * 고객의 등급인 일반인 경우 구매금액의 1%를 할인한다.
		 * 결제금액은 총구매금액애서 할인된 금액만큼을 차감한 금액이다.
		 * 적립포인트는 결재금액의 3%를 적립한다.
		 * 
		 * 출력내용은
		 * 		총구매금액, 고객등급, 할인된 금액, 결제할 금액, 적된립 포인트
		 */
		
		System.out.print("총구매금액을 입력해주세요");
		int pay = sc.nextInt();
		
		System.out.print("고객등급을 입력해주세요");
		String grade = sc.next();
		
		int discountPrice=0;
		int totalPay=0;
		int depositPoint=0;    //초기화값을 주어야한다. 정수일때는 0 실수일때는 0.0 boolean 일때는 false
		
		
		if(grade.equals("플래티넘")) {
			discountPrice=(int)(pay*0.1);
		} else if(grade.equals("로얄")) {
			discountPrice=(int)(pay*0.03);
		} else if(grade.equals("일반")) {
			discountPrice=(int)(pay*0.01);
		}
		
		totalPay=pay-discountPrice;
		depositPoint=(int)(totalPay*0.03);
		
		System.out.println("총 구매금액: " + pay);
		System.out.println("고 객 등 급: " + grade);
		System.out.println("할인된 금액: " + discountPrice);
		System.out.println("결제할 금액: " + totalPay);
		System.out.println("적립된 포인트: " + depositPoint);
		
		
	}
}
