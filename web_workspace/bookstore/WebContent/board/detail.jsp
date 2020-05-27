<%@page import="com.bookstore.vo.Reply"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.util.StringUtil"%>
<%@page import="com.bookstore.dto.BoardDto"%>
<%@page import="com.bookstore.dao.BoardDao"%>
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
		<h1>게시글 정보</h1>
	</div>
	<div class="body">
	
	<%
		int boardNo = Integer.parseInt(request.getParameter("boardno"));
	
		BoardDao boardDao = new BoardDao();
		BoardDto boardDto = boardDao.getpostByBoardNo(boardNo);
	%>
		<div>
			<p>게시글의 내용을 확인하세요.</p>
			<table class="table bordered">
				<colgroup>
					<col width="10%">
					<col width="40%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=boardDto.getTitle() %></td>
					</tr>
					<tr>
						<th>작성자</th>
						<td><%=boardDto.getWriter() %></td>
						<th>등록일</th>
						<td><%=boardDto.getRegisteredDate() %></td>
					</tr>
					<tr>
						<th>조회수</th>
						<td><%=boardDto.getHit() %></td>
						<th>댓글개수</th>
						<td><%=boardDto.getRpCount() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<%=boardDto.getContent() %>
						</td>
					</tr>
				</tbody>
			</table>
			<hr>
			<div class="text-right">
				<a href="modifyform.jsp?boardno=<%=boardNo%>"><strong>[수정]</strong></a>
				<a href="delete.jsp?boardno=<%=boardNo%>"><strong>[삭제]</strong></a>
				<a href="all.jsp"><strong>[목록으로 가기]</strong></a>
			</div>
		</div>
		<div>
		
			<%
			 // 댓글정보조회
			List<Reply> replys = boardDao.getReplysByBoardNo(boardNo);
			%>
			<div>
				<p>댓글을 확인하세요</p>
				<table class="table">
					<colgroup>
						<col width="10%">
						<col width="40%">
						<col width="10%">
						<col width="40%">
					</colgroup>
					<%
						if(replys.isEmpty()) {
					%>
						<tr>
							<td>등록된 댓글이 존재하지 않습니다.</td>
						</tr>
					<%
						} else {
							
							for (Reply reply : replys) {
					%>
					<tr>
						<th>작성자</th>
						<td><%=reply.getWriter() %></td>
						<th>등록일</th>
						<td><%=reply.getRegistered_date() %></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<%=StringUtil.strWithBr(reply.getContent()) %>
						</td>
					</tr>
					<%
							}
						}
					%>
				</table>
			</div>
			<div class="well">
				<form method="post" action="registerreply.jsp">
					<div class="form-group">
						<label>작성자</label>
						<div><input type="text" name="writer" /></div>
					</div>
					<div class="form-group">
						<label>내용</label>
						<div><textarea rows="4" name="content"></textarea> </div>
					</div>
					<div class="text-right">
						<button type="submit">등록</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>