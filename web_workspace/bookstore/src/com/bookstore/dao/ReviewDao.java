package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.ReviewDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Review;

public class ReviewDao {

	public List<ReviewDto> getReviewByBookNo(int bookNo) throws SQLException {
		
		List<ReviewDto> reviews = new ArrayList<ReviewDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review.getReviewByBookNo"));
		pstmt.setInt(1, bookNo);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			ReviewDto reviewDto = new ReviewDto();
			
			reviewDto.setNo(rs.getInt("review_no"));
			reviewDto.setUserName(rs.getString("user_name"));
			reviewDto.setPoint(rs.getInt("review_point"));
			reviewDto.setContent(rs.getString("review_content"));
			reviewDto.setRegisteredDate(rs.getDate("review_registered_date"));
			
			reviews.add(reviewDto);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reviews;
	}
	
	public void insertNewReview(Review review) throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review_insertNewReview"));
		
		pstmt.setString(1, review.getContent());
		pstmt.setInt(2, review.getPoint());
		pstmt.setInt(3, review.getBookNo());
		pstmt.setString(4, review.getUserId());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public ReviewDto checkedReview(ReviewDto reviewDto) throws SQLException {
		
		ReviewDto reviewDTO = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("review_checkedReview"));
		pstmt.setString(1, reviewDto.getUserId());
		pstmt.setInt(2, reviewDto.getBookNo());
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			reviewDTO = new ReviewDto();
			
			reviewDTO.setReviewYN(rs.getString("review_yn"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return reviewDTO;
		
	}
	
}
