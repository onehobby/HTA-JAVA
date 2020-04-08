package array;

public class ArrayDemo1 {

	public static void main(String[] args) {
		/*
		 * 배열
		 *  - 같은 타입의 값을 여러 개 저장할 수 있는 변수(저장소)의 묶음이다.
		 *  - 배열을 생성시 배열의 크기를 반드시 지정해주어야한다. 그렇지않으면 에러
		 * 배열의 생설
		 *  - 정수 5개를 저장하는 배열 생성해서 참조변수에 담기
		 *  	int[] numbers = new int[5];
		 *  		생성된 배열 => [0, 0, 0, 0, 0]
		 *  	int[] numbers = {10, 40, 20, 70, 40}; // 배열 리터럴
		 *  		생성된 배열 => [10, 40, 20, 70, 40]
		 *  	int[] numbers = new int[]{10,20,30,40,50};
		 *  		생성된 배열 => [10,20,30,40,50]
		 *  
		 *   - 배열을 생설할 때 배열의 길이(크기)만 지정해서 배열을 생성하면
		 *     배열의 각 요소에는 해당 데이터타입의 기본값으로 초기화되어있다.
		 *    * 기본 데이터타입별 기본값
		 *     정수(byte, short, int, long) --> 0
		 *     실수(float, double)		   --> 0.0
		 *     문자(char)					   --> \u0000 (유니코드에서 0번째 문자, 사용할 일이 거의없음)
		 *     논리(boolean)				   --> false
		 *	  * 참조 데이터타입의 기본값
		 *		기본 데이터타입을 제외한 모든 데이터타입의 기본값은 null이다.
		 *		모든 참조타입의 변수에 null값을 대입할 수 있다.(기본데이터타입에는 null값을 대입하지 못한다)
		 *		null값은 참조하는 주소값을 제거하여 더이상 객체가 해당 주소값을 참조하지 못하게 하는 값(me)
		 *		null은 참조변수가 객체를 더이상 참조하지 못하게 하는 값이다.
		 *		null값은 객체가 아무 주소값도 참조하지 않게한다.
		 *		
		 *
		 *		// boolean이나 char형 배열은 만들일이 거의없다.
		 */
		
//		 정수형 배열
		int[] numbers1 = new int[3];//크기는 3, index값은 0,1,2
		System.out.println("0번째 정수: " + numbers1[0]) ;
		System.out.println("0번째 정수: " + numbers1[1]) ;
		System.out.println("0번째 정수: " + numbers1[2]) ;
		
//		실수형 배열
		double[] numbers2 = new double[3];
		System.out.println("0번째 실수: " + numbers2[0]) ;
		System.out.println("0번째 실수: " + numbers2[1]) ;
		System.out.println("0번째 실수: " + numbers2[2]) ;
		
//		String
		String[] words = new String[3];
//		정수형 배열
		int[] scores = {10, 40, 100}; //크기는 3, index값은 0,1,2
		
//		실수형 배열
		double[] rates = {0.05, 0.001, 0.005};
		
//		String형 배열
		String[] names = {"홍길동", "김유신", "강감찬"}; 
		System.out.println("0번째 문자열: " + names[0]) ; // String는 참조형 데이터타입이므로 nemes[0]번째의 값에는
		System.out.println("0번째 문자열: " + names[1]) ; // "홍길동"객체의 주소값이 담겨있다.
		System.out.println("0번째 문자열: " + names[2]) ;
		
		
		
		
		
	}
}
