package oop2;

import java.util.Scanner;

public class StudentDemo {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Student[] students = new Student[100];
		int savePosition = 0;
		
		while(true) {
			
			System.out.println("======================================");
			System.out.println("1. 조회   2. 검색   3. 입력   0. 종료");
			System.out.println("======================================");
			
			int menuNum = scanner.nextInt();
			
			if(menuNum == 1) {
				System.out.println("[학생정보 조회]");
				for(int i=0; i<savePosition; i++) {
					Student student = students[i];
					student.displayStudentInfo();				
				}
				System.out.println();
				
			} else if(menuNum == 2) {
				
				System.out.print("검색할 이름을 입력하세요 : ");
				String name = scanner.next();
				
				for(int i=0; i<savePosition; i++) {
					if(name.equals(students[i].name)) {
						System.out.println("----- 검색결과 -----");
						Student student = students[i];
						student.displayStudentInfo();
						break;
					}
				}
				
			} else if(menuNum == 3) {
				System.out.print("이름을 입력하세요 : ");
				String name = scanner.next();
				System.out.print("반을 입력하세요 : ");
				int classNum = scanner.nextInt();
				System.out.print("번호를 입력하세요 : ");
				int number = scanner.nextInt();
				System.out.print("국어점수를 입력하세요 : ");
				int kor = scanner.nextInt();
				System.out.print("영어점수를 입력하세요 : ");
				int eng = scanner.nextInt();
				System.out.print("수학점수를 입력하세요 : ");
				int math = scanner.nextInt();
				

				Student student = new Student();
				student.name = name;
				student.ban = classNum;
				student.no = number;
				student.kor = kor;
				student.eng = eng;
				student.math = math;
				
				students[savePosition] = student;
				savePosition++;
				
			} else if(menuNum == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		scanner.close();
	}
}
