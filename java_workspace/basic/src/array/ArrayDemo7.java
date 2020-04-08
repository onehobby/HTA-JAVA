package array;

import java.util.Scanner;

public class ArrayDemo7 {

	public static void main(String[] args) {
		// 숫자를 5번 입력받아서 입력받은 숫자의 총합을 계산하기
		
		// 키보드 입력받기
		Scanner sc = new Scanner(System.in);
		
		int[] numbers = new int[5];		 // 숫자 5개를 입력받는 배열 생성하기
		
		// 숫자 5번 입력받기
		for (int i=0; i<5; i++) {		// i를 0~4까지 변경하면서 반복하기
			System.out.print("숫자 5개를 입력하세요 : ");
			numbers[i] = sc.nextInt();		//			// 입력받은 숫자를 변수에 저장하기
		}
//		 입력받은 숫자들의 총합 계산하기
		int total = 0;								//	Enhanced-for문
		for (int totals : numbers) { 				// 	numbers배열의 값을 하나씩 순서대로 totals에 담기
				total += totals;					//  numbers배열의 값을 담은 totals를 total에 누적하기
		}
		System.out.println(total);
	}
}
