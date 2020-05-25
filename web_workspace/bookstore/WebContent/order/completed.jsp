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
		<%@ include file="../common/navibar.jsp" %>
		
		<%
			String userId = request.getParameter("userid");
		%>
	</div>
	<div class="header">
		<h1>주문 완료</h1>
	</div>
	<div class="body">
		<p>주문이 완료되었습니다.</p>
		<p>주문에 대한 상세정보는 아래의 링크를 클릭하시면 확인할 수 있습니다</p>
		<p><a href="list.jsp?userid=<%=userId %>" ><strong>주문정보 확인</strong></a></p>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>