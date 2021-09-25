package com.java.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.java.entity.User;
import com.java.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService uerService;
	
	public void getUser() {
		
		uerService.getUserInfo(); 
	}
	
//	public void testCon() {
//		System.out.println("active");
//	}
}
