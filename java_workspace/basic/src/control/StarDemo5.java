package control;

public class StarDemo5 {
	public static void main(String[] args) {
		
		/*										공백갯수
		  										Math.abs(5-i)  // 절대값구하는 법 
		  **			i=1 공백 4개 별 2개			5-1		=4
		 ****			i=2	공백 3개 별 4개			5-2		=3
		******			i=3 공백 2개 별	6개			5-3		=2
	   ********			i=4 공백 1개 별 8개			5-4		=1
	  **********  		i=5 공백 0개 별 10개			5-5		=0
	   ********			i=6 공백 1개 별 8개			5-6		=-1	
	    ******			i=7	공백 2개 별 6개			5-7		=-2
		 ****			i=8 공백 3개 별	4개			5-8		=-3
		  **			i=9 공백 4개 별	2개			5-9		=-4

		 */
		
		for(int i=1; i<=9; i++) {
			int space = Math.abs(5-i);
			int star =10 -space*2;
		
					
			for(int j=1; j<=space; j++) {
				System.out.print(" ");
			}
			for (int k=1; k<=star; k++) {
			System.out.print("*");
			
		}
			System.out.println();
	}

	}
}
