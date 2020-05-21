package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.dto.ReviewDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;

public class ReviewDao {

	public ReviewDto getReviewByBookNo(int bookNo) throws SQLException {
		ReviewDto review = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByBookNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			ReviewDto reviewDto = new ReviewDto();
			
			reviewDto.setNo(rs.getInt("review_no"));
			reviewDto.setUserName(rs.getString("user_name"));
			reviewDto.setPoint(rs.getInt("review_point"));
			reviewDto.setContent(rs.getString("review_content"));
			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
			
			review = reviewDto;
			
		}
		return review;
	}
	
}
