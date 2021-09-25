package com.java.dao;

import org.springframework.stereotype.Repository;

import com.java.entity.User;

@Repository
public class UserDaoImpl implements IUserDao{

	@Override
	public void getUserById() {
		
		System.out.println("this is dao");
	}

}
