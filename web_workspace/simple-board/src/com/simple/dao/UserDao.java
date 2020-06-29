package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.simple.util.JdbcHelper;
import com.simple.util.JdbcHelper.RowMapper;
import com.simple.util.QueryUtil;
import com.simple.vo.User;

public class UserDao {

	public void insertUser(User user) {
		
		JdbcHelper.insert(QueryUtil.getSQL("user.insertUser"), user.getId(), user.getName(), user.getPassword(), user.getEmail());
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.insertUser"));
		pstmt.setString(1, user.getId());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getPassword());
		pstmt.setString(4, user.getEmail());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}
	
	public void updateUser(User user) {
		
		JdbcHelper.update(QueryUtil.getSQL("user.updateUser"), user.getPassword(), user.getEmail(), user.getDisabled(), user.getId());
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.updateUser"));
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getEmail());
		pstmt.setString(3, user.getDisabled());
		pstmt.setString(4, user.getId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}
	
	public User getUser(String userId) {
		
		return JdbcHelper.selectOne(QueryUtil.getSQL("user.getUser"), new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs) throws SQLException {
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setName(rs.getString("user_name"));
				user.setPassword(rs.getString("user_password"));
				user.setEmail(rs.getString("user_email"));
				user.setDisabled(rs.getString("user_disabled"));
				user.setCreateDate(rs.getDate("user_create_date"));
				return user;
			}
		}, userId);
		
		/*
		User user = null;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("user.getUser"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
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
		*/
	}
}










