package oop6;

public abstract class AbstractJobTemplate {


	String host;
	int port;
	String userid;
	String password;
	
	void setup() {					// 연결하기 (각 자식클래스마다 공통된 기능을 정의)
		System.out.println("### 전처리 작업 시작 ###");
		System.out.println("데이터베이스 서버에 연결을 요청함.");
		System.out.println("데이터베이스와 연결이 완료됨.");
		System.out.println("### 전처리 작업 완료 ###");
	}
	
	// 자손 클래스에 실제 구현을 위임하기 위해서 메소드 설계(정의,선언)함
	abstract void work();			// 추상메소드, 자식클래스마다 수행 할 작업이 다르므로 부모클래스에서 추상메소드로 선언부만작성
	
	
	void destroy() {				// 연결끊기 (각 자식클래스마다 공통된 기능을 정의)
		System.out.println("### 후처리 작업 시작 ###");
		System.out.println("데이터베이스 서버에 연결해제를 요청함.");
		System.out.println("데이터베이스와 연결이 해제됨.");
		System.out.println("### 후처리 작업 완료 ###");
		
	}
	
	// 작업을 처리하기위해서 순서에 맞게 메소드들을 실행하는 메소드
	void run() {					
		setup();
		work();
		destroy();
	}
}


