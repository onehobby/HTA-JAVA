<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/logincheck.jsp" %>
<%
	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String userId = (String)session.getAttribute("LOGINED_USER_ID");
	
	BoardDto boardDto = new BoardDto();
	boardDto.setBoardTitle(title);
	boardDto.setBoardContent(content);
	boardDto.setUserId(userId);
	
	BoardDao boardDao = new BoardDao();
	boardDao.insertNewPostUsedBoardDto(boardDto);
	
	response.sendRedirect("list.jsp");
	
%>