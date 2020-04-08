package oop3;

public class PhoneDemo {

	public static void main(String[] args) {
		
		// Iphone객체는 Iphone타입의 변수 및 Iphone조상 타입의 변수에 저장할 수 있다.
		Iphone p1 = new Iphone();
		SmartPhone p2 = new Iphone();
		FeaturePhone p3 = new Iphone();
		Phone p4 = new Iphone();
		
		// Iphone 객체는 Galaxy타입의 변수에 담을 수 없다
//		Galaxy p5 = new Iphone();	// 오류,오류,오류,오류,오류,오류,오류,오류,오류,
		
											//클래스			사용가능 참조변수
		p1.userid = "hong";					//Iphone		p1
		p1.password = "11234123";			//Iphone		p1
		p1.applemusic();					//Iphone		p1
		p1.siri();							//Iphone		p1
		
		p1.ip = "192.168.10.21";			//SmartPhone	p1	p2
		p1.email = "zcx52111@naver.com";	//SmartPhone	p1	p2
		p1.email();							//SmartPhone	p1	p2
		p1.internet();						//SmartPhone	p1	p2
		
		p1.pixel = "천만화소";					//FeturePhone	p1	p2	p3
		p1.photo();							//FeturePhone	p1	p2	p3
		
		p1.tel = "01028788343";				//Phone			p1	p2	p3	p4
		p1.call();							//Phone			p1	p2	p3	p4
		p1.receive();						//Phone			p1	p2	p3	p4

	}
}
