package com.simple.service;

import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	private User getUserById(String userId) throws Exception {
		User user = userDao.getUserById(userId);
		return user;
	
	}
	
	private void insertUser(User user) throws Exception {
		userDao.insertUser(user);
		
	}
	
	public Boolean addNewUser(User user) throws Exception {
		
		User findUser = this.getUserById(user.getId());
		
		if (findUser != null) {
			return false;
			
		} else {			
			this.insertUser(user);
			return true;
		}
	}
	
	public User loginCheck(String id, String password) throws Exception {
		// 전달받은 아이디로 사용자 정보를 조회한다.
		// 사용자 정보가 존재하지 않으면 null 반환
		// 비밀번호가 일치하지 않으면 null 반환
		// 그 외는 조회된 사용자 정보를 반환한다.
		
		User findUser = this.getUserById(id);
		
		if (findUser == null) {
			return findUser;
			
		} else if (!password.equals(findUser.getPassword())) {
			findUser = null;
			return findUser;
			
		} else {
			return findUser;
		}
		
	}
	
}
