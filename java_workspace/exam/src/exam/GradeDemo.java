package exam;

import java.util.Scanner;

public class GradeDemo {
	
	public static void main(String[] args) {
		
		Grade grade = new Grade();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수학점수를 입력하세요: ");
		int math = sc.nextInt();
		System.out.print("과학점수를 입력하세요: ");
		int science = sc.nextInt();
		System.out.print("영어점수를 입력하세요: ");
		int english = sc.nextInt();
		
		int avr = grade.avr(math,science,english);
		
		System.out.println("평균은 " + avr);
	
	}

}
