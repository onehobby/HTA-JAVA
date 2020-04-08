package com.sample.school.repository;

import java.util.Arrays;

import com.sample.school.vo.Professor;
import com.sample.school.vo.Subject;

public class SubjectRepository {

	private Subject[] db = new Subject[100];
	private int position = 0;
	private int sequence = 30000;
	
	public SubjectRepository() {
		insertSubject(new Subject("회로이론", "전자공학과", 3));
		insertSubject(new Subject("전자기학", "전자공학과", 3));
		insertSubject(new Subject("공업수학", "전자공학과", 3));
		insertSubject(new Subject("기초실험실습", "전자공학과", 2));
		insertSubject(new Subject("이산수학", "컴퓨터공학과", 3));
		insertSubject(new Subject("프로그램 기초", "컴퓨터공학과", 3));
		insertSubject(new Subject("데이터베이스 기초", "컴퓨터공학과", 3));
		insertSubject(new Subject("암호학 개론", "컴퓨터공학과", 3));
	}
	
	public void insertSubject(Subject subject)  {
		for(int i=0; i<position; i++) {
			if(db[i].getTitle().equals(subject.getTitle())) {
				System.out.println("같은이름의 과목이 존재합니다.");
				return;
			}
		}
			subject.setNo(sequence);
			db[position] = subject;
			
			sequence++;
			position++;
		}
	
	public Subject getSubjectByNo(int subjectNo) {
		Subject result = null;
		
		for(int i=0; i<position; i++) {
			 if(db[i].getNo() == subjectNo) {
				result = db[i];
			}
		}
		return result;
	}
	
	public Subject[] getAllSubject() {
		return Arrays.copyOfRange(db, 0, position);
	}
}
