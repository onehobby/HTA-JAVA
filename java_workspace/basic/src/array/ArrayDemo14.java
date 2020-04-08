package array;

import java.util.Scanner;

public class ArrayDemo14 {
	public static void main(String[] args) {
		/* 야구게임 */
		//1 ~ 9까지의 랜덤 숫자 3개 배열을 생성한다. (secret[])
		// -- while-- 2중for문 사용
		//int strike = 0; int ball = 0;
		//숫자 3개를 입력받고 배열에 담는다. (input[])
		//두 배열에 들어있는 값의 숫자와 위치가 모두 일치하면 Strike
		//숫자만 일치하면 Ball
		//Strike = 3, Ball = 0이면 while문 탈출
		//10번 안에 못맞히면 실패(탈출)
		// ----------
		
		Scanner scanner = new Scanner(System.in);
		
		int[] secret = new int[3];
		int[] input = new int[3];
		int strike = 0;
		int ball = 0;
		int count = 0;
		
		for(int i=0; i<3; i++) {
			secret[i] = (int) (Math.random()*9+1);
		}
		
		while(true) {	
			for(int i=0; i<3; i++) {
				System.out.print("숫자를 입력해주세요 : ");
				input[i] = scanner.nextInt();
			}
			
			for(int i=0; i<3; i++) {
				if(secret[i] == input[i]) {
					strike++;
				} 
					for(int j=0; j<3; j++) {
						if(secret[i] == input[j]) {
							ball++;
						}
					}	
				}
			count++;
			
			
			if(strike == 3) {
				System.out.println("\n\n====== " + count + "번 만에 성공하셨습니다!" + " ======");
				System.out.print("정답 : [ ");
				for(int i=0; i<secret.length; i++) {
					System.out.print(secret[i] + " ");
				}
				System.out.println("] ");
				
				break;
				
			} else if(count > 10) {
				System.out.println("\n\n====== 시도 횟수 10회 초과로 실패하셨습니다. ======");
				System.out.print("정답 : [ ");
				for(int i=0; i<secret.length; i++) {
					System.out.print(secret[i] + " ");
				}
				System.out.println("] ");
				
				break;
				
			} else {
				System.out.println("-------------------------");
				System.out.println(strike + "S\t" + ball +"B");
				System.out.println("시도 횟수 : " + count);
				System.out.println("-------------------------\n");
				strike = 0;
				ball = 0;
			}		
		}
	}
}