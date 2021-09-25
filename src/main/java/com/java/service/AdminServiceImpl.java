package com.java.service;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements IAdminService{

	@Override
	public void saveAdmin(String name) {

		System.out.println("这是admin的添加方法");
		
	}

}
