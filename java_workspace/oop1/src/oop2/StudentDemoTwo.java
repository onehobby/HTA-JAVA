package oop2;

import java.awt.DisplayMode;
import java.util.Scanner;

public class StudentDemoTwo {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
				Student[] students = new Student[100];
		int savePosition = 0;
		
		while(true) {
			System.out.println();
			System.out.println("[학생정보 관리 프로그램]");
			System.out.println("-----------------------------");
			System.out.println("1.조회	2.검색	3.입력	0.종료");
			System.out.println("-----------------------------");
			
			System.out.println("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[학생정보 조회]");
				System.out.println("이름	반	번호	국어	영어	수학	총점	평균");
				System.out.println("===============================");
				
				for (int i = 0; i < savePosition; i++) {
					students[i].displayStudentInfoForRow();
				}
				
				System.out.println("===============================");
			} else if (menuNo == 2) {
				System.out.println("[학생정보 검색]");
				
				System.out.print("검색할 이름을 입력하세요: ");
				String searchName = scanner.next();
				
				boolean isFound = false;
				for(int i = 0; i < savePosition; i++) {
					if(searchName.equals(students[i].name)) {
						students[i].displayStudentInfo();
						isFound = true;
					}
				}
				
				if (!isFound) {
					System.out.println("입력한 이름과 일치하는 정보를 찾을 수 없습니다.");
				}
				
				
			} else if (menuNo == 3) {
				System.out.println("[학생정보 입력]");
				System.out.println("이름을 입력하세요");
				String name = scanner.next();
				System.out.println("반을 입력하세요");
				int ban = scanner.nextInt();
				System.out.println("번호를 입력하세요");
				int no = scanner.nextInt();
				System.out.println("국어점수를 입력하세요");
				int kor = scanner.nextInt();
				System.out.println("수학점수를 입력하세요");
				int math = scanner.nextInt();
				System.out.println("영어점수 입력하세요");
				int eng = scanner.nextInt();
				
				Student student = new Student();
				student.name = name;
				student.ban = ban;
				student.no = no;
				student.kor = kor;
				student.eng = eng;
				student.math = math;
				
				students[savePosition] = student;
				savePosition++;
				
			} else if (menuNo == 0) {
				System.out.println("[프로그램 종료]");
				break;
			}
		}
		scanner.close();
	}

}
