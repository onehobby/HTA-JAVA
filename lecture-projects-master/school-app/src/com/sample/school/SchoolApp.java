package com.sample.school;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.sample.school.service.SchoolServiceImple;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolApp {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	private static int nextInt() {
		try {
			String text = in.readLine();
			return Integer.parseInt(text);
		} catch (IOException e) {
			return 0;
		}
	}
	
	private static String next() {
		try {
			return in.readLine();
		} catch (IOException e) {
			return "";
		}
	}
	
	public static void main(String[] args) {
		SchoolServiceImple service = new SchoolServiceImple();
		
		while (true) {
			System.out.println();
			System.out.println("[수강신청 프로그램]");
			System.out.println("==============================");
			System.out.println("1.교수님 관련기능	2.학생관련기능");
			System.out.println("==============================");

			System.out.print("메뉴를 선택하세요: ");
			int menuNo = nextInt();
			
			if(menuNo == 1) {
				System.out.println("[교수님 관련 기능]");
				System.out.println("==============================================================");
				System.out.println("1.교수등록	2.과목등록	3.과목조회	4.개설과정등록 5.과정 신청자조회 6.성적부여");
				System.out.println("==============================================================");

				System.out.print("원하시는 메뉴를 선택하세요");
				int pMenuNo = nextInt();
				
				if(pMenuNo == 1) {
					System.out.println("[신규 교수님 등록]");
					
					Professor professor = new Professor();
					
					System.out.print("이름을 입력하세요: ");
					professor.setName(next());
					System.out.print("이메일을 입력하세요: ");
					professor.setEmail(next());
					System.out.print("학과를 입력하세요: ");
					professor.setDept(next());
					System.out.print("직위를 입력하세요: ");
					professor.setPosition(next());
					System.out.print("급여를 입력하세요: ");
					professor.setSalary(nextInt());
					
					service.addNewProfessor(professor);
					
				} else if(pMenuNo == 2) {
					System.out.println("과목등록");
					
					Subject subject = new Subject();
					
					System.out.print("과목명을 입력하세요: ");
					subject.setTitle(next());
					System.out.print("학과를 입력하세요: ");
					subject.setDept(next());
					System.out.print("학점을 입력하세요(1~3사이): ");
					subject.setCredit(nextInt());
					
					service.addNewSubject(subject);
					
				} else if(pMenuNo == 3) {
					System.out.println("과목조회");
					
					System.out.print("교수번호를 입력하세요");
					service.displaySubject(nextInt());
					
				} else if(pMenuNo == 4) {
					System.out.println("신규 개설과정 등록");
					
					Course course = new Course();
					
					System.out.print("과정명을 입력하세요: ");
					course.setName(next());
					System.out.print("과목번호를 입력하세요: ");
					course.setSubjectNo(nextInt());
					System.out.print("담당교수번호를 입력하세요: ");
					course.setProfessorNo(nextInt());
					System.out.print("과정정원을 입력하세요:");
					course.setQuota(nextInt());
					
					service.addNewCourse(course);
					
					
				} else if(pMenuNo == 5) {
					
				} else if(pMenuNo == 6) {
					
				} 
			} else if(menuNo == 2) {
				System.out.println("[학생 관련 기능]");
				System.out.println("==============================================================");
				System.out.println("1.신규학생등록 2.과목조회 3.개설과정조회 4.수강신청 5.수강신청현황조회 6.수강신청 취소 7.성적조회");
				System.out.println("==============================================================");

				System.out.print("원하시는 메뉴를 선택하세요");
				int sMenuNo = nextInt();
				
				if(sMenuNo == 1) {
					System.out.println("신규학생등록");
					
					Student student = new Student();
					
					System.out.print("이름을 입력하세요: ");
					student.setName(next());
					System.out.print("이메일을 입력하세요: ");
					student.setEmail(next());
					System.out.print("학과를 입력하세요");
					student.setDept(next());
					System.out.print("학년을 입력하세요: ");
					student.setGrade(nextInt());
					
					service.addNewStudent(student);
				} else if(sMenuNo == 2) {
					System.out.println("과목조회");
					
					System.out.print("학생번호를 입력하세요: ");
					service.displaySubjectByStudent(nextInt());
				} else if(sMenuNo == 3) {
					System.out.println("개설과정조회");
					
					System.out.print("학생번호를 입력하세요: ");
					service.displayCourseByStudent(nextInt());
				} else if(sMenuNo == 4) {
					System.out.println("수강신청");
					Student student = new Student();
					Course course = new Course();
					System.out.print("학생번호를 입력하세요: ");
					int studentNo = nextInt();
					System.out.print("개설과정번호를 입력하세요: ");
					int courseNo = nextInt();
					
					service.applicationRegistration(studentNo, courseNo);
					
				} else if(sMenuNo == 5) {
					System.out.println("수강신청조회");
					
					System.out.print("학생번호를 입력하세요: ");
					int studentNo = nextInt();
					
					service.displayapplicationRegistration(studentNo);
				}
				
				
			}
		}
		
	}
	
}
