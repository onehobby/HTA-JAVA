package array;

import java.util.Scanner;

public class ArrayDemo8 {

	public static void main(String[] args) {
		
		/*
		 * 5개의 정수를 입력받아서 그 중에서 가장 큰 값을 출력하시오
		 */
		
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[5];
		for (int i = 0; i < numbers.length; i++) {
			System.out.print("5개의 두자릿수 정수를 입력하시오: ");
			numbers[i] = sc.nextInt();
		}
		
		int max = 0; 
		for(int num : numbers) {
			if(max < num) {
				max = num;
			}
		}
		
		System.out.println("최댓값: " + max);
	}
}
