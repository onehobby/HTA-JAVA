<%@page import="com.bookstore.dto.ReviewDto"%>
<%@page import="com.bookstore.dao.ReviewDao"%>
<%@page import="com.bookstore.dto.BookDetailDto"%>
<%@page import="com.bookstore.dao.BookDao"%>
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
			<%@ include file="../common/navibar.jsp" %>
		</div>
		<div class="header">
			<h1>책 상세정보</h1>
		</div>
		<div class="body">
			<%
				int bookNo = Integer.parseInt(request.getParameter("bookno"));
			
				BookDao bookDao = new BookDao();
				BookDetailDto book = bookDao.getBookByNo(bookNo);
				
				ReviewDao reviewDao = new ReviewDao();
				ReviewDto review = reviewDao.getReviewByBookNo(bookNo);
				
			%>
			<div>
				<h3>책의 상세정보</h3>
				<table class="table">
					<tr>
						<th>제목</th>
						<td colspan="3"><%=book.getTitle() %></td>
					</tr>
					<tr>
						<th>저자</th>
						<td><%=book.getWriter() %></td>
						<th>출판사</th>
						<td><%=book.getPublisher() %></td>
					</tr>
					<tr>
						<th>평점</th>
						<td><%=book.getPoint() %></td>
						<th>리뷰개수</th>
						<td><%=book.getReviewCnt() %></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><%=book.getPrice() %></td>
						<th>할인가격</th>
						<td><%=book.getDiscountPrice() %></td>
					</tr>
					<tr>
						<th>추천수</th>
						<td><%=book.getLikes() %></td>
						<th>재고</th>
						<td><%=book.getStock() %></td>
					</tr>
				</table>
			</div>
			
			<div>
				<h3>이 책의 리뷰</h3>
				<table class="table">
					<tbody>
						<tr>
							<th>리뷰번호</th>
							<td><%=review.getNo() %></td>
							<th>작성자</th>
							<td><%=review.getUserName() %></td>
							<th>평점</th>
							<td><%=review.getPoint() %></td>
							<th>작성일</th>
							<td><%=review.getRegisteredDate() %></td>
						</tr>
						<tr>
							<td colspan="6"><%=review.getContent() %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<%@ include file="../common/footer.jsp" %>
	</div>
</body>
</html>