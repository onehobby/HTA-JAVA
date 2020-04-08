package array;
import java.util.Scanner;

public class ArrayDemo15 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] secret = new int[3];
		int[] input = new int[3];
		
		int strike = 0;
		int ball = 0;
		int count = 0;
		
		for(int i = 0; i < 3; i++) {
			secret[i] = (int) (Math.random()*9 + 1);
		}
		
		while(true) {
			ball = 0;
			strike = 0;
			count++;
			if(count >= 11) {
				System.out.println("횟수를 초과하여 실패하였습니다.");
				break;
			}
			System.out.print("숫자 3개를 입력해주세요: ");
			for(int i = 0; i < input.length; i++) {	
				input[i] = scanner.nextInt();
			}	
			for(int i = 0; i < input.length; i++) {
				if(input[i] == secret[i]) {
					strike++;
				} else {
					for(int j = 0; j < input.length; j++) {
						if(input[i] == secret[j]) {
							ball++;
						} 
					}
				}
			}
			if(strike == 3) {
				System.out.println("축하드립니다"+count+"번 만에성공했습니다");
				break;
			} else if(strike !=3) {
				System.out.println("ball: " + ball);
				System.out.println("strike: " + strike);
				System.out.println("count: " + count);
			}
		}
	} 
}
