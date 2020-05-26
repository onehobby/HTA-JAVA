<%@page import="com.bookstore.dao.BookDao"%>
<%@page import="com.bookstore.dao.LikeDao"%>
<%@page import="com.bookstore.vo.Like"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%
			String position = "like";
		%>
		<%@ include file="../common/navibar.jsp" %>
		<%
			int bookNo = Integer.parseInt(request.getParameter("bookno"));
			String userId = request.getParameter("userid");
			
			Like like = new Like();
			like.setBookNo(bookNo);
			like.setUserId(userId);
			
			LikeDao likeDao = new LikeDao();
			likeDao.insertNewLike(like);
			
			BookDao bookDao = new BookDao();
			bookDao.updateBookLike(bookNo);
			
			response.sendRedirect("../book/detail.jsp?bookno=" + bookNo);
					
		%>
	</div>
</div>
</body>
</html>