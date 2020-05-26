<%@page import="com.bookstore.util.StringUtil"%>
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
			String genre = request.getParameter("genre");
			String nullCheck = StringUtil.nullToBlank(genre);
			OrderDao orderDao = new OrderDao();
			List<OrderDto> orders = null;
			
			if (nullCheck.isEmpty()) {
				orders = orderDao.getAllOrdersWithUserName();
			} else {
				orders = orderDao.getAllOrdersByGenre(genre);
			}
		%>
		<div>
			<div>
			<p style="font-weight: bold">주문내역을 확인하세요</p>
				<form method="get" action="all.jsp">
					<label>구분</label>
					<select name="genre">
							<option value="" <%="".equals(genre) ? "selected" : "" %>>전체</option>
							<option value="수필" <%="수필".equals(genre) ? "selected" : "" %>>수필</option>
							<option value="인문" <%="인문".equals(genre) ? "selected" : "" %>>인문</option>
							<option value="경제" <%="경제".equals(genre) ? "selected" : "" %>>경제</option>
							<option value="자연과학/공학" <%="자연과학/공학".equals(genre) ? "selected" : "" %>>자연과학/공학</option>
							<option value="IT" <%="IT".equals(genre) ? "selected" : "" %>>IT</option>
							<option value="외국어" <%="외국어".equals(genre) ? "selected" : "" %>>외국어</option>
							<option value="교재수험서" <%="교재수험서".equals(genre) ? "selected" : "" %>>교재수험서</option>
					</select>
					<button type="submit">검색</button>
				</form>
			</div>
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