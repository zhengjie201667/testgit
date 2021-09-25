package com.java.dao;

import java.util.List;

import com.java.entity.Student;

public interface StudentMapper {
	
	List<Student> selectStudent();
	
	int insertStudent(Student student);
	
	int updateStudent(Student student);
	
	int deleteStudent(int id);

}
