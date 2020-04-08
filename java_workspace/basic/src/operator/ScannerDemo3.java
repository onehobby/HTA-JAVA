package operator;

import java.util.Scanner;

public class ScannerDemo3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/* 고객명, 상품명, 가격, 구매수량, 사용포인트를 입력받는다.
		 *  출력내용
		 *     고객명, 상품명, 가격, 구매수량, 구매가격, 사용포인트, 결제금액, 적립포인트
		 *     결재금액은 구매가격에서 포인트 사용량을 제외한 금액이다.
		 *     적립포인트는 실결재금액의 3%
		 */
		
		System.out.print("고객명을 입력해주세요");
		String name = sc.next();
		
		System.out.print("상품명을 입력해주세요");
		String product = sc.next();
		
		System.out.print("가격을 입력해주세요");
		int price = sc.nextInt();
		
		System.out.print("구매수량을 입력해주세요");
		int amount = sc.nextInt();
		
		System.out.print("사용할 포인트를 입력해주세요");
		int usedPoint = sc.nextInt();
		
		int totalPrice = price*amount;
		int paytotal = totalPrice - usedPoint;
		int point = (int) (paytotal * 0.03);
		
		
		
		System.out.println();
		System.out.println("----- 결제내역 -----");
		System.out.println("고객명: " + name);
		System.out.println("상품명: " + product);
		System.out.println("가  격: " + price);
		System.out.println("구매수량: " + amount);
		System.out.println("총구매금액: " + totalPrice);
		System.out.println("총결재금액: " + paytotal);
		System.out.println("적립포인트: " + point);
		
		
		
		
		
	}

}
