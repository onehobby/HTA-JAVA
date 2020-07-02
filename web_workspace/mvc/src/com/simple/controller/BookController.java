package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dao.BookDao;
import com.simple.dao.ReviewDao;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;
import com.simple.vo.Review;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class BookController {

	@RequestMapping("/book/list.hta") // 요청 URI를 RequestMapping()에 적어놓으면 해당되는 요청이 왔을 때 매핑되는 메소드를 실행시킨다.
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		BookDao bookDao = new BookDao();
		List<Book> books = bookDao.getAllBooks();
		
		mav.setViewName("book/list.jsp");	// 이동할 뷰페이지 이름
		mav.addAttribute("books", books);	// 뷰페이지에 전달할 데이터
		
		return mav;
	}
	
	@RequestMapping("/book/detail.hta")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		BookDao bookDao = new BookDao();
		ReviewDao reviewDao = new ReviewDao();
		
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		Book book = bookDao.getBookByNo(bookNo);
		List<Review> reviews = reviewDao.getReviewsByBookNo(bookNo);
		
		mav.setViewName("book/detail.jsp");	// 이동할 뷰페이지 이름
		mav.addAttribute("book", book);
		mav.addAttribute("reviews", reviews);
		
		return mav;
	}
	
}
