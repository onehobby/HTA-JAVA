<%@page import="java.util.ArrayList"%>
<%@page import="com.bookstore.util.StringUtil"%>
<%@page import="com.bookstore.dto.OrderDto"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
<style type="text/css">
	label {
		font-weight: bold;
	}
	select {
		display: inline-block;;
		width: 200px;
		height: 37px;
	}
	
</style>
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
		
			// 세션에서 조회한 회원정보로 그 회원의 주문내역을 조회한다.
			// logincheck.jsp페이지에 session에서 가져온 사용자아이디가 있기때문에 접근해서 사용할 수 있다.
			OrderDao orderDao = new OrderDao();
			List<OrderDto> orders = orderDao.getOrdersByUserid(loginedUserId);
					
		%>
		<div>
			<p><strong><%=loginedUserName %></strong>님, 주문내역을 확인하세요</p>
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
							if (orders.isEmpty()) {
						%>
							<tr>
								<td rowspan="6" style="text-align: center;">주문내역이 존재하지 않습니다.</td>
							</tr>
						<%
							} else {

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
							}
						%>
				</tbody>	
			</table>
		</div>
	</div>
</div>
</body>
</html>