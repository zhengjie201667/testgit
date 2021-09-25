package web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.java.dao.UserMapper;
import com.java.entity.User;

public class TestUser {
	private InputStream inputStream;
	private SqlSession session;
	
	@Before
	public void before() {
		try {
			String resource = "mybatis-config.xml";
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void selectTest() {
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		List<User> users = userMapper.selectUser();
		for (User user : users) {
			System.out.println(user);
		}
		
	}
	
	@Test
	public void insertTest() {
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int a = userMapper.insertUser(new User(1, "", "xinde"));
		System.out.println(a);
		
	}
	
	@Test
	public void updateTest() {
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int a = userMapper.updateUser(new User(5, "xinde", "xinde"));
		System.out.println(a);
		
	}
	
	@Test
	public void deleteTest() {
		
		UserMapper userMapper = session.getMapper(UserMapper.class);
		int a = userMapper.deleteUser(7);
		System.out.println(a);
		
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
	}
}
