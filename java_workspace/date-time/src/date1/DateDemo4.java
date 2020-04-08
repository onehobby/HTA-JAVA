package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo4 {

	public static void main(String[] args) throws ParseException {
		/*
		 * 지정된 날짜 형식으로 작성된 문자열을 Date로 변환하기 
		 */
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
		String text = "1992.7.21.";
		Date date = df.parse(text);
		System.out.println(date);
		
		
	}
	
}
