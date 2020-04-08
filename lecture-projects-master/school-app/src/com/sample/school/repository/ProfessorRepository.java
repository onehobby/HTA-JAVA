package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Professor;

public class ProfessorRepository {

	private Professor[] db = new Professor[100];
	private int position = 0;
	private int sequence = 20000;
	
	public ProfessorRepository() {
		insertProfessor(new Professor("김교수", "kim@gmail.com", "전자공학과", "부교수", 5000000));
		insertProfessor(new Professor("최교수", "choi@naver.com", "컴퓨터공학과", "정교수", 6000000));
		insertProfessor(new Professor("박교수", "park@hanmail.net", "전자공학과", "조교수", 4500000));
	}
	
	public void insertProfessor(Professor professor) {
		for(int i=0; i<position; i++) {
			if(db[i].getEmail().equals(professor.getEmail())) {
				System.out.println("같은 이메일이 존재합니다.");
				return;
			}
		}	
			professor.setNo(sequence);
			db[position] = professor;
			
			sequence++;
			position++;
			System.out.println("등록이 완료되었습니다.");
			
		}
	
	public Professor getProfessorByNo(int professorNo) {
		Professor result = null;
		
		for(int i=0; i<position; i++) {
			if(db[i].getNo() == professorNo) {
				result = db[i];
			}
		}
		return result;
	}
	
	public Professor[] getAllProfessor() {
		return Arrays.copyOfRange(db, 0, position);
	}
}
