package oop4;

public class ReporterDemo {

	public static void main(String[] args) {
		
		String[] names = {"김유신", "강감찬", "이순신", "류관순", "윤봉길"};
		DataOutput do1 = new DataOutput();
		ConsoleDataOutput do2 = new ConsoleDataOutput();
		FileDataOutput do3 = new FileDataOutput("c:files", "data.txt");
		
		Reporter reportor = new Reporter();
		// Repoter객체의 setOutputter()메소드를 이용해서 Reporter객체의
		// DataOutput멤버변수에 데이터 출력을 지원하는 객체(DataOutput류 객체)를
		// 전달해서 조립시킨다.
		reportor.setOutputter(do1);
		reportor.setData(names);
		
		reportor.reporting();
		
	}
}
