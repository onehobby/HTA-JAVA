package control;

public class WhileDemo5 {
	public static void main(String[] args) {
		
		
		int sum = 0;
		int number = 1;
		while (true) {
			if(number%2==0) {
				sum+=number*-1;				
			} else {
				sum+=number;
			}
			if(sum>=100) {
				break;
			}
			number++;
			
			}
			System.out.println(number);
	}

}
