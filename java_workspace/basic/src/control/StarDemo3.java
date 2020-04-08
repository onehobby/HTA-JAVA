package control;

public class StarDemo3 {
	public static void main(String[] args) {
		/*
		 
		 		 **
		 	   ****
		 	 ******
		   ********
		 **********
		
		 */
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=10-i*2; j++ ) {
				System.out.print(" ");
			}
			for (int o=1; o<=i*2; o++  ) {
				System.out.print("*");
			}
			System.out.println();
			
		}
	}

}
