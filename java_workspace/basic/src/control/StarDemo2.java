package control;

public class StarDemo2 {
	public static void main(String[] args) {
		/*
		 
		  
		 **
		 ****
		 ******
		 ********
		 **********
		 
		 */
		
		for (int i=1; i<=5; i++) {
			for (int j=1; (i*2)>=j; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
