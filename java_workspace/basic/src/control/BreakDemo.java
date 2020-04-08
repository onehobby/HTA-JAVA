package control;

import java.util.Scanner;

public class BreakDemo {
	public static void main(String[] args) {
		// berak
		//  반복문을 탈출한다. for문, while문 안에서 사용
		
		// 내가 입력한 자사위 숫자와 동알한 숫자가 나오면 탈출
		Scanner sc = new Scanner(System.in);
		
		for (;;) {
			System.out.println("숫자를 입력하세요(1~6):");
			int myNumber =sc.nextInt();
			
			int randomNumber=(int)(Math.random()*6+1);
			
			System.out.println("["+myNumber+", "+randomNumber+"]");
			if (myNumber==randomNumber) {
				System.out.println("섬을 탈출합니다.");
				break;
			}
			
		}
	}

}
