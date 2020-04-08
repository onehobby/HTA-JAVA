package control;

public class forDemo2 {
	public static void main(String[] args) {
		/*
		 * 1부터 5까지의 합계를 계산하기
		 * 
		 * 
		 */
		int sum=0;
		for(int i=1; i<=100; i++ ) {
//			System.out.print("["+i+"] ["+sum+"] ---->");
			sum += i;
//			System.out.println("["+sum+"]");
		}
		System.out.println(sum);
	}

}
