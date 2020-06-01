package com.simple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.simple.dto.BoardDto;
import com.simple.util.ConnectionUtil;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDao {
	
	public List<BoardDto> getBoardByUserId(String userId) throws SQLException {
		List<BoardDto> boards = new ArrayList<BoardDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoardByUserId"));
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			BoardDto board = new BoardDto();
			
			board.setBoardNo(rs.getInt("board_no"));
			board.setBoardTitle(rs.getString("board_title"));
			board.setBoardHit(rs.getInt("board_hit"));
			board.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			board.setBoardDelYN(rs.getString("board_del_yn"));
			board.setBoardCreateDate(rs.getDate("board_create_date"));
			board.setUserId(rs.getString("user_id"));
			
			boards.add(board);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public List<Board> getAllBoards() throws SQLException {
		List<Board> boards = new ArrayList<Board>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllBoards"));
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			Board board = new Board();
			
			board.setNo(rs.getInt("board_no"));
			board.setTitle(rs.getString("board_title"));
			board.setWriter(rs.getString("board_writer"));
			board.setContent(rs.getString("board_content"));
			board.setHit(rs.getInt("board_hit"));
			board.setReplyCnt(rs.getInt("board_reply_cnt"));
			board.setDelYN(rs.getString("board_del_yn"));
			board.setCreateDate(rs.getDate("board_create_date"));
			
			boards.add(board);
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public List<BoardDto> getAllBoardsWtihUserId() throws SQLException {
		List<BoardDto> boards = new ArrayList<BoardDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getAllBoardsWtihUserId"));
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			BoardDto boardDto = new BoardDto();
			
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardHit(rs.getInt("board_hit"));
			boardDto.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			boardDto.setBoardDelYN(rs.getString("board_del_yn"));
			boardDto.setBoardCreateDate(rs.getDate("board_create_date"));
			boardDto.setUserId(rs.getString("user_id"));
			boardDto.setBoardContent(rs.getString("board_content"));
			
			boards.add(boardDto);
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
	}
	
	public void updateHitByBoardNo(int boardNo) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateHitByBoardNo"));
		pstmt.setInt(1, boardNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	
	public void updateBoardStateDelY(int boardNo) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoardStateDelY"));
		pstmt.setInt(1, boardNo);
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		
	}
	public void updatePostByBoard(Board board) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateEditPostByBoardNo"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getNo());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	public void insertNewPostUsedBoardDto(BoardDto boardDto) throws SQLException {
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertNewPostUsedBoardDto"));
		pstmt.setString(1, boardDto.getBoardTitle());
		pstmt.setString(2, boardDto.getUserId());
		pstmt.setString(3, boardDto.getBoardContent());
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
	}
	
	
	
	
	
	public BoardDto getPostsWithUserIdByBoardNo(int boardNo) throws SQLException {
		
		BoardDto boardDto = null;
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getPostsWithUserIdByBoardNo"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			
			boardDto = new BoardDto();
			boardDto.setBoardNo(rs.getInt("board_no"));
			boardDto.setBoardTitle(rs.getString("board_title"));
			boardDto.setBoardHit(rs.getInt("board_hit"));
			boardDto.setBoardReplyCnt(rs.getInt("board_reply_cnt"));
			boardDto.setBoardDelYN(rs.getString("board_del_yn"));
			boardDto.setBoardCreateDate(rs.getDate("board_create_date"));
			boardDto.setUserId(rs.getString("user_id"));
			boardDto.setBoardContent(rs.getString("board_content"));
			
		}
		
		rs.close();
		pstmt.close();
		connection.close();
		
		return boardDto;
	}

	
}
