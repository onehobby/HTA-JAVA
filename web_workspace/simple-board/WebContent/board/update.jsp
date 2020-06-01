<%@page import="com.simple.vo.Board"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@ include file="../common/logincheck.jsp" %>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int boardNo = NumberUtil.stringToInt(request.getParameter("no"));
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	BoardDao boardDao = new BoardDao();
	BoardDto boardDto = boardDao.getPostsWithUserIdByBoardNo(boardNo);
	
	if (!loginedUserID.equals(boardDto.getUserId())) {
		response.sendRedirect("modifyform.jsp?error=im");
		return;
	}
	
	Board board = new Board();
	board.setNo(boardNo);
	board.setTitle(title);
	board.setContent(content);
	
	boardDao.updatePostByBoard(board);
	
	response.sendRedirect("detail.jsp?no=" + boardNo);
	
	
	
	
%>