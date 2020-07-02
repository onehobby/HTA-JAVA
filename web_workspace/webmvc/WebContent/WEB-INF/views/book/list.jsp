<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="../common/nav.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-12">
			<h1>List View</h1>
		</div>
	</div>
	<div class="row">
		<div class="col-12">
			<h3>전체 도서 목록</h3>
			<table class="table">
				<thead>
					<tr>
						<th>순번</th>
						<th>제목</th>
						<th>저자</th>
						<th>가격</th>
						<th>등록일</th>
						<th></th>
					</tr>				
				</thead>
				<tbody>
				<c:forEach var="books" items="${books }" varStatus="x">
					<tr>
						<td>${x.count}</td>
						<td><a href="detail.hta?bookno=${books.no }">${books.title }</a></td>
						<td>${books.writer }</td>
						<td><fmt:formatNumber value="${books.price }" />원</td>
						<td><fmt:formatDate value="${books.registeredDate }"/></td>
						<td><a href="detail.hta?bookno=${books.no }" class="btn btn-primary" >상세보기</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div class="mt-3 text-right">
				<a href="form.hta" class="btn btn-primary">새 책</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>