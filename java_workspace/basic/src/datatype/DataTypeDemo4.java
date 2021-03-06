package datatype;

public class DataTypeDemo4 {
	public static void main(String[] args) {
		
		// 리터럴 : 코드에 직접 값을 표시하는 것 
		// 값을 종류에 따라서 표기법이 정해져 있다.
		
		// 논리값 리터럴	true	false
		// 정수 리터럴	1	10	0	-3	1_000_000 10000000000000L	2000000000000000l
		// 실수 리터럴	3.14	3.0	3.	-5.04 3.14F	3.14f	
		// 문자 리터럴	'A' '1' '\n'-줄바꿈 '\b'-백스페이스 '\t'-탭  '\u0042'-문자 B를 나타냄(유니코드)
		// 문자열 리터럴	"안녕하세요"	"서울특별시 종로구 \n디아망빌딩 401호\nL2강의실"
		
		// 자바의 기본자료형
		// 논리값 타입		boolean
		// 정수 타입		byte	short	int		long
		// 실수 타입		float	double
		// 문자 타입		char
		
		//문자열 전용 String - 기본자료형 아님

		
		// 각 리터럴별 변수 사용하기
		// 논리값 다루기		true 와 false는 참/거짓 논리값을 나타내는 자바의 예약어다. 
		boolean soldOut = true;
		boolean passed = false;
		System.out.println(soldOut);
		System.out.println(passed);
		System.out.println("true"); //논리값이 아니다. 문자열임
		
		// 정수값 다루기
		byte num1 =100;
		short num2 = 30000;
		int num3 = 1000000;
		long num4 = 1000000;
	//	byte num5 = 232;			// byte값의 범위를 초과하기 때문에 오류
	//	int num6 = 30000000000;		// int값의 범위를 초과하기 때문에 오류
		long num7 = 30000000000L;	// int 값의 범위를 초과하는 값을 long에 대입할 때 리터럴에 L을 입력
		int num8 = 012;				// 8진수 12가 저장된다  1*8^1 + 2*8^0
		int num9 = 0x12;			// 16진수 12가 저장된다. 1*16^1 + 16^0
		int num10 = 0xA4;			   // 10*16^1 + 4*16^0
		
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num7);
		System.out.println(num8);
		System.out.println(num9);
		System.out.println(num10);
		
		
		
		// 실수값 다루기
		float value1 = 3.14f;		// 실수 리터럴은 double 타입으로 잘 사용하지 않음 float타입이로 판단하도록 f를 붙인다.
		double value2 = 3.14;		
		System.out.println(value1);
		System.out.println(value2);
		
		
		// 문자 다루기
		char ch1 = 'A';				// 문자 A를 대입한다.
		char ch2 = '\u0041';		// 유니코드표에서 0041코드에 해당하는 문자를 대입한다. 잘 사용하지않음
		char ch3 = 65;				// 아스키코드표에서 65번에 해당하는 문자를 대입한다. 잘 사용하지 않음 
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		
		// 문자열 다루기
		// 문자열은 0개이상의 문자들이 나열되어 있는 것 
		String str1 = "A";
		String str2 = "안녕하세요";
		String str3 = "서울특별시 종로구\n봉익동 디아망빌딩\n4층 L2강의실";
		System.out.println(str1);	
		System.out.println(str2);	
		System.out.println(str3);	
		
		
		
	}

}

