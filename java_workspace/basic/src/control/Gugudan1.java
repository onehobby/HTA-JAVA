package control;

import java.util.Scanner;

public class Gugudan1 {
	public static void main(String[] args) {
		
		// 숫자를 입력 받아서 해당 숫자에 대한 구구단을 출력하기
		// 
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("출력할 구구단의 단을 입력하세요: ");
		int dan = sc.nextInt();
		
	
		for(int i=1; i<=9; i++) {
			System.out.println(dan + " * " + i + " = " + dan*i);
		}
		
		
		
		
	}
}
