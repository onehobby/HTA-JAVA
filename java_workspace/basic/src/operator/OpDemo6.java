package operator;

public class OpDemo6 {

	public static void main(String[] args) {
		// 비교 연산자(이항 연산자)
		// > < >= <= == !=
		// 비교 연산자 조건문과 반복문의 조건식으로 사용된다.
		// 비교 연산자의 연산 결과는 항상 true/false 중 하나다.
		// == 연산자
		//		기본자료형일 때는 변수에 저장된 값을 비교한다.
		//		참조자료혐일 때눈 변수에 저장된 주소값을 비교한다.
		//		*참조 자료형일 때 == 연산자는 쓸모없음. *기본 자료형일 때만 사용
		int num1 = 20;   //기본자료형
		int num2 = 30;   //기본자료형
		
		boolean result = num1 > num2;
		System.out.println(result);
		
		boolean result2 = num1 == num2;	     // 연산자의 우선순위에 대한 가독성이 좋지 않다.
		boolean result3 = (num1 != num2);    // 연산자의 우선순위에 대한 가독성이 좋다.
		System.out.println("두 수가 동일한가? " + result2);
		System.out.println("두 수가 동일하지 않은가? " + result3);
		
		
		
	}

}
