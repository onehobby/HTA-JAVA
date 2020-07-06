package com.simple.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.service.UserService;
import com.simple.vo.User;

import kr.co.jhta.mvc.annotation.Controller;
import kr.co.jhta.mvc.annotation.RequestMapping;
import kr.co.jhta.mvc.servlet.ModelAndView;
import kr.co.jhta.mvc.view.JSONView;

@Controller
public class UserController {
	
	private JSONView jsonview = new JSONView();
	private UserService userService = new UserService();
	
	@RequestMapping("/register.hta")
	public ModelAndView registerUser(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String name = req.getParameter("name");
		String id =  req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		User user = new User();
		
		user.setId(id);
		user.setPassword(pwd);
		user.setName(name);
		user.setEmail(email);
		
		Boolean joinCheck = userService.addNewUser(user);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAttribute("result", joinCheck);
		mav.setView(jsonview);	// 클라이언트에 jsonText 응답을 제공
								// jsonview 객체를  view에 담으면 result에 담긴 값이 json의 형태로 클라이언트에게 응답으로 제공된다.
								// {"result":true} 혹은 {"result":false} JSON 텍스트가 응답으로 제공된다.
		
		return mav;
		
	}
	
	@RequestMapping("/login.hta")
	public ModelAndView login(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청파라미터 정보를 조회한다.
		// UserService의 loginCheck(String id, String password)를 실행한다.
		// 반환값이 null이면 ModelAndView에 result -> false를 저장한다
		// 반환값이 null이 아니면 ModelAndView에 result -> true를 저장한다
		//					HttpSession객체를 획득해서 "loginUser"라는
		//					속성명으로 사용자정보를 세션에 저장한다.
		
		String userId = req.getParameter("id");
		String userPwd = req.getParameter("pwd");
		
		User findUser = userService.loginCheck(userId, userPwd);
		
		ModelAndView mav = new ModelAndView();
		
		if (findUser == null) {
			mav.addAttribute("result", false);
			mav.setView(jsonview);
			
		} else if (findUser != null) {
			mav.addAttribute("result", true);
			mav.setView(jsonview);
			HttpSession session = req.getSession();
			session.setAttribute("loginUser", findUser);
			
		}
		
		return mav;
	}
	
	@RequestMapping("/logout.hta")
	public ModelAndView logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/home.hta"); // 현재 URL상태와 상관없이 로그아웃을 누르면 절대경로로 요청을 보낸다. 
		return mav;
		
	}

	
}
