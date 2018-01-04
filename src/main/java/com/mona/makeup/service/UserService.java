package com.mona.makeup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mona.makeup.dao.UserDao;
import com.mona.makeup.pojo.User;
import com.mona.makeup.utils.MD5Util;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User login(User user){
		String password=user.getPassword();
		password = MD5Util.md5Hex(password);
		User login = userDao.login(user);
		return login;
	}
}
