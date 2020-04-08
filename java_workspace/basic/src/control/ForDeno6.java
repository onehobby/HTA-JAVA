package control;

public class ForDeno6 {

	public static void main(String[] args) {
		// 1 + (1+2) + (1+2+3) ... 
		
		int sum = 0;
		for (int i=1; i<=10; i++) {
			for (int j=1; j<=i; j++) {
			sum += j;
			}
		}
		System.out.println(sum);
		
		
	}
}
