package com.java.entity;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
	@Value("1")
	private int id;
	private String username;
	private String password;
	
	public static void main(String[] args) {
		User user = new User();
		System.out.println(user);
	}
	
	
}
