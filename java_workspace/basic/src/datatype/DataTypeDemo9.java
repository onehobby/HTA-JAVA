package datatype;

public class DataTypeDemo9 {
	public static void main(String[] args) {
		
		/*홍길동 고객은
		 * 	3만원짜리 셔츠 3장
		 * 	10만원짜리 청바지 2장
		 * 	50만원짜리 구두 1켤레를 구매했다.
		 * 홍길동 고객의 총 구매금액을 출력하기
		 * 해당 사이트에서는 구매금액의 3%를 포인트로 적립시킨다. (포인트는 정수값만 사용한다.)
		 * 홍길동 고객이 이번 주문에서 적립한 포인트를 출력하기
		 */
		
		int shirtPrice = 30000;
		int jeanPrice = 100000;
		int shoes = 500000;
		int total = (shirtPrice*3 + jeanPrice*2 + shoes*1);
		
		System.out.println("총 구매가격 :" + total);
		
		int point = (int)(total*0.03);
		System.out.println("홍길동 고객님의 적립 포인트 :" + point);
		
		
		
	}

}
