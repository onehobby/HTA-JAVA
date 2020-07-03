package com.simple.service;

import com.simple.dao.UserDao;
import com.simple.vo.User;

public class UserService {

	private UserDao userDao = new UserDao();
	
	public User getUserById(String userId) throws Exception {
		
		User user = userDao.getUserById(userId);
		
		return user;
		
	}
}
