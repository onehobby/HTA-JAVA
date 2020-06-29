package com.simple.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.simple.dto.BoardDto;
import com.simple.util.JdbcHelper;
import com.simple.util.JdbcHelper.RowMapper;
import com.simple.util.QueryUtil;
import com.simple.vo.Board;

public class BoardDao {

	public void insertBoard(Board board) {
		
		JdbcHelper.insert(QueryUtil.getSQL("board.insertBoard"), 
						  board.getTitle(), board.getWriter(), board.getContent());
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.insertBoard"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getWriter());
		pstmt.setString(3, board.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}
	
	public void updateBoard(Board board) {
		
		JdbcHelper.update(QueryUtil.getSQL("board.updateBoard"), 
						board.getTitle(), board.getContent(), board.getHit(), board.getReplyCnt(), board.getDelYn(), board.getNo());
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoard"));
		pstmt.setString(1, board.getTitle());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getHit());
		pstmt.setInt(4, board.getReplyCnt());
		pstmt.setString(5, board.getDelYn());
		pstmt.setInt(6, board.getNo());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}
	
	public void deleteBoard(int boardNo) {
		
		JdbcHelper.update(QueryUtil.getSQL("board.deleteBoard"), boardNo);
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.deleteBoard"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}
	
	public void updateBoardHit(int boardNo) {
		
		JdbcHelper.update(QueryUtil.getSQL("board.updateBoardHit"), boardNo);
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoardHit"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}

	public void updateBoardReplyCnt(int boardNo) {
		
		JdbcHelper.update(QueryUtil.getSQL("board.updateBoardReplyCnt"), boardNo);
		
		/*
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.updateBoardReplyCnt"));
		pstmt.setInt(1, boardNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		connection.close();
		*/
	}
	
	public int getTotalRows() {
		
		return JdbcHelper.selectOne(QueryUtil.getSQL("board.getTotalRows"), new RowMapper<Integer>() {
			@Override
			public Integer mapRow(ResultSet rs) throws SQLException {
				return rs.getInt("cnt");
			}
		});
		
		/*
		int totalRows = 0;
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getTotalRows"));
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		totalRows = rs.getInt("cnt");
		rs.close();
		pstmt.close();
		connection.close();
		return totalRows;
		*/
	}
	
	public List<BoardDto> getBoards(int beginIndex, int endIndex) {
		
		return JdbcHelper.selectList(QueryUtil.getSQL("board.getBoards"), new RowMapper<BoardDto>() {
			@Override
			public BoardDto mapRow(ResultSet rs) throws SQLException {
				BoardDto dto = new BoardDto();
				dto.setNo(rs.getInt("board_no"));
				dto.setTitle(rs.getString("board_title"));
				dto.setWriter(rs.getString("board_writer"));
				dto.setWriterName(rs.getString("board_writer_name"));
				dto.setContent(rs.getString("board_content"));
				dto.setHit(rs.getInt("board_hit"));
				dto.setReplyCnt(rs.getInt("board_reply_cnt"));
				dto.setDelYn(rs.getString("board_del_yn"));
				dto.setCreateDate(rs.getDate("board_create_date"));
				return dto;
			}
		}, beginIndex, endIndex);
		
		/*
		List<BoardDto> boards = new ArrayList<BoardDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoards"));
		pstmt.setInt(1, beginIndex);
		pstmt.setInt(2, endIndex);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next() ) {
			BoardDto dto = new BoardDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriter(rs.getString("board_writer"));
			dto.setWriterName(rs.getString("board_writer_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setHit(rs.getInt("board_hit"));
			dto.setReplyCnt(rs.getInt("board_reply_cnt"));
			dto.setDelYn(rs.getString("board_del_yn"));
			dto.setCreateDate(rs.getDate("board_create_date"));
			
			boards.add(dto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
		*/
	}
	
	public List<BoardDto> getBoardsByWriter(String writer) {
		
		return JdbcHelper.selectList(QueryUtil.getSQL("board.getBoardsByWriter"), new RowMapper<BoardDto>() {
			@Override
			public BoardDto mapRow(ResultSet rs) throws SQLException {
				BoardDto dto = new BoardDto();
				dto.setNo(rs.getInt("board_no"));
				dto.setTitle(rs.getString("board_title"));
				dto.setWriter(rs.getString("board_writer"));
				dto.setWriterName(rs.getString("board_writer_name"));
				dto.setContent(rs.getString("board_content"));
				dto.setHit(rs.getInt("board_hit"));
				dto.setReplyCnt(rs.getInt("board_reply_cnt"));
				dto.setDelYn(rs.getString("board_del_yn"));
				dto.setCreateDate(rs.getDate("board_create_date"));
				return dto;
			}
		}, writer);
		
		/*
		List<BoardDto> boards = new ArrayList<BoardDto>();
		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoardsByWriter"));
		pstmt.setString(1, writer);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next() ) {
			BoardDto dto = new BoardDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriter(rs.getString("board_writer"));
			dto.setWriterName(rs.getString("board_writer_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setHit(rs.getInt("board_hit"));
			dto.setReplyCnt(rs.getInt("board_reply_cnt"));
			dto.setDelYn(rs.getString("board_del_yn"));
			dto.setCreateDate(rs.getDate("board_create_date"));
			
			boards.add(dto);
		}
		rs.close();
		pstmt.close();
		connection.close();
		
		return boards;
		*/
	}
	
	public BoardDto getBoard(int boardNo) {
		
		return JdbcHelper.selectOne(QueryUtil.getSQL("board.getBoard"), new RowMapper<BoardDto>() {
			@Override
			public BoardDto mapRow(ResultSet rs) throws SQLException {
				BoardDto dto = new BoardDto();
				dto.setNo(rs.getInt("board_no"));
				dto.setTitle(rs.getString("board_title"));
				dto.setWriter(rs.getString("board_writer"));
				dto.setWriterName(rs.getString("board_writer_name"));
				dto.setContent(rs.getString("board_content"));
				dto.setHit(rs.getInt("board_hit"));
				dto.setReplyCnt(rs.getInt("board_reply_cnt"));
				dto.setDelYn(rs.getString("board_del_yn"));
				dto.setCreateDate(rs.getDate("board_create_date"));
				return dto;
			}
		}, boardNo);
		
		/*
		BoardDto dto = null;		
		Connection connection = ConnectionUtil.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(QueryUtil.getSQL("board.getBoard"));
		pstmt.setInt(1, boardNo);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			dto = new BoardDto();
			dto.setNo(rs.getInt("board_no"));
			dto.setTitle(rs.getString("board_title"));
			dto.setWriter(rs.getString("board_writer"));
			dto.setWriterName(rs.getString("board_writer_name"));
			dto.setContent(rs.getString("board_content"));
			dto.setHit(rs.getInt("board_hit"));
			dto.setReplyCnt(rs.getInt("board_reply_cnt"));
			dto.setDelYn(rs.getString("board_del_yn"));
			dto.setCreateDate(rs.getDate("board_create_date"));
		}
		rs.close();
		pstmt.close();
		connection.close();		
		return dto;
		*/
	}
}


