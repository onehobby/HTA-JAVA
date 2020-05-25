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
			String bookNo = request.getParameter("bookno");
			String userId = request.getParameter("userid");
		%>
	</div>
</div>
	
</body>
</html>