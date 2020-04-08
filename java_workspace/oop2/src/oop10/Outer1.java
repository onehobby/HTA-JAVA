package oop10;

public class Outer1 {
	
	private int x;
	static int y;
	
	void m1() {
		Inner1 i = new Inner1();	// 외부 클래스의 멤버 메소드에서 내부클래스 사용가능
	}
	static void m2() {
//		Inner1 i = new Inner1();	// 외부 클래스의 클래스메소드에서 내부클래스 사용불가능	
	}
	
	// 인스턴스 내부클래스 - 인스턴스 내부클래스는 외부클래스와 내부클래스의 모든멤버에 접근할 수 있다.
	class Inner1 {
		int a;
//		static int b;	// 인스턴스 내부클래스에서는 클래스변수를 선언할 수 없음

		void m3() {}
//		static void m4() {}	// 인스턴스 내부클래스에서는 클래스 메소드 선언할 수 없음
		
		void m5() {
			System.out.println(x);	// 외부클래스의 멤버변수
			System.out.println(y);	// 외부클래스의 클래스변수
			m1();					// 외부 클래스의 멤버 메소드
			Outer1.m2();			// 외부 클래스의 클래스 메소드
			System.out.println(a);	// 자신의 멤버변수
			m3();					// 자신의 멤버메소드
		}
		
	}
	
	

}
