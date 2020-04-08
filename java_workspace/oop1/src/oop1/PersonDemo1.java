package oop1;

public class PersonDemo1 {

	public static void main(String[] args) {
		
//		 person 객체 만들기
//		 Person p1 
//				Person 설계도로 생성된 객체의 주소값을 담는 p1변수를 생성함
//		 new Person() : Person설계도로 메모리에 객체를 생성하고, 생성된 객체의 주소값을 반환함.
//				Person설계도로 메모리에 객체를 생성하고, 생성된 객체의 주소값을 반환함
//		 Person p1 = new Person();
//				Person설계도로 메모리에 객체를 생성하고, 생성된 객체의 주소값을
//				Person타입의 변수 p1에 대입한다.
		Person p1 = new Person();
		Person p2 = new Person();			// p1, p2, p3가 바라보고있는 객체는 각각 다르다.
		Person p3 = new Person();
		
//		각각의 생성된 p1, p2, p3 객체를 통해서 Person클래스의 변수 및 메소드에 접근할 수 있다.
		
//		p1이 참조하는 객체의 속성을 변경하기
		p1.name = "김유신";
		p1.tel = "010-2891-1234";
		p1.email = "kimys@naver.com";
		p1.gender = "남자";
		p1.age = 50;

		p2.name = "이순신";
		p2.tel = "010-1234-1234";
		p2.email = "leess@gamil.com";
		p2.gender = "남자";
		p2.age = 48;

		p2.name = "류관순";
		p2.tel = "010-1111-1234";
		p2.email = "ryugs@daum.net";
		p2.gender = "여자";
		p2.age = 17;
		
		
	}
}
