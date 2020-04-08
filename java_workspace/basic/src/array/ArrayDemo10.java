package array;

import java.util.Scanner;

public class ArrayDemo10 {
	public static void main(String[] args) {
	
		/*
		 *  숫자 6개를 입력받아서 인접한 두 수의 차이가 가장 많이 나는 숫자를 각각 출력하기
		 */
		
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[6];
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.print("숫자 6개를 입력하시오");
			numbers[i] = sc.nextInt();
		}
		int prev = 0;
		int next = 0;
		int gap = 0;		
									// 임의의 값을 저장 할 가상의 변수 만들기
		for(int i = 0; i < numbers.length-1; i++) {
			int tempPrev = numbers[i];
			int tempNext = numbers[i+1];
			int tempGap = Math.abs(tempPrev - tempNext); 		// 절대값
			if(tempGap > gap) {
				prev = tempPrev;
				next = tempNext;
				gap = tempGap;
			}
		}
		System.out.println(prev +" "+next+" "+gap);
	}
}
