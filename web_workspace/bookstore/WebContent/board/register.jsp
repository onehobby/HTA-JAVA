<%@page import="com.bookstore.dao.BoardDao"%>
<%@page import="com.bookstore.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String content = request.getParameter("content");
	String password = request.getParameter("password");
	
	Board board = new Board();
	board.setTitle(title);
	board.setWriter(writer);
	board.setContent(content);
	board.setPassword(password);
	
	BoardDao boardDao = new BoardDao();
	boardDao.insertNewPost(board);
	
	response.sendRedirect("all.jsp");
	
%>