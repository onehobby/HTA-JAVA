package data.app;

import java.util.Scanner;

import data.service.DataService;

public class DataApp {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		DataService service = new DataService();
		
		while(true) {
			System.out.println("======================================================================");
			System.out.println("1.전체조회  2.지역별조회  3.날짜별조회  4.통계  0.종료");
			System.out.println("======================================================================");
			
			System.out.print("메뉴를 선택하세요: ");
			int menuNo = scanner.nextInt();
			
			if(menuNo == 1) {
				System.out.println("[전체 조회]");
				service.printAllDataCount();
				
			} else if(menuNo == 2) {
				System.out.println("[지역별 조회]");
				System.out.print("조회할 시,도 이름을 입력하세요(2글자): ");
				String sido = scanner.next();
				service.printDataBySido(sido);
				
			} else if(menuNo == 3) {
				System.out.println("[날짜별 조회]");
				System.out.print("조회할 날짜를 입력하세요(MM-dd): ");
				String day = scanner.next();
				service.printDataByDay(day);
				
			} else if(menuNo == 4) {
				System.out.println("======================================================================");
				System.out.println("[통계보기]");
				System.out.println("1.지역별  2.월별  3.요일별  4.위반내용별  5.요약");
				System.out.println("======================================================================");
				
				System.out.println("통계 메뉴를 선택하세요: ");
				int statMenuNo = scanner.nextInt();
				
				if(statMenuNo == 1) {
					System.out.println("[지역별 통계]");
					System.out.print("조회할 시,도 이름을 입력하세요(2글자): ");
					String sido = scanner.next();
					
					service.printDataStatBySido(sido);
					
				} else if(statMenuNo == 2) {
					
				} else if(statMenuNo == 3) {
					
				} else if(statMenuNo == 4) {
					
				} else if(statMenuNo == 5) {
					
				}
				
			} else if(menuNo == 0) {
				
			}
			
		}
		
	}
}
