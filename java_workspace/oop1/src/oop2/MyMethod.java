package oop2;

public class MyMethod {

	// 인스턴스 변수 (멤버변수)
	String name;

	
	
	// 클래스 변수 (정적변수)
	static final double PI = 3.14;
	
	// 인스턴스 메소드 (멤버메소드)
	// 인스턴스변수, 클래스변수 모두 사용가능
	void memberMethod() {
		System.out.println("인스턴스변수 사용: " + name);
		System.out.println("클래스변수 사용: " + MyMethod.PI);
	}
	
	// 인스턴스 메소드
	// 인스턴스 메소드, 클래스 메소드 모두 사용가능
	void memberMethod2() {
		memberMethod();
		MyMethod.staticMethod();
	}
	
	
	// 클래스 메소드 (정적메소드)
	// 클래스변수 접근가능, 인스턴스변수에 접근불가
	static void staticMethod() {
//		System.out.println("인스턴스변수 사용: " + name); 		// 오류
		System.out.println("클래스변수 사용: " + MyMethod.PI);
	}
	
	//클래스 메소드 (정적메소드)
	// 클래스메소드 접근가능, 인스턴스메소드 접근불가
	static void staticMethod2() {
//		memberMethod();										// 오류
		MyMethod.staticMethod();
	}
	
}
