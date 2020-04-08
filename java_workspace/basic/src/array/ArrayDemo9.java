package array;

import java.util.Scanner;

public class ArrayDemo9 {

	public static void main(String[] args) {
		/*
		 * 숫자를 10개 입력받아서 그 중에 짝수들의 합계만 구해서 출력하기
		 */
		
		Scanner sc = new Scanner(System.in);
		int[] numbers = new int[10];
		for(int i = 0; i < numbers.length; i++) {
			System.out.print("정수 10개를 입력하시오: ");
			numbers[i] = sc.nextInt();
		}
		
		int sum = 0;
		for (int num : numbers) {
			if (num % 2 == 0) {
				sum += num;
			}
		}
		
		System.out.println(sum);
	}
}
