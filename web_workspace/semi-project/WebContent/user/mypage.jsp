<%@page import="semi.dto.OrderDto"%>
<%@page import="semi.dao.OrderDao"%>
<%@page import="semi.dto.BucketDto"%>
<%@page import="semi.dao.BucketDao"%>
<%@page import="semi.vo.User"%>
<%@page import="semi.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Bootstrap 4 Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	
<% 
	String loginedUserId = (String) session.getAttribute("아이디");

	UserDao userDao = new UserDao();
	
	User finduser = userDao.getUserById(loginedUserId);
	
%>
<%@ include file="/common/loginProcess.jsp" %>
<%@ include file="../common/navibar.jsp" %>
<%@ include file="/common/fixedbar.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-12">
			<div class="navi text-center" >
    		</div>
		</div>
	</div>
    	<div class="row">
    		<div class="col-12">
    			<div class="header text-center">
    				<div class="row">
    					<div class="col-12 pb-3 h2">
    						MyPage
    					</div>
    				</div>
    				<div class="row">
    					<div class="col-12 pb-3">
    						<div class="row">
    							<div class="col-3"></div>
    							<div class="col-6">
    								<div class="row">
    									<div class="col-6 my-auto">
    										<strong><%=finduser.getName() %></strong>님의 마이페이지
    									</div>
    									<div class="col-6">
											<div class="row">
												<div class="col-12"><a class="text-dark" href="../user/pointHistory.jsp">
													<strong>보유포인트</strong>
												</a></div>
											</div>
											<div class="row">
												<div class="col-12">
													<%=finduser.getPoint() %>
												</div>
											</div>    									
    									</div>
    								</div>
    							</div>
    							<div class="col-3"></div>
    						</div>
    					</div>
    				</div>
    			</div>
    		</div>	
    	</div>
   	<div class="row">
   		<div class="col-12">
   			<div class="body">
			   	<div class="row">
			   		<div class="col-3"></div>
			   		<div class="col-6">
						<table class="table">
							<tr class="text-center h4">
								<th width="33.3%"><a style="color: black;" href="../order/orderList.jsp">Order</a></th>
								<th width="33.3%"><a style="color: black;" href="../board/notice.jsp">notice</a></th>
								<th width="33.3%"><a style="color: black;" href="../user/profile.jsp">Profile</a></th>
						    </tr>
						</table>
			   		</div>
			   		<div class="col-3"></div>
			   	</div>
			   	<div class="row">
			   		<div class="col-3"></div>
			   		<div class="col-6">
			   			<table class="table table-bordered">
						  <thead>
						    <tr>
						      <th scope="col" colspan="4" class="text-center h4">주문현황<label class="h6"></label></th>
						    </tr>
						  </thead>
						  <tbody>
						  <% 
								BucketDao bucketDao = new BucketDao();
						  		BucketDto bucketDto = bucketDao.findbucketCountByloginedId(loginedUserId);
						  		
						  		OrderDao orderDao = new OrderDao();
						  		OrderDto orderDto = orderDao.findOrderBeforeDeliveryCountByloginedId(loginedUserId);
						  		
						  		OrderDto orderDtoComplete = orderDao.findOrderDeliveryCompleteCountByloginedId(loginedUserId);
						  		
						  		OrderDto orderDtoRefund = orderDao.findRefundByloginedId(loginedUserId);
						  		
						  		
						  %>
						    <tr class="text-center">
								<th width="25%">장바구니</th>
								<th width="25%">배송준비중</th>
								<th width="25%">배송완료</th>
								<th width="25%">환불</th>
						    </tr>
						    <tr class="text-center">
						    <%
								if (bucketDto == null) {
						    %>
								<td width="25%"><div>0</div></td>
						    <% 
						  	 	 } else {
						    %>
								<td width="25%"><div><%=bucketDto.getConut() %></div></td>
						    <% 
						   	 	}
						    
						    	if (orderDto == null) {
						    %>
								<td width="25%"><div>0</div></td>
						    <% 
						    	} else {
						    %>
								<td width="25%"><div><%=orderDto.getCount() %></div></td>
						    <% 
						    	}
						    	
						    	if (orderDtoComplete == null) {
						    %>
								<td width="25%"><div>0</div></td>
						    <%
						    	} else {
						    %>
								<td width="25%"><div><%=orderDtoComplete.getCount() %></div></td>
							<% 
						    	}

						    	if (orderDtoRefund == null) {
							%>
								<td width="25%"><div>0</div></td>
							<% 
						    	} else {
							%>
								<td width="25%"><div><%=orderDtoRefund.getCount() %></div></td>
							<%
						    	}
							%>
						    </tr>
						  </tbody>
						</table>
			   		</div>
			   		<div class="col-3"></div>
			   	</div>
			   	<% 
			   		if (bucketDto != null || orderDto != null || orderDtoComplete != null) {
			   	%>
			   	<div class="row">
			   		<div class="col-3"></div>			   	
			   		<div class="col-6">
			   			<table class="table table-bordered">
						  <thead>
						    <tr>
						    </tr>
						  </thead>
						  <tbody>
						    <tr class="text-center">
								<th width="50%"><a href="../order/bucket.jsp"><button class="btn btn-primary">장바구니 바로가기</button></a></th>
								<th width="50%"><a href="../order/orderList.jsp"><button class="btn btn-primary">주문내역 바로가기</button></a></th>
						    </tr>
						  </tbody>
						</table>
			   		</div>		   	
			   		<div class="col-"></div>			   	
			   	</div>
			   	<% 
			   		}
			   	%>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<%@ include file="../common/footer.jsp" %>
		</div>
	</div>
</div>
</body>
</html>