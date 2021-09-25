package com.java.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java.dao.IUserDao;
import com.java.entity.User;

@Service
public class UserServiceImpl implements IUserService{



	@Resource
	private IUserDao userDao;
	
	@Override
	public void getUserInfo() {
		
		userDao.getUserById();
	}

}
