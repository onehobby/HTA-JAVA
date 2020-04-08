package array;

public class ArrayDemo4 {

	public static void main(String[] args) {
//		 배열의 값 조회 / 출력
//		 Enhanced-for문
//		 - 배열, Collection(set, List)과 같은 값을 여러개 저장하는 저장소에서
//		    각 요소의 값을 하나씩 조회할 때 사용하는 for문이다
//		    반드시 배열, Collection(Set, List)를 대상으로만 사용해야 한다.
//		  
//		  Enhanced-for문 : 배열에 있는 처음부터 끝까지 모든값을 꺼낼때만 사용한다. (배열에 값을 넣을때는 사용하지않음)
		
//	      Enhanced-for문 작성문법
//		  for (배열의타입과 동일한 변수 : 반복의 대상이되는 배열) {
//			수행문;
//		  }		
//		 
//		  Enhanced-for문 작동방법
//		  * 지정된 배열의 처음부터 끝까지 저장된 값을 하나씩 순서대로 가져와서
//			변수에 저장하고 수행문을 실행한다.
//		  * 반복의 대상이 되는 배열의 값을 순서대로 하나씩 꺼내어 배열의타입과 동일한 변수에 넣고 수행문을 실행, 이 과정을 반복한다.
//		
//		  * 배열 : 조회할 값을 가지고 있는 배열
//		  * 타입 : 배열에 저장된 값의 타입
//		  * 변수명 : 배열에 저장된 값이 순서대로 변수에 저장된다. 
		
		
		int[] scores = {60, 70, 80};
		for(int num : scores) { 			// 1. scores배열의 첫번째 값부터 num변수에 담고 수행문을 실행
			System.out.println(num);		// 2. scores배열의 두번째값을 a변수에 담고 수행문을 실행
		}									// 3. scores배열의 세번째값을 a변수에 담고 수행문을 실행, 배열의 갯수만큼 반복
			
		String[] names = {"김유신", "강감찬", "홍길동"};
		
		for(String name : names) {
			System.out.println(name);
		}
	}
}
