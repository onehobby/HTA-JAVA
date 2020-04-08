package array;

import java.util.Scanner;

public class ArrayDemo13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int savePosition = 0;		// 저장되는 위치를 기억해서 다음저장때 한칸이동하여 저장할 수 있게하는 변수, 배열의 인덱스값으로 이용된다.
									// savaPosition으로 배열에 저장되어있는 값의 갯수를 알 수 있다.
		String[] names = new String[20];
		int[] korArr = new int[20];
		int[] engArr = new int[20];
		int[] mathArr = new int[20];
		
		while(true) {
			System.out.println();
			System.out.println("[성적관리 프로그램]");
			System.out.println("-------------------------------");
			System.out.println("1.조회  2.검색  3.입력  0.종료");
			System.out.println("-------------------------------");
			
			System.out.print("메뉴선택 > ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[성적 조회]");
				System.out.println("순번    이름	국어	영어	수학	총점	평균");
				System.out.println("-------------------------------");
				for (int i = 0; i<savePosition; i++) {
					System.out.print(i+1+"\t");
					System.out.print(names[i]+"\t");
					System.out.print(korArr[i]+"\t");
					System.out.print(engArr[i]+"\t");
					System.out.print(mathArr[i]+"\t");
					int total = korArr[i] + engArr[i] + mathArr[i];
					int avg= total / 3;
					System.out.print(total + "\t");
					System.out.println(avg);
				}
				System.out.println("-------------------------------");
				
			} else if(menuNo == 2) {
				System.out.println("[성적 검색]");
				
				System.out.print("조회할 학생이름을 입력하세요: ");
				String searchName = scanner.next();									// 내가 찾고자하는 값을 초기값으로 설정하면 안됌
				int index = -1;														// 배열의 index는 0부터 시작하기 때문에 index를 0으로 초기화하고 시작하면 안된다
																					// 배열에서 절대 나올 수 없는  -1로 초기값을 두고 시작
				for (int i = 0; i<savePosition; i++) {
					if (searchName.equals(names[i])) {
						index = i;
					}
				}
				
				if (index != -1) {
					System.out.println("[조회결과]");
					System.out.println("---------------------------");
					System.out.println("학생이름:" + names[index]);
					System.out.println("국어점수:" + korArr[index]);
					System.out.println("영어점수:" + engArr[index]);
					System.out.println("수학점수:" + mathArr[index]);
					int total = korArr[index] + engArr[index] + mathArr[index];
					System.out.println("총    점:" + total);
					System.out.println("평    균:" + total / 3);
					System.out.println("---------------------------");
				} else {
					System.out.println("[" + searchName + "]과 일치하는 성적정보가 존재하지 않습니다." );
				}
				
			} else if(menuNo == 3) {
				System.out.println("[성적 입력]");
				
				System.out.println("이름을 입력하세요: ");
				String name = scanner.next();
				System.out.println("국어점수을 입력하세요: ");
				int kor = scanner.nextInt();
				System.out.println("영어점수를 입력하세요: ");
				int eng = scanner.nextInt();
				System.out.println("수학점수를 입력하세요: ");
				int math = scanner.nextInt();
				
				names[savePosition] = name;
				korArr[savePosition] = kor;
				engArr[savePosition] = eng;
				mathArr[savePosition] = math;
				
				savePosition++;
				System.out.println("성적정보가 저장되었습니다!");
				
			} else if(menuNo == 0) {
				break;
			}
		}
		System.out.println("[성적관리 프로그램을]을 종료합니다.");
	}
}
