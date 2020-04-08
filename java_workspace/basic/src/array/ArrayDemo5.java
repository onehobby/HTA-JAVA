package array;

public class ArrayDemo5 {

	public static void main(String[] args) {
//		2차원배열
		int[][] scores = new int[2][3]; //2행 3열 2차원 배열, 세로2줄 가로3칸
		// 0번행은 이순신의 국어,영어,수학점수
		scores[0][0] = 60; // 1행 1열
		scores[0][1] = 80; // 1행 2열
		scores[0][2] = 90; // 1행 3열
		// 1번행은 김유신의 국어,영어,수학점수
		scores[1][0] = 50; // 2행 1열
		scores[1][1] = 40; // 2행 2열
		scores[1][2] = 40; // 2행 3열
		
		for (int i = 0; i < scores.length; i++) {					// 행
			for(int j = 0; j < scores[i].length; j++) {				// 열
				System.out.println(i + "," + j + "---->" + scores[i][j]);
			}
		}
		
		// 2차원 배열의 값을 출력할 때에는 중첩된 for문을 써야한다.
		
		System.out.println(scores.length);
		System.out.println(scores[0].length); // 0행의 열의 길이 = 3
		System.out.println(scores[1].length); // 1행의 열의 길이 = 3
		
		
		
//		이순신의 점수 총점, 1행 1열~3열 까지의 값
		int total1 = 0;
		int total2 = 0;
		for(int i = 0; i < 3; i++) {
			System.out.println(scores[0][i]);
			total1 += scores[0][i];
		}
		System.out.println("이순신의 총점: " + total1);
		
//		김유신의 점수 총점 2행 1열~3열 까지의 값
		for(int i = 0; i < 3; i++) {
			System.out.println(scores[1][i]);
			total2 += scores[1][i];
		}
		System.out.println("김유신의 총점: " + total2);
	}
}
