package list;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo2 {

	public static void main(String[] args) {
		
		// 오류 : 타입파라미터<E>에는 클래스명이 정의되어야 한다.
		//		int는 자바의 키워드, 클래스명이 아니다.
		// ArrayList<int> numbers - new ArrayList<int>();
		// ArrayList<long> numbers - new ArrayList<long>();
		// ArrayList<double> numbers - new ArrayList<double>();
		
		// 기본자료형에 대응되는  Wrapper 클래스를 타입파라미터로 지정한다
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<Long> currencies = new ArrayList<Long>();
		ArrayList<Double> scores = new ArrayList<Double>();
		
		
//		* Auto-boxing(오토박싱) > Wrapper클래스에 한해서 적용
		// 기본자료형값을 변수에 대입하거나, 매개변수로 전달할 때
		// 변수의 타입이 int이면 정수값이 전달된다.
		// 변수의 타입이 Integer 혹은 Object라면 정수값을 담은 Integer객체가 자동으로
		// 생성된다.
		
//		void m1(int no) { ... }			m1(10);
//		void m2(Integer no) { ... } 	m2(10);	>> m2(new Integer(10));
		
//		double d1 = 3.14;
//		double d2 = 3.14;		// Double d2 = new Double(3.14);
		
//		ArrayList<Long> currency = new ArrayList<Long>();
//		currency.add(10000000000L);		// currency.add(new Long(10000000000L));
		
		numbers.add(new Integer(10));
		// auto boxing
		numbers.add(10);	// 실제로 실행되는 코드 : numbers.add(new Integer(10)); 
		
		currencies.add(new Long(10000000000L));
		// auto boxing
		currencies.add(10000000000L);	// 실제로 실행되는 코드 : currencies.add(new Long(10000000000L));
		
		scores.add(new Double(4.2));
		// auto boxing
		scores.add(4.2);	// 실제로 실행되는 코드 : scores.add(new Double(4.2));
		
//		* Auto-Unboxing(오토 언박싱) > Wrapper클래스에 한해서 적용
		// Wrapper객체를 변수에 대입하거나, 매개변수로 전달할 때
		// 변수의 타입이 기본자료형타입이면 자동으로 Wrapper객체에 저장된 기본자료형값만 대입된다.
		
		Double x = new Double(3.14);
		double y = x;				// double y = x.doubleValue();
		
		Integer x1 = new Integer(100);
		int y1 = x1;					// int y1 = x1.intValue();
		
		Long x2 = new Long(10000000000L);
		Long y2 = x2;					// int y2 = x2.longValue();
		
		
		ArrayList<Integer> scores1 = new ArrayList<Integer>();
		scores1.add(new Integer(100));
		scores1.add(98);
		scores1.add(68);
		
//		for (Integer s : scores1) {				for (int s1 : scores1) {
//			
//		}										}			
		
		for (Integer num : numbers) {
			System.out.println(num);
		}
		
		for (int num : numbers) {	// 반복될 때 마다 Integer 객체가 꺼내진다. --> 언박싱되어서 숫자만 num에 대입
			System.out.println(num);
		}
		
		Iterator<Long> itr = currencies.iterator();
		while(itr.hasNext()) {
			Long curr = itr.next();
			System.out.println(curr);
		}
		
		itr = currencies.iterator();
		while(itr.hasNext()) {
			long curr = itr.next();	// itr.next() --> Long객체 반환 --> 언박싱되어서 숫자만 curr에 대입
			System.out.println(curr);
		}
		
	}
}
