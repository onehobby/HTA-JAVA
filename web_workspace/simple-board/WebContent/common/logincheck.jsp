<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String loginedYN = (String) session.getAttribute("LOGINED_YN");
	String loginedUserID = (String) session.getAttribute("LOGINED_USER_ID");
	String loginedUserName = (String) session.getAttribute("LOGINED_USER_NAME");
	
	
	
	if (loginedYN == null) {
		response.sendRedirect("../user/loginform.jsp?error=deny");
	}
%>