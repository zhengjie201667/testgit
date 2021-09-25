package com.java.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.java.entity.User;


public interface UserMapper {

	List<User> selectUser();
	
	int insertUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(int id);
}
