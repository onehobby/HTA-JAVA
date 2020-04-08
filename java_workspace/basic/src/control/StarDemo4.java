package control;

public class StarDemo4 {
		
	public static void main(String[] args) {
		
		/*
		 
		  **			i=1 공백 4개 별 2개
		 ****			i=2	공백 3개 별 4개
		******			i=3 공백 2개 별	6개
	   ********			i=4 공백 1개 별 8개
	  **********  		i=5 공백 0개 별 10개
	
		 */
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=(5-i); j++) {
				System.out.print(" ");
			}
			for(int o=1; o<=i*2; o++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
