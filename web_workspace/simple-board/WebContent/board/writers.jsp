<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Board</title>
<link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
<div class="wrapper">
	<div class="navi">
		<% String position = "board"; %>
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
	<%
		String userId = request.getParameter("userid");
	
		UserDao userDao = new UserDao();
		User user = userDao.getUser(userId);
	%>
		<h1><small style="font-weight: normal;"><%=user.getName() %></small>님의 게시글</h1>
	</div>
	<div class="body">
	<%
	
		BoardDao boardDao = new BoardDao();
		List<BoardDto> boards = boardDao.getBoardsByWriter(userId);
	%>
		<p>게시글 목록을 확인하세요</p>
		<div>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="10%">
					<col width="10%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>제목</th>
						<th class="text-center">작성자</th>
						<th class="text-center">조회수</th>
						<th class="text-center">댓글수</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
				<%
					if (boards.isEmpty()) {
				%>	
						<tr>
							<td class="text-center" colspan="6">게시글이 없습니다.</td>
						</tr>
				<%
					} else {
						for (BoardDto boardDto : boards) {
				%>
						<tr>
							<td class="text-center"><%=boardDto.getNo() %></td>
							<td><a href="hit.jsp?no=<%=boardDto.getNo()%>"><%=boardDto.getTitle() %></a></td>
							<td class="text-center"><a href="writers.jsp?userid=<%=boardDto.getWriter()%>"><%=boardDto.getWriterName() %></a></td>
							<td class="text-center"><%=boardDto.getHit() %></td>
							<td class="text-center"><%=boardDto.getReplyCnt() %></td>
							<td class="text-center"><%=boardDto.getCreateDate() %></td>
						</tr>
				<%	
						}
					}
				%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="footer">
		<%@ include file="../common/footer.jsp" %>
	</div>
</div>
</body>
</html>