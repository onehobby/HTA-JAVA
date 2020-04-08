package oop1;

public class PersonDemo2 {
	
	public static void main(String[] args) {
		/*
		 * Person객체를 여러 개 담는 배열을 사용해보자 (같은 데이터타입의 객체를 같은 데이터타입의 집합인 배열로 만들 수 있다.)
		 */
		
//		int[] numbers = new int[3];		  // -> int형 데이터타입 변수 3개 담을 수 있는 배열
//		Person[] people = new Person[3];  // -> Person객체 3개를 담을 수 있는 배열생성, 
										  // Person객체 3개를 담을 수 있는 people변수를 만들었다.
										  // people배열변수의 index값을 통해서 Person클래스를 가지고 생성된 각각의 객체에 접근할 수 있다.
		
		// Person객체 3개 담을 수 있는 배열을 생성해서 people에 대입하기
		Person[] people = new Person[3];
		
		Person p1 = new Person(); 		//p1은 Person객체의 주소값을 가지고 있다
		p1.name = "이순신";
		p1.email = "leesh@naver.com";
		p1.age = 60;
		
		Person p2 = new Person();		//p2는 Person객체의 주소값을 가지고 있다
		p2.name = "류관순";
		p2.email = "ryugs@gmail.com";
		p2.age = 17;
		
		Person p3 = new Person();		//p3은 Person객체의 주소값을 가지고 있다
		p3.name = "강감찬";
		p3.email = "kang@daum.net";
		p3.age = 80;
		
		//생성된 각각의 Person객체의 주소값을 배열에 저장하기
		
		people[0] = p1;
		people[1] = p2;
		people[2] = p3;
   
		// people 배열에 저장된 모든 Person객체의 속성을 출력하기
		for(int i = 0; i < people.length; i++) {
			Person p = people[i];		// people배열에는 Person데이터타입의 객체가 담겨있기때문에 Person데이터타입을 담을 수 있는 변수 p에 담아야한다. 
										// p에는 Person객체의 주소값이 순서대로 대입된다.
			System.out.println(p.name + "\t" + p.email + "\t" + p.age);			
		}										
	
	}

}
