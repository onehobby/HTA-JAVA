package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dto.BookDetailDto;
import com.simple.service.BookService;
import com.simple.util.NumberUtil;
import com.simple.vo.Book;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class BookController {
	
	private BookService bookService = new BookService();

	@RequestMapping("/book/list.hta") // 요청 URI를 RequestMapping()에 적어놓으면 해당되는 요청이 왔을 때 매핑되는 메소드를 실행시킨다.
	public ModelAndView list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		List<Book> books = bookService.getAllBooks();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/list.jsp");	// 이동할 뷰페이지 이름
		mav.addAttribute("books", books);	// 뷰페이지에 전달할 데이터
		
		return mav;
	}
	
	@RequestMapping("/book/detail.hta")
	public ModelAndView detail(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		int bookNo = NumberUtil.stringToInt(req.getParameter("bookno"));
		
		BookDetailDto bookDetailDto = bookService.getBookDetailInfo(bookNo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("book/detail.jsp");	// 이동할 뷰페이지 이름
		mav.addAttribute("book", bookDetailDto.getBook());
		mav.addAttribute("reviews", bookDetailDto.getReviews());
		
		return mav;
	}
	
	@RequestMapping("/book/form.hta")
	public ModelAndView form(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("book/form.jsp");
		
		return mav;
		
	}
	
	@RequestMapping("/book/add.hta")
	public ModelAndView insert(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String publisher = req.getParameter("publisher");
		String genre = req.getParameter("genre");
		int price = NumberUtil.stringToInt(req.getParameter("price"));
		int discountPrice = NumberUtil.stringToInt(req.getParameter("discountPrice"));
		
		Book book = new Book();
		
		book.setTitle(title);
		book.setWriter(writer);
		book.setPublisher(publisher);
		book.setGenre(genre);
		book.setPrice(price);
		book.setDiscountPrice(discountPrice);
		
		bookService.insertBook(book);
		
		mav.setViewName("redirect:list.hta");
		
		return mav;
		
	}
	
}
