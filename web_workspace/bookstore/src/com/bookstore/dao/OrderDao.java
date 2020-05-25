package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.OrderDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Order;
import com.bookstore.vo.User;

public class OrderDao {

	
	public void insertNewOrder(Order order) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.insertOrder"));
		
		pstmt.setString(1, order.getUserId());
		pstmt.setInt(2, order.getBookNo());
		pstmt.setInt(3, order.getPrice());
		pstmt.setInt(4, order.getAmount());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public List<OrderDto> getOrdersByUserid(String userId) throws SQLException  {
		
		List<OrderDto> orders = new ArrayList<OrderDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getOrdersByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
				
			OrderDto orderDto = new OrderDto();
			
			orderDto.setNo(rs.getInt("order_no"));
			orderDto.setTitle(rs.getString("book_title"));
			orderDto.setPrice(rs.getInt("order_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setTotalPrice(rs.getInt("total_price"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			orderDto.setBookNo(rs.getInt("book_no"));
			
			orders.add(orderDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orders;
		
	}
	
	public List<OrderDto> getAllOrdersWithUserName() throws SQLException {
		
		List<OrderDto> orders = new ArrayList<OrderDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("order.getAllOrdersWithUserName"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			OrderDto orderDto = new OrderDto();
			
			orderDto.setNo(rs.getInt("order_no"));
			orderDto.setUserName(rs.getString("user_name"));
			orderDto.setTitle(rs.getString("book_title"));
			orderDto.setPrice(rs.getInt("order_price"));
			orderDto.setAmount(rs.getInt("order_amount"));
			orderDto.setTotalPrice(rs.getInt("total_price"));
			orderDto.setRegisteredDate(rs.getDate("order_registered_date"));
			orderDto.setBookNo(rs.getInt("book_no"));
			
			orders.add(orderDto);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return orders;
		
	}
	
}
