<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	// 해당 세션의 클라이언트의 세션을 폐기시킨다.
	session.invalidate();

	response.sendRedirect("/bookstore/home.jsp");
%>