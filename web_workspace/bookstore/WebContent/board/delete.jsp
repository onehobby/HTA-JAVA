<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("utf-8");

	int boardNo = NumberUtil.stringToInt(request.getParameter("boardno"));
	
	BoardDao boardDao = new BoardDao();
	boardDao.deleteBoardByBoardNo(boardNo);
	
	response.sendRedirect("all.jsp");
%>
