package datatype;

public class DataTypeDemo10 {
	public static void main(String[] args) {
		/*홍길동은 이번 시험에서 국어 80점, 영어 60점, 수학 45점을 획득했다.
		 * 
		 * 아래와 같이 출력되게 하시오
		 */
		
		int kor = 80;
		int eng = 60;
		int math = 45;
		String name = "홍길동";
		
		String str = ("이름	국어	영어	수학	총점	평균	");
		System.out.println(str);
		
		String str2 = (name+"\t"+kor +"\t"+ eng +"\t"+ math +"\t"+(kor+eng+math)+"\t"+((kor+eng+math)/3));
		System.out.println(str2);
	}

}