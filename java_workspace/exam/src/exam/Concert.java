package exam;

import java.util.Scanner;

public class Concert {
	
	public String S[];
	public String A[];
	public String B[];
	
	Scanner sc = new Scanner(System.in);

	Concert() {
		S = new String[10];
		A = new String[10];
		B = new String[10];
		
		for(int i=0; i<S.length; i++) {
			S[i] = "___";
			A[i] = "___";
			B[i] = "___";
		}
	}
	
	public static void printSeat(String seat[]) {		
		//좌석한줄출력메소드
		for(int i=0; i<seat.length; i++) {
			System.out.print(" " + seat[i] + " ");
		}
		System.out.println();
	}
	
	public void allPrint() {
		// 모든좌석출력메소드
		System.out.print("S>>");
		printSeat(S);
		System.out.print("A>>");
		printSeat(A);
		System.out.print("B>>");
		printSeat(B);
		System.out.println("조회를 완료하였습니다.");
	}
	
	public void choiceSeat() {
		// 좌석선택메소드
		while(true) {
			System.out.println("좌석구분 S(1), A(2), B(3)");
			int select = sc.nextInt();
			if(select == 1) {
				System.out.print("S :");
				printSeat(S);
				inputSeat(S);
				return;
			} else if(select == 2) {
				System.out.print("A :");
				printSeat(A);
				inputSeat(A);
				return;
			} else if(select == 3) {
				System.out.println("B :");
				printSeat(B);
				inputSeat(B);
				return;
			} else {
				System.out.println("다시 입력해주세요");
			}
				
		}
	}
	
	public void inputSeat(String seat[]) {
		// 좌석에 이름을 넣는 메소드
		System.out.print("이름을 입력해주세요");
		String name = sc.next();
		while(true) {
			System.out.print("번호를 입력해주세요");
			int num = sc.nextInt();
			num--;
			if(seat[num].equals("___")) {
				seat[num] = name;
				break;
			}
			else {
				System.out.println("다른좌석을 선택해주세요");
			}
		}
	}
	
	public void deleteSeat(String seat[]) {
		// 좌석취소 내부처리 메소드
		System.out.print("이름 :");
		String name = sc.next();
		for(int i=0; i<seat.length; i++) {
			if(name.equals(seat[i])) {
				seat[i] = "___";
				break;
			}
		}
	}
	
	public void delete() {
		// 좌석취소메소드
		System.out.println("좌석구분: S(1), A(2), B(3)");
		while(true) {
			int select = sc.nextInt();
			if(select == 1) {
				printSeat(S);
				deleteSeat(S);
				return;
			} else if(select == 2) {
				printSeat(A);
				deleteSeat(A);
				return;
			} else if(select == 3) {
				printSeat(B);
				deleteSeat(B);
				return;
			} else {
				System.out.println("다시 입력해주세요");
			}
		}
	}
}