<%@page import="com.bookstore.dto.BoardDto"%>
<%@page import="com.bookstore.dao.BoardDao"%>
<%@page import="com.bookstore.util.NumberUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%
 		request.setCharacterEncoding("utf-8");
 
 		int boardNo = NumberUtil.stringToInt(request.getParameter("no"));
 		String title = request.getParameter("title");
 		String writer = request.getParameter("writer");
 		String content = request.getParameter("content");
 		int password = NumberUtil.stringToInt(request.getParameter("password"));
 		
 		BoardDao boardDao = new BoardDao();
 		BoardDto boardDto = boardDao.getpostByBoardNo(boardNo);
 		
 		if (password != boardDto.getPassword()) {
 			response.sendRedirect("modifyform.jsp?boardno=" + boardNo+ "&error=pwd");
 		} else {
 			BoardDto boardDtoTwo = new BoardDto();
 			boardDtoTwo.setNo(boardNo);
 			boardDtoTwo.setTitle(title);
 			boardDtoTwo.setWriter(writer);
 			boardDtoTwo.setContent(content);
 			
 			boardDao.updateBoardFromBoardPWD(boardDtoTwo);
 			
 			response.sendRedirect("detail.jsp?boardno=" + boardNo);
 		}
 		
 %>