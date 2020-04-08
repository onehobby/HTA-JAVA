package date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DataDemo5 {

	public static void main(String[] args) throws ParseException {
		// 기념일 계산기
		Date today = new Date();
		final long ONE_DATE_TIME = 60*60*24*1000;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy.M.d");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("----------------------------------");
		System.out.println("1.몇일째 날?  2.그날은 몇일일까?");
		System.out.println("----------------------------------");
		
		System.out.print("메뉴를 선택하세요: ");
		int menuNo = scanner.nextInt();
		
		if(menuNo == 1) {
			System.out.print("기념일을 입력하세요(입력예: 2020.3.21) : ");
			String text = scanner.next();
			Date memorialDay = df.parse(text);
			
			long todayTime = today.getTime();
			long memorialDayTime = memorialDay.getTime();
			
			long dayCount = (todayTime - memorialDayTime) / ONE_DATE_TIME;
			System.out.println("오늘은" + dayCount + "일째 날입니다.");
			
		} else if(menuNo == 2) {
			System.out.println("날짜를 입력하세요(입력예: 100) : ");
			int dayCount = scanner.nextInt();
			
			long todayTime = today.getTime();
			long dayTime = ONE_DATE_TIME * dayCount;
			
			Date futureDay = new Date(todayTime + dayTime);
			
			String text = df.format(futureDay);
			System.out.println("오늘부터 ["+dayCount+"]일째는 " + text + "입니다."); 
			
		} else if(menuNo == 3) {
			// 지정일부터 n일(ex 100일)째 되는날을 나타내주는 기능
			System.out.println("시작일을 입력하세요:(입력예: 2020.3.21) :");
			String text = scanner.next();
			Date memorialDay = df.parse(text);
			
			System.out.println("몇일째인지 궁금한 날을 입력하세요: (입력예: 100):");
			int dayCount = scanner.nextInt();
			
			long memorialDayTime = memorialDay.getTime();
			long dayTime = ONE_DATE_TIME * dayCount;
			
			Date futureDay = new Date(memorialDayTime + dayTime);
			String textFuture = df.format(futureDay);
			
			System.out.println(text + "부터" + dayCount + "일째는" + textFuture + "입니다");
			
			
		}
			
		
	}
}
