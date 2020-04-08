package oop2;

import java.text.DecimalFormat;

public class Myutils {

	public static String numberWithComma(int number) {
			DecimalFormat df = new DecimalFormat("#,###");
			return df.format(number);
		}
}
