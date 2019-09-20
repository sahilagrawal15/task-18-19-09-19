package com.wp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.dao.DAO;
import com.wp.entities.Student;

@Service
public class ServiceImplementation implements StudentService{
	
	@Autowired
	private DAO dao;
	

	public void addStudent(Student student) {
		
		dao.addStudent(student);
		
	}

	public void deleteStudent(int id) {
		
		dao.deleteStudent(id);
		
	}

	public void updateStudent(Student student) {
		
		dao.updateStudent(student);
			
	}

	public Student searchStudent(int id) {
		
		Student student=dao.searchStudent(id);
		return student;
		
			}

	public List<Student> viewAll() {
		
		List<Student> list=new ArrayList<Student>();
		list=dao.viewAll();
		
		return list;
			}
	
	
	

}
