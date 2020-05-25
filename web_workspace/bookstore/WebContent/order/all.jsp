<%@page import="com.bookstore.dto.OrderDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<%
			String position = "order";
		%>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>모든 주문내역</h1>
	</div>
	<div class="body">
	
		<%
			OrderDao orderDao = new OrderDao();
			List<OrderDto> orders = orderDao.getAllOrdersWithUserName();
		%>
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>주문번호</th>
						<th>주문자명</th>
						<th>제목</th>
						<th>주문가격</th>
						<th>구매수량</th>
						<th>결재금액</th>
						<th>주문날짜</th>
					</tr>
				</thead>
				<tbody>
					<% 
						for (OrderDto order : orders) {
					%>
					<tr>
						<td><%=order.getNo() %></td>
						<td><%=order.getUserName() %></td>
						<td><a href="../book/detail.jsp?bookno=<%=order.getBookNo()%>"><%=order.getTitle() %></a></td>
						<td><%=order.getPrice() %></td>
						<td><%=order.getAmount() %></td>
						<td><%=order.getTotalPrice() %></td>
						<td><%=order.getRegisteredDate() %></td>
					</tr>
					<%
						}
					%>
				</tbody>	
			</table>
		</div>
	</div>
</div>
</body>
</html>