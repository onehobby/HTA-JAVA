package control;

import java.util.Scanner;

public class lottoDemo2 {
	public static void main(String[] args) {
		/*
		 *  금액을 입력받는다.
		 *  금액은 1000원 단위의 값만 입력받는다.
		 *  로또번호를 입력된 금액만큼 발행한다.
		 *  1000원당 1세트씩 발행한다.
		 */
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("로또 번호 발매기");
		System.out.print("구매할 금액을 천원단위로 입력해주세요");
		int pay=sc.nextInt();
		
		int setCount = pay/1000;
		for (int i=1; i<=6*setCount; i++) {
			int number = (int)(Math.random()*45+1);
			System.out.print(number + " ");
			if (i%6==0) {
				System.out.println();
			}
		}
		
		
				
	}

}
