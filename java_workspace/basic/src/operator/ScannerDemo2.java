package operator;

import java.util.Scanner;

public class ScannerDemo2 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * 학생이름 ,국어점, 영어점수, 수학점수를 입력받는다.
		 * 출력내용
		 *   학생이름, 국어점수 ,영어점수 ,수학점수 총점, 평균,합격여부,장학금지급여부
		 *   *합격여부는 평균이 60점 이상은 경우만 "예"로 출력 그 외는 "아니오" 출력
		 *   *장학금지급여부는 평균이 96점 이상인 겨우만 "예"로 출력, 그 외는 "아니오" 출력
		 */
		
		System.out.print("학생 이름을 입력해주세요 ");
		String name = sc.next();
		
		System.out.print("국어점수를 입력해주세요 ");
		int kor = sc.nextInt();
		
		System.out.print("영어점수를 입력해주세요 ");
		int eng = sc.nextInt();
		
		System.out.print("수학점수를 입력해주세요 ");
		int math = sc.nextInt();
		
		int total = kor + eng + math;
		String pass = total >= 60 ? "예" : "아니오";
		String scholarship = total/3 >= 96 ? "예" : "아니오";
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학금지급여부");
		System.out.println(name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+total+"\t"+(total/3)+"\t"+pass+"\t"+scholarship);
		
//		System.out.println();
//		System.out.println("학생이름: " + name);
//		System.out.println("국어점수: " + kor);
//		System.out.println("영어점수: " + eng);
//		System.out.println("수학점수: " + math);
//		System.out.println("총    점: " + total);
//		System.out.println("평    균: " + total/3);
//		System.out.println("합격여부: " + pass);
//		System.out.println("장학금 지급여부:" + scholarship);
	
		
		
	}
	
	
	

}
