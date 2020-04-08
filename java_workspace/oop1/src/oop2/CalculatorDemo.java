package oop2;

public class CalculatorDemo {
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		int result1 = calculator.plus(6, 8);
		double result2 = calculator.plus(6.2, 8.8);
		long result3 = calculator.plus(66122L, 85854L);
		int result = calculator.plus(6, 8, 7);
	}

}
