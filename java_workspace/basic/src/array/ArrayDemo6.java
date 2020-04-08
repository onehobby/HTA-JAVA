package array;

public class ArrayDemo6 {

	public static void main(String[] args) {
		
		int[][] scores = {
				{80,70,80},		// 김유신의 국어, 영어, 수학점수
				{30,40,50},		// 강감찬의 국어, 영어, 수학점수
				{100,86,100}	// 이순신의 국어, 영어, 수학점수
		};
		
		int korTotal = 0;
		int mathTotal = 0;
		int engTotal = 0;
		

		System.out.println("번호" + "\t" + "국어" + "\t" + "수학" + "\t"+ "영어" + "\t" + "총점" + "\t" + "평균");
		System.out.println("===========================================");
		
		for (int i = 0; i < scores.length; i++) { 				//scores.length == > 행의길이
			System.out.print(i+1+"\t");							// 번호출력  
			
			korTotal += scores[i][0];							//0,0 1,0 2,0 의 합 >> 국어점수 총합
			mathTotal += scores[i][1];							//1,0 1,1 2,1 의 합 >> 영어점수 총합
			engTotal += scores[i][2];							//2,0 2,1 2,2 의 합 >> 수학점수 총합
			
			int total = 0;										//0번행, 1번행, 2번행의 총점을 저장하는 변수
			for(int j = 0; j < scores[i].length; j++) {			//scores[1].length == > 열의길이
				total += scores[i][j];							// 각 행별 과목점수를 total에 누적
				System.out.print(scores[i][j] + "\t");			// 각 행별 과목점수를 출력
			}
			System.out.print(total + "\t" + total / 3 + "\t");	// 각 행별 총점과 평균을 출력
			System.out.println();
		}
		System.out.println("===========================================");
		System.out.println("총점" + "\t" + korTotal + "\t" + mathTotal + "\t" + engTotal);
	}
}
