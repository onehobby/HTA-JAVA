package com.sample.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.util.ConnectionUtil;
import com.sample.school.util.QueryUtil;
import com.sample.school.vo.Department;
import com.sample.school.vo.Subject;

public class SubjectDAO {

	public void addSubject(Subject subject) throws Exception {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.addSubject"));
		
		pstmt.setString(1, subject.getName());
		pstmt.setInt(2, subject.getDepartment().getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public Subject getSubjectByNo(int subjectNo) throws Exception {
		Subject subject = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getSubjectByNo"));
		
		pstmt.setInt(1, subjectNo);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			subject = new Subject();
			
			subject.setNo(rs.getInt("subject_no"));
			subject.setName(rs.getString("subject_name"));
			subject.setRegisteredDate(rs.getDate("subject_reigstered_date"));
			
			Department department = new Department();
			
			department.setNo(rs.getInt("department_no"));
			
			subject.setDepartment(department);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return subject;

	}
	
	public List<Subject> getAllSubject() throws Exception {
		List<Subject> subject = new ArrayList<Subject>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("subject.getAllSubjects"));
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
		}
		
		return subject;
	}
	
}
