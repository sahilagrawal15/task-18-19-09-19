package com.wp.services;

import java.util.List;



import com.wp.entities.Student;

public interface StudentService {
	
	
	public void addStudent(Student student);
	public void deleteStudent(int id);
	public void updateStudent(Student student);
	public Student searchStudent(int id);
	public List<Student> viewAll();
}

