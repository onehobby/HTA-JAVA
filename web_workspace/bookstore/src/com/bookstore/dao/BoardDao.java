package com.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.dto.BoardDto;
import com.bookstore.util.ConnectionUtil;
import com.bookstore.util.QueryUtil;
import com.bookstore.vo.Board;
import com.bookstore.vo.Reply;

public class BoardDao {
	
	public List<Board> getAllPosts() throws SQLException{
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllPosts"));
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setPassword(rs.getString("board_password"));
			board.setHit(rs.getInt("board_hit"));
			board.setDelYN(rs.getString("board_del_yn"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public List<Board> getAllPostsByTitle(String keyword) throws SQLException{
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllPostsByTitle"));
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setPassword(rs.getString("board_password"));
			board.setHit(rs.getInt("board_hit"));
			board.setDelYN(rs.getString("board_del_yn"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public List<Board> getAllPostsByWriter(String keyword) throws SQLException{
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllPostsByWriter"));
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setPassword(rs.getString("board_password"));
			board.setHit(rs.getInt("board_hit"));
			board.setDelYN(rs.getString("board_del_yn"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public List<Board> getAllPostsByContent(String keyword) throws SQLException{
		
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllPostsByContent"));
		pstmt.setString(1, keyword);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setPassword(rs.getString("board_password"));
			board.setHit(rs.getInt("board_hit"));
			board.setDelYN(rs.getString("board_del_yn"));
			board.setRegisteredDate(rs.getDate("board_registered_date"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	
	
	public void insertNewPost(Board board) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertNewPost"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		pstmt.setString(4, board.getPassword());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public BoardDto getpostByBoardNo(int boardNo) throws SQLException {
		
		BoardDto boardDto = null;
			
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getpostByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			boardDto = new BoardDto();
			
			boardDto.setNo(rs.getInt("board_no"));
			boardDto.setTitle(rs.getString("board_title"));
			boardDto.setWriter(rs.getString("board_writer"));
			boardDto.setHit(rs.getInt("board_hit"));
			boardDto.setContent(rs.getString("board_content"));
			boardDto.setPassword(rs.getInt("board_password"));
			boardDto.setRpCount(rs.getInt("rp_count"));
			boardDto.setRegisteredDate(rs.getDate("board_registered_date"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boardDto;
		
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
			reply.setWriter(rs.getString("reply_writer"));
			reply.setContent(rs.getString("reply_content"));
			reply.setRegistered_date(rs.getDate("reply_registered_date"));
			reply.setBoardNo(rs.getInt("board_no"));
			
			replys.add(reply);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return replys;
	}
	
	public void deleteBoardByBoardNo(int boardNo) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.deleteBoardByBoardNo"));
		pstmt.setInt(1, boardNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public void updateBoardFromBoardPWD(BoardDto boardDto) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoardFromBoardPWD"));
		pstmt.setString(1, boardDto.getTitle());
		pstmt.setString(2, boardDto.getWriter());
		pstmt.setString(3, boardDto.getContent());
		pstmt.setInt(4, boardDto.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
}
