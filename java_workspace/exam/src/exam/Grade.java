package exam;

public class Grade {

	private int math;
	private int science;
	private int english;
	
	Grade() {}
	
	Grade(int math, int science, int english) {
		this.math = math;
		this.science = science;
		this.english = english;
	}
	
	public int avr(int math, int science, int english) {
		int result = 0;
		
		result = (int)((math+science+english)/3);
		
		return result;
	}
	
}
