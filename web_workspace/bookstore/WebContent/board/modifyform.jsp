<%@page import="com.bookstore.dto.BoardDto"%>
<%@page import="com.bookstore.dao.BoardDao"%>
<%@page import="com.bookstore.util.NumberUtil"%>
<%@page import="com.bookstore.util.StringUtil"%>
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
			String position = "board";
		%>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>게시글 수정</h1>
	</div>
	<div class="body">
		<%
			int boardNo = NumberUtil.stringToInt(request.getParameter("boardno"));
			String error = request.getParameter("error");
			
			BoardDao boardDao = new BoardDao();
			BoardDto boardDto = boardDao.getpostByBoardNo(boardNo);
			
		%>
		
		<p>게시글 정보확인하고 수정하세요.</p>
		<div class="well">
			<form method="post" action="update.jsp">
				<input type="hidden" name="no" value="<%=boardDto.getNo() %>" />
				<div class="form-group">
					<label>제목</label>
					<div><input type="text" name="title" value="<%=boardDto.getTitle()%>"/></div>
				</div>
				<div class="form-group">
					<label>작성자</label>
					<div><input type="text" name="writer" value="<%=boardDto.getWriter()%>"/></div>
				</div>
				<div class="form-group">
					<label>내용</label>
					<div><textarea rows="6" name="content"><%=boardDto.getContent() %></textarea> </div>
				</div>
				<div class="form-group">
					<label>비밀번호</label>
					<div><input type="password" name="password" maxlength="4"/></div>
				</div>
				<div class="text-right">
					<button type="submit">수정</button>
				</div>
			</form>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</div>
</body>
</html>