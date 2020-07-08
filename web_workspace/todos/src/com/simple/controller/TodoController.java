package com.simple.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.dto.TodoDto;
import com.simple.service.TodoService;
import com.simple.util.NumberUtil;
import com.simple.util.StringUtil;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;
import kr.co.jhta.util.pagination.Pagination;

@Controller
public class TodoController {
	
	private JSONView jsonview = new JSONView();
	private TodoService todoService = new TodoService();
	
	@RequestMapping("/todo/detail.hta")
	public ModelAndView displayDetail(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int todoNo = NumberUtil.stringToInt(req.getParameter("todono"));
		
		TodoDto findTodo = todoService.getTodoDetailByTodoNo(todoNo);
		
		 HttpSession session = req.getSession();
		 
		 User user = (User) session.getAttribute("loginUser");
		 
		 if (user != null && user.getId().equals(findTodo.getUserId())) {
			 findTodo.setCanModify(true);
		 }
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAttribute("findTodo", findTodo);
		mav.setView(jsonview);
		
		return mav;
		
	}
	
	@RequestMapping("/todo/updatestatus.hta")
	public ModelAndView updateTodoStatus(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String status = req.getParameter("status");
		int todoNo = NumberUtil.stringToInt(req.getParameter("todono"));
		
		TodoDto todoDto = todoService.updateTodoStatus(todoNo, status);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAttribute("todo", todoDto);
		mav.setView(jsonview);
		
		return mav;
		
		// 요청 파라미터값 조회
		// todoService의 updateStatus(번호, 상태)를 실행하고, 변경된 정보를 반환받는다.
		// ModelAndView를 생성해서 Ajax 응답을 제공한다
		// ModelAndView에 반환값과 jsonView를 저장하고 mav를 반환한다.
		
	}
	
	@RequestMapping("/todo/list.hta")
	public ModelAndView list(HttpServletRequest req, HttpServletResponse res) throws Exception  {	
		
		ModelAndView mav = new ModelAndView();
		
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("loginUser"); 
		
		int pageNo = NumberUtil.stringToInt(req.getParameter("pageNo"), 1);
		int rows = NumberUtil.stringToInt(req.getParameter("rows"), 5);
		String status = StringUtil.nullToValue(req.getParameter("status"), "전체");
		String keyword = StringUtil.nullToBlank(req.getParameter("keyword"));
		
		Map<String, Object> map = todoService.getTodoList(user.getId(), pageNo, rows, status, keyword);
		Pagination pagination = (Pagination) map.get("pagination");
		List<TodoDto> todos = (List<TodoDto>)map.get("todos");
		
		mav.addAttribute("todos", todos);
		mav.addAttribute("pagination", pagination);
		mav.setViewName("todos.jsp");	
		
		return mav;
	}
	

}
