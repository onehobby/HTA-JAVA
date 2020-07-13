<%@page import="semi.dao.OrderDao"%>
<%@page import="semi.vo.Order"%>
<%@page import="semi.vo.PointHistory"%>
<%@page import="semi.dao.PointHistoryDao"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@page import="semi.dao.DeliverDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");
	int orderNo = Integer.parseInt(request.getParameter("order"));
	int price = Integer.parseInt(request.getParameter("price"));
	String userId = request.getParameter("userid");
	
	DeliverDao deliDao = new DeliverDao();
	deliDao.delivered(orderNo);
	OrderDao orderDao = new OrderDao();
	Order order = orderDao.getOrderByNO(orderNo);
	
	
	UserDao userDao = new UserDao();
	User user = new User();
	user.setUserId(userId);
	user.setPoint(price/100 + userDao.getUserById(userId).getPoint());
	user.setTotalOrderPrice(order.getPrice() + userDao.getUserById(userId).getTotalOrderPrice());
	userDao.updatePoint(user);
	userDao.updateTotalOrderPrice(user);
	
	PointHistoryDao pointDao = new PointHistoryDao();
	PointHistory history = new PointHistory();
	history.setUserId(userId);
	history.setReason("적립");
	history.setChange(price/100);
	history.setOrderNo(orderNo);
	pointDao.insertHistory(history);
%>