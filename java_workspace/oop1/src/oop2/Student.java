package oop2;

public class Student {
	
//	String name;
//	int classNum;
//	int number;
//	int kor;
//	int eng;
//	int math;
	
//	int sum(int kor, int eng, int math) {
//		int total = kor + eng + math;
//	
//		return total;
//	}
//	
//	int average(int total) {
//		int avg = total/3;
//		
//		return avg;
//	}
//	
//	void display() {
//		int total = sum(kor,eng,math);
//		int avg = average(total);
	
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	int getTotalScore() {
		return kor + eng + math;
	}
	
	int getAverage() {
		int totalScore = getTotalScore();
		return totalScore / 3;
	}
	
	void displayStudentInfo() {
		System.out.println("------ 학생정보 ------");
		System.out.println("학생이름: " + name);
		System.out.println("    반: " + ban);
		System.out.println("번    호: " + no);
		System.out.println("국어점수: " + kor);
		System.out.println("영어점수: " + eng);
		System.out.println("수학점수: " + math);
		System.out.println("총    점: " + getTotalScore());
		System.out.println("평    균: " + getAverage());
		System.out.println("-------------------");
	}
	
	void displayStudentInfoForRow() {
		System.out.print(name+"\t");
		System.out.print(ban+"\t");
		System.out.print(no+"\t");
		System.out.print(kor+"\t");
		System.out.print(eng+"\t");
		System.out.print(math+"\t");
		System.out.print(getTotalScore()+"\t");
		System.out.println(getAverage()+"\t");
	}

//		System.out.print(name + "\t" + classNum + "\t" + number + "\t" + kor  + "\t" + eng  + "\t" + math + "\t" + total + "\t" + avg);
//		System.out.println("\n\n");
//	}
}
