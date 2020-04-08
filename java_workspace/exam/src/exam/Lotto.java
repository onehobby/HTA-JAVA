package exam;

import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
	
		int[] numbers = new int[6];
		int position = 0;
		
		while (true) {

			int randomNumber = (int) (Math.random()*45+1);
			
			if (!isExist(numbers, randomNumber)) {
				numbers[position++] = randomNumber;
			}
			if (position == 6) {
				break;
			}
		}
		System.out.println();
		System.out.println(Arrays.toString(numbers));
	}
	
	private static boolean isExist(int[] numbers, int randomNumber) {
		boolean isExist = false;
		for (int item : numbers) {
			if (item == randomNumber) {
				isExist = true;
				break;
			}
		}
		return isExist;
	}
}
