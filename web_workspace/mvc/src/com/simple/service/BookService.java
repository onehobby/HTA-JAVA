package com.simple.service;

import java.util.List;

import com.simple.dao.BookDao;
import com.simple.dao.ReviewDao;
import com.simple.dto.BookDetailDto;
import com.simple.vo.Book;
import com.simple.vo.Review;

public class BookService {

	private BookDao bookDao = new BookDao();
	private ReviewDao reviewDao = new ReviewDao();
	
	
	// 최근 등록된 책정보 3개를 제공하는 서비스
	public List<Book> getRecentBooks() throws Exception {
		
		List<Book> recentBooks = bookDao.getRecentBooks();
		
		return recentBooks;
	}
	
	// 모든 책정보를 제공하는 서비스
	public List<Book> getAllBooks() throws Exception {
		
		List<Book> books = bookDao.getAllBooks();
		return books;
	}
	
	// 책에대한 상세정보를 제공하는 서비스
	public BookDetailDto getBookDetailInfo(int bookNo) throws Exception {
		
		Book book = bookDao.getBookByNo(bookNo);
		List<Review> reviews = reviewDao.getReviewsByBookNo(bookNo);
		
		BookDetailDto bookDetailDto = new BookDetailDto();
		bookDetailDto.setBook(book);
		bookDetailDto.setReviews(reviews);
		
		return bookDetailDto;
	}
	
	public void insertBook(Book book) throws Exception {
		
		bookDao.insertBook(book);
		
	}
	
}
