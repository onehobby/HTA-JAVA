package datatype;

public class DataTypeDemo8 {
	
	public static void main(String[] args) {
		
		
		// 반지름의 길이가 5, 10, 20인 원들이 있다.
		// 각 원들의 넓이와 원의 둘레길이를 계산해서 출력하기
		// 넓이는 3.14*반지름*반지름 둘레길이는 2*3.14*반지름
		
		int a = 5;
		int b = 10;
		int c = 20;
		
		
		System.out.println("a의 넓이는? " + 3.14*a*a);
		System.out.println("b의 넓이는? " + 3.14*b*b);
		System.out.println("c의 넓이는? " + 3.14*c*c);
		
		System.out.println("a의 둘레 길이는? " + 2*3.14*a);
		System.out.println("b의 둘레 길이는? " + 2*3.14*b);
		System.out.println("c의 둘레 길이는? " + 2*3.14*c);
			
	}
}
