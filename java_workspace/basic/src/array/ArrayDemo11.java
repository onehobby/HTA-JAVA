package array;

import java.util.Scanner;

public class ArrayDemo11 {

	public static void main(String[] args) {
		
		// 숫자 5개를 입력받아서 배열에 저장한다.
		// 배열의 n번째까지의 합계를 새로운 배열에 저장하고, 새 배열의 값을 전부 출력한다.
		// 예) [3, 5, 11, 7, 4] ---> [3, 8, 19, 26 30]
		Scanner sc = new Scanner(System.in);
		int[] num1 = new int[5];
		int[] num2 = new int[5];
		
		for(int i = 0; i < num1.length; i++) {
			System.out.print("숫자 5개를 입력하시오: ");
			num1[i] = sc.nextInt();
		}
		
		int total = 0;
		int tempTotal = 0;
		
		for(int i = 0; i < num1.length; i++) {
			total += num1[i];
			num2[i] += total;
		}
		for(int i = 0; i < num2.length; i++) {
			System.out.println(num2[i]);	
		}
		
//		int[] src = new int[5];
//		int[] dest = new int[5];
//		
//		Scanner scanner = new Scanner(System.in);
//		
//		for(int i = 0; i<src.length; i++) {
//			System.out.print("숫자를 입력하세요: ");
//			src[i] = scanner.nextInt();
//		}
//		
//		int total = 0;
//		for(int i = 0; i<src.length; i++) {
//			total += src[i];
//			dest[i] = total;
//		}
//		System.out.println("원본배열");
//		for (int i = 0; i < src.length; i++) {
//			System.out.print(src[i] + " ");	
//		}
//		System.out.println();
//		
//		System.out.println("합계배열");
//		for(int i = 0; i < dest.length; i++) {
//			System.out.print(dest[i] + " ");
//		}
	}
}
