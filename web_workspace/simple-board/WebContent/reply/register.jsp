<%@page import="com.simple.util.NumberUtil"%>
<%@page import="com.simple.vo.Reply"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<%
	int boardNo = NumberUtil.stringToInt(request.getParameter("boardno"));
	String replyContent = request.getParameter("content");
	String userId = (String) session.getAttribute("LOGINED_USER_ID");
	
	Reply reply = new Reply();
	reply.setBoardNo(boardNo);
	reply.setWriter(userId);
	reply.setContent(replyContent);
	
	ReplyDao replyDao = new ReplyDao();
	replyDao.insertNewReply(reply);
	
	response.sendRedirect("../board/detail.jsp?no=" + boardNo);
	
%>