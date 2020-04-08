package oop2;


/**
 * 여러가지 구구단 출력을 제공하는 클래스다.
 * @author 유세민
 *
 */
public class Gugudan {
	
		/**
		 *  2단 ~ 9단까지 화면에 출력한다.
		 */
		void print99dan() {
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					System.out.println(i + "*" + j + " = " + i*j);
				}
			}
		}
	
		/**
		 * 지정된 단에 해당하는 구구단을 화면에 출력한다.
		 * @param dan 출력할 단의 숫자
		 */
		void print99danByNumber(int dan) {
			print99danByRange(dan, dan);
		}
	
			
		/**
		 * 지정된 시작번호부터 끝번호까지의 구구단을 화면에 출력한다.
		 * @param begin	출력할 시작단의 숫자
		 * @param end 출력할 끝단의 숫자
		 */
		void print99danByRange(int begin, int end) {
			System.out.println("------------ 구구단(" + begin + "단 부터 " + end + "단 까지) -------------");
			for(int i = 2; i < 10; i++) {
				for(int j = begin; j <= end; j++ ) {
					System.out.print(j + " * " + i + " = " + (i * j) + "\t");
				}
				System.out.println();
			}
			
		}
		
}
