package com.sample.bookstore.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.sample.bookstore.dao.AnswerDAO;
import com.sample.bookstore.dao.BookDAO;
import com.sample.bookstore.dao.OrderDAO;
import com.sample.bookstore.dao.QuestionDAO;
import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.vo.Answer;
import com.sample.bookstore.vo.Book;
import com.sample.bookstore.vo.Order;
import com.sample.bookstore.vo.Question;
import com.sample.bookstore.vo.User;

/**
 * 회원가입, 책검색, 책 상세정보 조회, 주문하기, 내 주문 조회하기, 주문 상세정보보기 등의
 * 기능을 제공하는 객체다.
 * @author JHTA
 *
 */
public class BookstoreService {

	private UserDAO userDao = new UserDAO();
	private BookDAO bookDao = new BookDAO();
	private OrderDAO orderDao = new OrderDAO();
	private QuestionDAO questionDao = new QuestionDAO();
	private AnswerDAO answerDao = new AnswerDAO();
	
	/**
	 * 신규 사용자 정보를 등록한다.
	 * @param user 신규 사용자정보
	 * @return 회원가입이 성공하면 true를 반환한다.
	 * @throws Exception
	 */
	public boolean 회원가입(User user) throws Exception {
		User savedUser = userDao.getUserById(user.getId());
		if (savedUser != null) {
			return false;
		}
		// 비밀번호 암호화
		String md5Password = DigestUtils.md5Hex(user.getPassword());
		user.setPassword(md5Password);
		
		userDao.addUser(user);
		return true;
	}
	
	/**
	 * 지정된 키워드가 제목에 포함된 책정보를 반환한다.
	 * @param title 검색 키워드
	 * @return 검색된 책들
	 */
	public List<Book> 도서검색(String title) throws Exception {
		return bookDao.getBooksByTitle(title);
	}
	
	/**
	 * 지정된 책번호에 해당하는 책정보를 반환한다.
	 * @param bookNo 조회할 책번호
	 * @return 책정보, 유효한 번호가 아닌경우 null이 반환된다.
	 * @throws Exception
	 */
	public Book 도서상세정보(int bookNo) throws Exception {
		return bookDao.getBookByno(bookNo);
	}
	
	/**
	 * 주문요청을 처리합니다.
	 * @param userId 주문자 아이디
	 * @param bookNo 주문할 책 번호
	 * @param amount주문 수량
	 * @return 주문성공시 true를 반환한다.
	 */
	public boolean 주문하기(String userId, int bookNo, int amount) throws Exception {
		User user = userDao.getUserById(userId);
		if (user == null) {	// 회원정보가 없음
			return false;
		}
		Book book = bookDao.getBookByno(bookNo);
		if (book == null) { // 해당하는 번호에 대한 책이없음
			return false;
		}
		if (book.getStock() < amount) {
			return false;	// 재고가 부족함
		}
		
		Order order = new Order();
		order.setUser(user);
		order.setBook(book);
		order.setAmount(amount);
		order.setPrice(book.getDiscountPrice());
		
		// 주문정보 저장
		orderDao.addOrder(order);
		
		// 책 재고 변경
		book.setStock(book.getStock() - amount);
		bookDao.updateBook(book);
		
		// 사용자 포인트 변경
		int depositPoint = (int) (book.getDiscountPrice() * amount * 0.03);
		user.setPoint(user.getPoint() + depositPoint);
		userDao.updateUser(user);
		
		return true;
		
	}
	
	/**
	 * 지정된 사용자아이디의 모든 주문내역을 반환한다.
	 * @param userId 주문내역을 조회할 사용자 아이디
	 * @return 주문내역정보, 주문내역이 없는 경우 empty List가 반환된다.
	 */
	public List<Order> 내주문조회(String userId) throws Exception  {
		return orderDao.getOrdersByUserId(userId);
		
	}
	
	/**
	 * 지정된 주문번호에 해당하는 주문정보를 반환한다.
	 * @param orderNo 주문정보를 조회할 주문번호
	 * @return 주문정보 상세내역, 주문번호가 틀린 경우 null이 반환된다.
	 */
	public Order 주문상세정보(int orderNo) throws Exception {
		
		return orderDao.getOrderByNo(orderNo);
	}
	
	public List<Question> 모든질문조회() throws Exception {
		return questionDao.getAllQuestions();
	}
	
	public Question 문의글조회(int questionNo) throws Exception {
		Question savedQuestion = questionDao.getQuestionByNo(questionNo);
		// 문의글 조회
		// 조회수증가
		if (savedQuestion == null) {
			return null;
		}
		Answer savedAnswered = answerDao.getAnswer(questionNo);
		if (savedAnswered == null) {
			return null;
		}
		savedQuestion.setAnswer(savedAnswered);
		return savedQuestion;
		
	}
	
	
	public boolean 문의등록(String userId, Question question) throws Exception {
		User savedUser = userDao.getUserById(userId);
		if (savedUser == null) {
			return false;
		}
		question.setUser(savedUser);
		questionDao.addQuestion(question);
		
		return true;
	}
	
	public boolean 문의글삭제(int questionNo, String userId) throws Exception {
		// 질문글 조회
		// 질문글이 null 아니면
		//      답변이 없고, 질문글의 작성자와 userId가 동일하면 삭제가능
		
		boolean isremoved = false; 
		
		Question question = questionDao.getQuestionByNo(questionNo);
		
		if(question == null) {
			isremoved =  false;
		}
		
		if(question.getAnswer() == null || question.getUser().getId() == userId) {
			questionDao.removeQuestion(questionNo);
			isremoved = true;
		}
		
		return isremoved;
	
	}
	
	public void 답변등록(int questionNo, String content) throws Exception {
		
		Answer answer = new Answer();
		
		answer.setQuestionNo(questionNo);
		answer.setContent(content);
		answerDao.addAnswer(answer);
		
	}
}
