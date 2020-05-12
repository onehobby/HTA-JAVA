package com.sample.bookstore.app;

import java.io.IOException;

import com.sample.bookstore.dao.UserDAO;
import com.sample.bookstore.util.KeyboardUtil;
import com.sample.bookstore.vo.User;

public class BookStoreUserApp {

	public static void main(String[] args) throws Exception {
		int menuNo = KeyboardUtil.nextInt();
		UserDAO userDao = new UserDAO();
		
		if(menuNo == 1) {

			String id = KeyboardUtil.nextString();
			String password = KeyboardUtil.nextString();
			String name = KeyboardUtil.nextString();
			String email = KeyboardUtil.nextString();

			User user = new User();
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);

			userDao.addUser(user);
			
		} else if (menuNo == 2) {
			
			String userId = KeyboardUtil.nextString();
			
			User user = userDao.getUserById(userId);
			
			if(user == null) {
				System.out.println("아이디가 존재하지 않습니다");
			} else {
				System.out.println(user.getId());
				System.out.println(user.getName());
				System.out.println(user.getPassword());
				System.out.println(user.getEmail());
				System.out.println(user.getPoint());
			}
			
		}
		
		
	}
}
