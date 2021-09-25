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

import com.java.dao.StudentMapper;
import com.java.dao.UserMapper;
import com.java.entity.Student;
import com.java.entity.User;

public class TestStudent {
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
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		List<Student> students = studentMapper.selectStudent();
		for (Student student : students) {
			System.out.println(student);
		}
		
	}
	
	@Test
	public void insertTest() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		int a = studentMapper.insertStudent(new Student(1, null, 22));
		System.out.println(a);
		
	}
	
	@Test
	public void updateTest() {
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		int a = studentMapper.updateStudent(new Student(5, "xinde", 3));
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
