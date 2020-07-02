package com.simple.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simple.controller.Controller;
import com.simple.dao.UserDao;
import com.simple.vo.User;

public class LoginCheckController implements Controller {
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String userId = req.getParameter("userid");
		String userPassword = req.getParameter("password");
		
		UserDao userDao = new UserDao();
		User user = userDao.getUserById(userId);
		
		if (user == null) {
			// redirect의 경우에는 상대경로, 절대경로가 적용된다.
			// http://localhost/webmvc/login/check.hta 경로로 들어왔으므로
			// 브라우져창에는 http://localhost/webmvc/login/까지가 적혀있다
			// 재요청할 경로에는 check.hta를 대체할 주소값만 넣어주면 된다.
			return "redirect:form.hta?error=fail";
		}
		
		if (!user.getPassword().equals(userPassword)) {
			return "redirect:form.hta?error=fail";
		}
		
		// jsp에는 기본적으로 session객체가 제공되지만 java에는 session객체가 제공되지 않으므로 
		// 직접적으로 session객체를 가져와야한다.
		// 서버의 세션객체에 로그인한 사용자 정보 저장
		HttpSession session = req.getSession();
		session.setAttribute("loginUser", user);
		
		// 브라우져창에는 http://localhost/webmvc/login/까지가 적혀있다		
		return "redirect:../home.hta";
	}
}
