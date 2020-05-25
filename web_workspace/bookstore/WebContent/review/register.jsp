<%@page import="java.net.URLEncoder"%>
<%@page import="com.bookstore.dao.ReviewDao"%>
<%@page import="com.bookstore.vo.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String userId = request.getParameter("userid");
	int bookNo = Integer.parseInt(request.getParameter("bookno"));
	int point = Integer.parseInt(request.getParameter("point"));
	String content = request.getParameter("content");
	
	Review review = new Review();
	
	review.setUserId(userId);
	review.setBookNo(bookNo);
	review.setPoint(point);
	review.setContent(content);
	
	ReviewDao reviewdao = new ReviewDao();
	reviewdao.insertNewReview(review);
	
	String bn = String.valueOf(bookNo);
	String encodedValue = URLEncoder.encode(bn, "utf-8");
	
	response.sendRedirect("../book/detail.jsp?bookno=" + bookNo);
	

%>
