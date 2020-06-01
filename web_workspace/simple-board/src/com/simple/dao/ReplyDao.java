package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.ReplyDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Reply;

public class ReplyDao {

	public List<ReplyDto> getReplysByUserId(String userId) throws SQLException {
		List<ReplyDto> replys = new ArrayList<ReplyDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.getReplysByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			ReplyDto reply = new ReplyDto();
			
			reply.setReplyNo(rs.getInt("reply_no"));
			reply.setReplyContent(rs.getString("reply_content"));
			reply.setReplyDelYN(rs.getString("reply_del_yn"));
			reply.setReplyCreateDate(rs.getDate("reply_create_date"));
			reply.setUserId(rs.getString("user_id"));
			
			replys.add(reply);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return replys;
	}
	
	public List<Reply> getReplysByBoardNo(int boardNo) throws SQLException {
		List<Reply> replys = new ArrayList<Reply>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.getReplysByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Reply reply = new Reply();
			
			reply.setNo(rs.getInt("reply_no"));
			reply.setContent(rs.getString("reply_content"));
			reply.setDelYN(rs.getString("reply_del_yn"));
			reply.setCreateDate(rs.getDate("reply_create_date"));
			reply.setWriter(rs.getString("reply_writer"));
			
			replys.add(reply);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return replys;
	}
	
	public void insertNewReply(Reply reply) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("reply.insertNewReply"));
		pstmt.setString(1, reply.getContent());
		pstmt.setString(2, reply.getWriter());
		pstmt.setInt(3, reply.getBoardNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
}
