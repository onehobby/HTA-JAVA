<%@page import="com.sample.dao.UserDao"%>
<%@page import="com.sample.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		request.setCharacterEncoding("utf-8");
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		User user = new User();
		user.setId(id);
		user.setPassword(password);
		user.setName(name);
		user.setEmail(email);
		
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
		
	%>
	
	<h1>사용자 등록 완료</h1>
	
	<p>새로운 사용자가 등록되었습니다.</p>
	
</body>
</html>