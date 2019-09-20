package com.wp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Student;

@Repository
public interface DAO {

	public void addStudent(Student student);
	public void deleteStudent(int id);
	public void updateStudent(Student student);
	public Student searchStudent(int id);
	public List<Student> viewAll();
}
