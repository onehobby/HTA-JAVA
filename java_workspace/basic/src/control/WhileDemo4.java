package control;

import java.util.Scanner;

public class WhileDemo4 {
	public static void main(String[] args) {
		// 10000~99999 사이의 임의의 정수를 입력하세요.
		// 예) 입력값 : 12132 ----> 출력값 1+2+1+3+2
		
		Scanner sc = new Scanner(System.in);
		System.out.println("임의의 5자리 숫자를 입력하세요(10000 ~ 99999):");
		int inputN= sc.nextInt();
		
		int sum = 0;
		
		while (inputN !=0) {
				int lastN = inputN%10;
				sum+= lastN;
				
				inputN = inputN/10;
		}
			
			System.out.println(sum);
			
			
		
		

				
		
	}

}
