package web;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.java.controller.UserController;
import com.java.dao.UserMapper;
import com.java.entity.Dog;
import com.java.entity.User;
import com.java.service.IAdminService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class TestFirst {
//	@Autowired
//	private UserMapper userMapper;
	@Autowired
	private UserController userController;
	
	@Test
	public void testBean() {
		
//		List<User> users = userMapper.selectUser();
//		for (User user : users) {
//			System.out.println(user);
//		}
//		System.out.println(user);
//		ApplicationContext context = new
//				ClassPathXmlApplicationContext("application.xml");
//				UserMapper mapper = (UserMapper) context.getBean("userMapper");
//				List<User> users = userMapper.selectUser();
//				for (User user : users) {
//				System.out.println(user);
//				}
		userController.getUser();
	}

}
