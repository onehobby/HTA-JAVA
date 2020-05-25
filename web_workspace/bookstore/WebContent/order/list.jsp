<%@page import="com.bookstore.dao.ReviewDao"%>
<%@page import="com.bookstore.dto.ReviewDto"%>
<%@page import="com.bookstore.vo.User"%>
<%@page import="com.bookstore.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.dto.OrderDto"%>
<%@page import="com.bookstore.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bookstore</title>
<link rel="stylesheet" type="text/css" href="../css/bookstore.css">
</head>
<body>
	<div class="wrapper">
		<div class="navi">
			<%
				String position = "order";
			%>
			<%@include file="../common/navibar.jsp" %>
			
			<%
				String userId = request.getParameter("userid");
							
				// 유저정보조회
				UserDao userDao = new UserDao();
				User user = userDao.getUserByUserId(userId);
				// 유저의 주문내역 조회
				OrderDao orderDao = new OrderDao();
				List<OrderDto> orders = orderDao.getOrdersByUserid(userId);
				
				%>
			
		</div>
		<div class="header">
			<h1>주문내역조회</h1>
		</div>
		<div class="body">
			<div>
				<h3><%=user.getName() %>님의 주문내역입니다.</h3>
				<p><strong>누적포인트 : <%=user.getPoint() %></strong>
			</div>
			<div>
				<table class="table">
					<thead>
						<tr>
							<th>주문번호</th>
							<th>책제목</th>
							<th>가격</th>
							<th>수량</th>
							<th>주문금액</th>
							<th>주문날짜</th>
							<th>리뷰</th>
							<th>추천</th>
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
								
								for(OrderDto order : orders) {
						%>
							<tr>
								<td><%=order.getNo() %></td>
								<td><a href="../book/detail.jsp?bookno=<%=order.getBookNo()%>"><%=order.getTitle() %></a></td>
								<td><%=order.getPrice() %></td>
								<td><%=order.getAmount() %></td>
								<td><%=order.getTotalPrice() %></td>
								<td><%=order.getRegisteredDate() %></td>
								<%
									// 리뷰체크
									
									ReviewDto reviewDto = new ReviewDto();
									reviewDto.setUserId(user.getId());
									reviewDto.setBookNo(order.getBookNo());
									
									ReviewDao reviewDao = new ReviewDao();
									ReviewDto checked = reviewDao.checkedReview(reviewDto);
								%>
								<% 
									if ("N".equals(checked.getReviewYN())) {
								%>
									<td><a href="../review/form.jsp?userid=<%=user.getId()%>&bookno=<%=order.getBookNo()%>" style= "font-weight: bold">리뷰작성하기</a></td>
								<%
									} else {
								%>
									<td style="color: #ab9;">작성완료</td>
								<%
									}
								%>
								<td><a href="../like/like.jsp=bookno=<%=order.getBookNo()%>&userid=<%=user.getId()%>">추천하러가기</a></td>
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