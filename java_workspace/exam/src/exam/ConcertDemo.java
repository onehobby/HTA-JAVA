package exam;
import java.util.Scanner;

public class ConcertDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("콘서트홀 예약시스템입니다");
		Concert concert = new Concert();
		
		while(true) {
			System.out.println("1.예약 2.조회 3.취소 4.끝내기");
			int select = sc.nextInt();
			if(select == 1) {
				concert.choiceSeat();
			} else if(select == 2) {
				concert.allPrint();
			} else if(select == 3) {
				concert.delete();
			} else if(select == 4) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("다시입력해주세요");
			}
		} 
	}
}