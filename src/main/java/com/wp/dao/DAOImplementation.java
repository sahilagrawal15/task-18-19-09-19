package com.wp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.wp.dao.DAO;
import com.wp.entities.Student;

@Repository
public class DAOImplementation implements DAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	//@Override
	public void addStudent(Student student) {
		
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(student);
		tr.commit();
		session.close();
		
	}
	//@Override
	public void deleteStudent(int id) {
	
		Session session=sessionFactory.openSession();
		Student student=session.get(Student.class, id);
		Transaction tr=session.beginTransaction();
		
		session.delete(student);
		tr.commit();
		
		session.close();
		
		
	}
	
	//@Override
	public void updateStudent(Student student) {
		
		Session session=sessionFactory.openSession();
		
		Transaction tr=session.beginTransaction();
		
		session.update(student);
		tr.commit();
		session.close();
	}

	//@Override
	public Student searchStudent(int id) {
		Session session=sessionFactory.openSession();
		Student student=session.get(Student.class, id);
		session.close();
		return student;
	}

	//@Override
	public List<Student> viewAll() {
		Session session=sessionFactory.openSession();
		Criteria cr=session.createCriteria(Student.class);
		List<Student> students=cr.list();
		session.close();
		return students;
	}

}
