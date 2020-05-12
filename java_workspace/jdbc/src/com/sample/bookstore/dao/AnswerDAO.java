package com.sample.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sample.bookstore.util.ConnectionUtil;
import com.sample.bookstore.util.QueryUtil;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Question;

public class AnswerDAO {

	public void addAnswer(Answer answer) throws Exception {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.addAnswer"));
		
		pstmt.setString(1, answer.getContent());
		pstmt.setInt(2, answer.getQuestionNo());
		pstmt.executeUpdate();
		
		pstmt = connection.prepareStatement(QueryUtil.getSQL("question.updateStatus"));
		pstmt.setString(1, "Y");
		pstmt.setInt(2, answer.getQuestionNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public Answer getAnswer(int questionNo) throws Exception {
		
		Answer answer = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("answer.getAnswerByQuestionNo"));
		
		pstmt.setInt(1, questionNo);
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()) {
			answer = new Answer();
			answer.setNo(rs.getInt("question_no"));
			answer.setContent(rs.getString("answer_content"));
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return answer;
	}
	
	
}
