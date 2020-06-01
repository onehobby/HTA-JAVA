<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	int boardNo = NumberUtil.stringToInt(request.getParameter("no"));

	BoardDao boardDao = new BoardDao();
	boardDao.updateBoardStateDelY(boardNo);
	
	response.sendRedirect("list.jsp");
%>