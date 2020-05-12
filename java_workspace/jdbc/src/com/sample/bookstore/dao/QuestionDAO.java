package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

public class QuestionDAO {
	
	public List<Question> getAllQuestions() throws Exception {
		
		List<Question> questions = new ArrayList<Question>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getAllQuestions"));
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			Question question = new Question();
			question.setNo(rs.getInt("question_no"));
			question.setTitle(rs.getString("question_title"));
			question.setContent(rs.getString("question_content"));
			question.setViewCount(rs.getInt("question_view_count"));
			question.setStatus(rs.getString("question_status"));
			question.setType(rs.getString("question_type"));
			question.setRegisteredDate(rs.getDate("question_registered_Date"));

			User user = new User();
			user.setId(rs.getString("user_id"));
			
			question.setUser(user);
			
			questions.add(question);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return questions;
	} 
	
	
	public Question getQuestionByNo(int questionNo) throws Exception {
		Question question = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.getQuestionByNo"));
		pstmt.setInt(1, questionNo);
		
		ResultSet rs = pstmt.executeQuery();
				
		if(rs.next()) {
			question = new Question();
			question.setNo(rs.getInt("question_no"));
			question.setTitle(rs.getString("question_title"));
			question.setContent(rs.getString("question_content"));
			question.setViewCount(rs.getInt("question_view_count"));
			question.setRegisteredDate(rs.getDate("question_registered_date"));
			question.setStatus(rs.getString("question_status"));
			question.setType(rs.getString("question_type"));
			
			User user = new User();
			user.setId(rs.getString("user_id"));
			
			question.setUser(user);
		}
		
		pstmt = connection.prepareStatement(QueryUtil.getSQL("question.updateViewCount"));
		pstmt.setInt(1, question.getViewCount() + 1);
		pstmt.setInt(2, questionNo);
		pstmt.executeUpdate();
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return question ;
		
	}
	
	
	public void addQuestion(Question question) throws Exception {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.addQuestion"));

		pstmt.setString(1, question.getTitle());
		pstmt.setString(2, question.getUser().getId());
		pstmt.setString(3, question.getContent());
		pstmt.setString(4, question.getType());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void removeQuestion(int questionNo) throws Exception {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("question.removeQuestion"));
		
		pstmt.setInt(1, questionNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
}
