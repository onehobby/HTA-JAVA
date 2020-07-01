package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;

public class DetailController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("DetailController.process(req, res) 실행됨");
		
		// 요청파라미터 정보 조회하기
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		// 전달받은 책번호에 해당하는 책 정보 획득하기
		BookDao bookDao = new BookDao();
		Book book = bookDao.getBookByNo(bookNo);
		
		// 책정보를 뷰페이지에 전달하기위해서 Request에 속성으로 저장하기
		req.setAttribute("book", book);
		
		// 내부이동할 뷰페이지 이름 반환하기
		return "detail.jsp"; 
	}
}
