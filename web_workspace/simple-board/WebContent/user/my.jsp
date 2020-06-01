<%@page import="com.simple.dto.ReplyDto"%>
<%@page import="com.simple.dao.ReplyDao"%>
<%@page import="java.util.List"%>
<%@page import="com.simple.dto.BoardDto"%>
<%@page import="com.simple.dao.BoardDao"%>
<%@page import="com.simple.vo.User"%>
<%@page import="com.simple.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/logincheck.jsp" %>
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
		<%@ include file="../common/navibar.jsp" %>
	</div>
	<div class="header">
		<h1>나의 정보</h1>
	</div>
	<div class="body">
		<p><strong>홍길동</strong>님의 정보를 확인하세요</p>
		
		<div>
			<%
			
				String userId = (String)session.getAttribute("LOGINED_USER_ID");
				String userName = (String) session.getAttribute("LOGINED_USER_NAME");
				
				BoardDao boardDao = new BoardDao();
				List<BoardDto> boards = boardDao.getBoardByUserId(userId);
				
				ReplyDao replyDao = new ReplyDao();
				List<ReplyDto> replys = replyDao.getReplysByUserId(userId);
				
			%>
		
			<h3>내가 작성한 글</h3>
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
						<th class="text-center">조회수</th>
						<th class="text-center">댓글수</th>
						<th class="text-center">삭제여부</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
				<%
					for (BoardDto board : boards) {	 
				%>
					<tr>
						<td class="text-center"><%=board.getBoardNo() %></td>
						<td><a href="../board/detail.jsp?no=<%=board.getBoardNo()%>"><%=board.getBoardTitle() %></a></td>
						<td class="text-center"><%=board.getBoardHit() %></td>
						<td class="text-center"><%=board.getBoardReplyCnt() %></td>
						<td class="text-center"><%=board.getBoardDelYN() %></td>
						<td class="text-center"><%=board.getBoardCreateDate() %></td>
					</tr>
				<%
					}
				%>
				</tbody>
			</table>
		</div>
		
		<div>
			<h3>내가 작성한 댓글</h3>
			<table class="table">
				<colgroup>
					<col width="10%">
					<col width="*">
					<col width="10%">
					<col width="15%">
				</colgroup>
				<thead>
					<tr>
						<th class="text-center">번호</th>
						<th>내용</th>
						<th class="text-center">삭제여부</th>
						<th class="text-center">등록일</th>
					</tr>
				</thead>
				<tbody>
				<%
					for (ReplyDto reply : replys) {
				%>
					<tr>
						<td class="text-center"><%=reply.getReplyNo() %></td>
						<td><%=reply.getReplyContent() %></td>
						<td class="text-center"><%=reply.getReplyDelYN() %></td>
						<td class="text-center"><%=reply.getReplyCreateDate() %></td>
					</tr>
				<%
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