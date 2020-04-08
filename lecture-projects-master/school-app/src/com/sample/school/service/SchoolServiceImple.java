package com.sample.school.service;

import com.sample.school.repository.CourseRepository;
import com.sample.school.repository.ProfessorRepository;
import com.sample.school.repository.RegistrationRepository;
import com.sample.school.repository.StudentRepository;
import com.sample.school.repository.SubjectRepository;
import com.sample.school.vo.Course;
import com.sample.school.vo.Professor;
import com.sample.school.vo.Registration;
import com.sample.school.vo.Student;
import com.sample.school.vo.Subject;

public class SchoolServiceImple implements SchoolService {

	private CourseRepository courseRepo = new CourseRepository();
	private ProfessorRepository professorRepo = new ProfessorRepository();
	private RegistrationRepository registrationRepo = new RegistrationRepository();
	private SubjectRepository subjectRepo = new SubjectRepository();
	private StudentRepository studentRepo = new StudentRepository();
			
	
	@Override // 신규교수님 등록
	public void addNewProfessor(Professor professor) {
		professorRepo.insertProfessor(professor);
		
	}
	@Override // 신규과목 등록
	public void addNewSubject(Subject subject) {
		subjectRepo.insertSubject(subject);
	}
	
	@Override // 해당교수가 속한 학과에 대한 과목출력
	public void displaySubject(int professorNo) {
		Professor findProfessor = professorRepo.getProfessorByNo(professorNo);
		if(findProfessor == null) {
			System.out.println("해당 교수번호와 일치하는 정보가 없습니다");
			return;
		}
		Subject[] subject = subjectRepo.getAllSubject();
		System.out.println("======");
		System.out.println("과 목 명");
		System.out.println("======");
		for(int i=0; i<subject.length; i++) {
			if(findProfessor.getDept().equals(subject[i].getDept())) {
				System.out.println(subject[i].getTitle());
			}
		}
	}
	@Override // 신규 개설과정 등록
	public void addNewCourse(Course course) {
		Professor findProfessor = professorRepo.getProfessorByNo(course.getProfessorNo());
		Subject findSubject = subjectRepo.getSubjectByNo(course.getSubjectNo());
		
		if(findProfessor == null || findSubject == null) {
			System.out.println("해당 정보를 찾을수 없습니다.");
			return;
		}
		if(findProfessor.getDept().equals(findSubject.getDept())) {
			courseRepo.insertCourse(course);
			System.out.println("과목이 개설되었습니다.");
			return;
		} else {
			System.out.println("개설된 과목이 아닙니다.");
		}

	}
	
	@Override
	public void addNewStudent(Student student) {
		studentRepo.insertStudent(student);
	}
	
	
	@Override
	public void displaySubjectByStudent(int studentNo) {
		Student findStudent = studentRepo.getStudentByNo(studentNo);
	
		if(findStudent == null) {
			System.out.println("해당하는 학생정보가 없습니다.");
			return;
		}
		Subject[] subjects = subjectRepo.getAllSubject();
		System.out.println("======");
		System.out.println("과 목 명");
		System.out.println("======");
		
		for(int i=0; i<subjects.length; i++) {
			if(findStudent.getDept().equals(subjects[i].getDept())) {
				System.out.println(subjects[i].getTitle());
			}
		}
		
		
	}
	@Override
	public void displayCourseByStudent(int studentNo) {
		Student findStudent = studentRepo.getStudentByNo(studentNo);
		
		if(findStudent == null) {
			System.out.println("해당하는 학생정보가 없습니다");
			return;
		}
		Course[] courses = courseRepo.getAllCourse();
		System.out.println("과정번호		과정명		과목번호		담당교수번호		과정신청정원");
		System.out.println("============================================");
		for(int i=0; i<courses.length; i++) {
			Subject findSubject = subjectRepo.getSubjectByNo(courses[i].getSubjectNo());
			
			if(findSubject.getDept().equals(findStudent.getDept())) {
				System.out.print(courses[i].getNo()+"\t\t");
				System.out.print(courses[i].getName()+"\t\t");
				System.out.print(courses[i].getSubjectNo()+"\t\t");
				System.out.print(courses[i].getProfessorNo()+"\t\t");
				System.out.println(courses[i].getQuota()+"\t\t");
			}
		}
		
	}

	@Override
	public void applicationRegistration(int studentNo, int courseNo) {
		Student findStudent = studentRepo.getStudentByNo(studentNo);
		String findStudentDept = findStudent.getDept();
		
		Course findCourse = courseRepo.getCourseByNo(courseNo);
		Subject findSubjectByCourseNo = subjectRepo.getSubjectByNo(findCourse.getSubjectNo()) ;
		
		if(findStudent == null || findCourse == null) {
			System.out.println("정보를 찾을 수 없습니다.");
		}
		
		if(findStudentDept.equals(findSubjectByCourseNo.getDept())) {
			Registration registration = new Registration();
			registration.setStudentNo(studentNo);
			registration.setCourseNo(courseNo);
			registrationRepo.insertRegistration(registration);
		}
		
		
	}
	@Override
	
	public void displayapplicationRegistration(int studentNo) {
		Registration[] allRegistrations = registrationRepo.getAllRegistrationis();
		
		
		
		System.out.println("수강신청번호\t개설과정명\t취소여부");
		for(int i=0; i<allRegistrations.length; i++) {
			if(allRegistrations[i].getStudentNo() == studentNo) {
				System.out.println(allRegistrations[i].getCourseNo());

			}
		}
	}
	
	
	
	
	
	
	
}