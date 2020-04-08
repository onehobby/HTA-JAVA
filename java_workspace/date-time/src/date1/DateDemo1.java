package date1;

import java.util.Date;

public class DateDemo1 {

	public static void main(String[] args) {

		// 시스템의 현재 시간정보를 포함하는 Date객체가 생성되어
		// 참조변수 now에 담긴다.
		Date now = new Date();
		System.out.println(now.toString());

		// 1970-01-01 00:00:00 (컴퓨터의 기준 시간) 이후로부터
		// Date객체가 가리키는 시간까지의 밀리초(milliseconds)값
		// unixTime이라고 부른다
		long unixTime = now.getTime();
		System.out.println(unixTime);

		unixTime = System.currentTimeMillis();
		System.out.println(unixTime);

	}
}
