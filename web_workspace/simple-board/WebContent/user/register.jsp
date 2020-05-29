<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String email = request.getParameter("email");
	String pwd = request.getParameter("pwd");
	
	UserDao userDao = new UserDao();
	User findUser = userDao.getUserbyUserId(id);
	
	if (findUser == null) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(pwd);
		
		userDao.insertNewUser(user);
		
		response.sendRedirect("../home.jsp");
		return;
		
	} else if (id.equals(findUser.getId())) {
		response.sendRedirect("form.jsp?error=dup");
		return;
	}
	
	
	
%>