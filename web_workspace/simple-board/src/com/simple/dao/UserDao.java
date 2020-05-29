package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.User;


public class UserDao {
	
	public void insertNewUser(User user) throws SQLException{
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.insertNewUser"));
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public User getUserbyUserId(String userId) throws SQLException {
		
		User user = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUserbyUserId"));
		pstmt.setString(1, userId);
	 	ResultSet rs= pstmt.executeQuery();
	 	
	 	if(rs.next()) {
	 		user = new User();
	 		user.setId(rs.getString("user_id"));
	 		user.setName(rs.getString("user_name"));
	 		user.setPassword(rs.getString("user_password"));
	 		user.setEmail(rs.getString("user_email"));
	 		user.setDisabled(rs.getString("user_disabled"));
	 		user.setCreateDate(rs.getDate("user_create_date"));
	 	}
	 	
	 	rs.close();
	 	pstmt.close();
	 	connection.close();
	 	
	 	return user;
	}

}
