package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.TodoDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;

public class TodoDao {
	
	public List<TodoDto> getRecentTodos() throws SQLException {
		
		List<TodoDto> todos = new ArrayList<TodoDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("todo.getRecentTodos"));
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			TodoDto todoDto = new TodoDto();
			
			todoDto.setNo(rs.getInt("todo_no"));
			todoDto.setTitle(rs.getString("todo_title"));
			todoDto.setContent(rs.getString("todo_content"));
			todoDto.setDay(rs.getDate("todo_day"));
			todoDto.setCompletedDay(rs.getDate("todo_completed_date"));
			todoDto.setStatus(rs.getString("todo_status"));
			todoDto.setUserId(rs.getString("user_id"));
			todoDto.setUserName(rs.getString("user_name"));
			todoDto.setCreateDate(rs.getDate("todo_created_date"));
			
			todos.add(todoDto);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return todos;
		
		
	}

}
