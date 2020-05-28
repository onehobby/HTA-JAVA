<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String value1 = request.getParameter("value1");
	String value2 = request.getParameter("value2");
	String value3 = request.getParameter("value3");
	String value4 = request.getParameter("value4");
	
	// PageContext, HttpServletRequest, HttpSession, ServletContext객체에 속성값 담기, 속성값은 이름,객체의 형태로 담을 수 있다.
	pageContext.setAttribute("p", value1);
	request.setAttribute("r", value2);
	session.setAttribute("s", value3);
	application.setAttribute("a", value4);
	
	// PageContext, HttpServletRequest, HttpSession, ServletContext객체에 저장된 속성값 꺼내기
	String pageContextValue = (String)pageContext.getAttribute("p");
	String requestValue = (String)request.getAttribute("r");
	String sessionValue = (String)session.getAttribute("s");
	String applicationValue = (String)application.getAttribute("a");
	
	System.out.println("page4.jsp의 PageContext에 조회한 값: " + pageContextValue);
	System.out.println("page4.jsp의 HttpServletRequest에 조회한 값: " + requestValue);
	System.out.println("page4.jsp의 HttpSession에 조회한 값: " + sessionValue);
	System.out.println("page4.jsp의 ServletContext에 조회한 값: " + applicationValue);
	
	// page5.jsp로 내부이동(Forwarding)시킨다
	// RequestDispatcher는 클라이언트의 요청을 다른 jsp로 이동시키는 기능을 가진 객체다.
	RequestDispatcher dispatcher = request.getRequestDispatcher("page5.jsp");
	dispatcher.forward(request, response);
%>