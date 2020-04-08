package control;

import java.util.Scanner;

public class WhileDemo3 {
	public static void main(String[] args) {
		// 1~100까지 임의의 정수를 하나 생성한다.
		// 사용자가 입력한 숫자와 임의의 정수를  비교해서 up/down을 표시한다.
		// 사용자가 입력한 숫자와 정수가
		// 몇번만에 맞췄는지 화면에 표시한다.
		
		
		Scanner sc = new Scanner(System.in);
		//1 ~ 100범위의 임의의 정수를 생성해서 sNum에 저장한다.
		int sNum=(int) (Math.random()*100+1);
		// 사용자가 정답을 맞추기 위해서 숫자를 입력한 횟수 
		int inputCount =0;
		
		while (true) {
			System.out.print("숫자를 입력하세요");
			int answer =sc.nextInt();
			inputCount++;
			
			if(sNum == answer) {
				System.out.println("정답입니다.");
				break;
			}
			else if(sNum>answer) {
				System.out.println(answer + "보다 큽니다.");
				
			}
			else if(sNum<answer) {
				System.out.println(answer + "보다 작습니다.");
				
			}
			
			//answer과 sNum를 비교해서 일치하면 반복문 탈출
			//							그렇지 않으면 두수를 비교해서 up/down을 출력하고
			//							숫자 입력한 횟수도 1증가 시킨다.
		}
		System.out.println("정답:" + sNum + "입력횟수: " + inputCount);
		
	}

}
