package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.UserService;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;

@Controller
public class UserController {
	
	private UserService userService = new UserService();
	
	@RequestMapping("/login/form.hta")
	public ModelAndView loginForm(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName(("user/loginform.jsp"));
		
		return mav;
		
	}
	
	@RequestMapping("/login/check.hta")
	public ModelAndView loginCheck(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		String userId = req.getParameter("userid");
		String pwd = req.getParameter("userpwd");
		
		User user = userService.getUserById(userId);
		
		if(user == null) {

			mav.setViewName("redirect:form.hta?error=fail");
			
			return mav;
		}
		
		if (!pwd.equals(user.getPassword())) {

			mav.setViewName("redirect:form.hta?error=fail");
			
			return mav;
		}
		
		HttpSession session = req.getSession();
		session.setAttribute("loginUser", user);
		
		mav.setViewName("redirect:../home.hta");
		
		return mav;
		
	}
	
	@RequestMapping("/login/out.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse rest) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		modelAndView.setViewName("redirect:../home.hta");
		
		return modelAndView;
	}
	
}
