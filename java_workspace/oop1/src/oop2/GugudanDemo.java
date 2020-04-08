package oop2;

public class GugudanDemo {

	public static void main(String[] args) {
		
//		Gugudan gugudan = new Gugudan();	// Gugudan class의 메소드를 사용하기 위해서 Gugudan을 객체화해야한다.
											// 객체화한것을 참조변수 gugudan에 담는다.
		Gugudan gugudan = new Gugudan();
		
		gugudan.print99dan();
		
		gugudan.print99danByRange(5, 10);
		gugudan.print99danByRange(11, 19);
		
//		gugudan.print99danByNumber(4);
		
	}
}
