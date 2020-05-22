<%@page import="com.bookstore.dao.BookDao"%>
<%@page import="com.bookstore.vo.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

	request.setCharacterEncoding("utf-8");

	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String genre = request.getParameter("genre");
	String publisher = request.getParameter("publisher");
	int price = Integer.parseInt(request.getParameter("price"));
	int discountPrice = Integer.parseInt(request.getParameter("discountPrice"));
	int stock = Integer.parseInt(request.getParameter("stock"));
	
	Book book = new Book();
	
	book.setTitle(title);
	book.setWriter(writer);
	book.setGenre(genre);
	book.setPublisher(publisher);
	book.setPrice(price);
	book.setDiscountPrice(discountPrice);
	book.setStock(stock);
	
	BookDao bookDao = new BookDao();
	bookDao.insertNewBook(book);
	
	response.sendRedirect("list.jsp");
%>


