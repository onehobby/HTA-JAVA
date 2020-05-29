<%@page import="com.bookstore.dao.OrderDao"%>
<%@page import="com.bookstore.vo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<% 
	// 책번호, 구매가격, 구매수량, 사용자 아이디 조회하기
	
	request.setCharacterEncoding("utf-8");
	
	int price = Integer.parseInt(request.getParameter("price"));
	int amount = Integer.parseInt(request.getParameter("amount"));
	int bookNo = Integer.parseInt(request.getParameter("bookno"));
	// String userId = request.getParameter("userid");
	
	// Order객체를 생성해서 위에서 획득한 정보 저장하기
	Order order = new Order();
	order.setUserId(loginedUserId);
	order.setBookNo(bookNo);
	order.setPrice(price);
	order.setAmount(amount);
	
	//OrderDao객체를 생성해서 insertNewOrder를 이용해 DB에 데이터 저장하기
	OrderDao orderDao = new OrderDao();
	orderDao.insertNewOrder(order);
	
	// 작업이 완료된 후 되돌아갈 페이지 보내기
	response.sendRedirect("completed.jsp");
	
	
	//
%>

