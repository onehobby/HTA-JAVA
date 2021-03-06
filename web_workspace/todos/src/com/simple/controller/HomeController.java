package com.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simple.dto.TodoDto;
import com.simple.service.TodoService;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class HomeController {
	
	private TodoService todoService = new TodoService();
	
	@RequestMapping("/home.hta")
	public ModelAndView todos(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		List<TodoDto> todos = todoService.getRecentTodos();
		
		mav.addAttribute("todos", todos);
		mav.setViewName("home.jsp");
		
		return mav;
		
	}

}
