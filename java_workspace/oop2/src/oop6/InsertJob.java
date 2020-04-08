package oop6;

public class InsertJob extends AbstractJobTemplate {
	
	@Override // 부모클래스의 추상메소드인 work 메소드를 자식클래스에서 용도에 맞게 재정의
	void work() {
		System.out.println("데이터베이스에 새로운 정보를 추가합니다.");
	}
	
}
