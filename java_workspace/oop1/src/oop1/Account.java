package oop1;

public class Account {

	// 클래스 변수 - 상수
	static final double RATE_OF_INTEREST = 0.021; // 클래스변수(상수변수)는 대문자, 카멜표기법일때 언더바로 표시,
												  // 모든객체가 공유하는 값은 상수(변하지않는 값)로 선언할 수 있다, 상수일때 클래스변수 선언
	
	
	// 인스턴스(멤버) 변수          -> 객체를 생성해서 그 객체서 값을 지정해 줄 변수
	String owner;		//예금주
	String no;			//계좌번호
	String password;	//비밀번호
	int balance;		//잔액
	int period;			// 예금기간(개월단위)
}
