package com.wp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entities.Student;
import com.wp.services.StudentService;


@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("add")
	public String insertData()
	{
		return "insert";
	}
	@RequestMapping("delete")
	public String deleteData()
	{
		return "remove";
	}
	@RequestMapping("update")
	public String updateData()
	{
		return "alter";
	}
	@RequestMapping("search")
	public String searchData()
	{
		return "searchId";
	}
	@RequestMapping("viewAll")
	public String showData()
	{
		return "showAll";
	}
	
	@RequestMapping("insertController")
	public ModelAndView showEntry(@ModelAttribute("add") Student student) {
		
		studentService.addStudent(student);
		ModelAndView mv = new ModelAndView("insertedRecord");
		return mv;

	}
	@RequestMapping("deleteController")
	public ModelAndView deleteEntry(@ModelAttribute("delete") Student student) {
		
		
		student=studentService.searchStudent(student.getId());
		studentService.deleteStudent(student.getId());
		ModelAndView mv = new ModelAndView("deletedPage");
		mv.addObject("delete", student);
		
		return mv;

	}
	@RequestMapping("updateController")
	public ModelAndView updateEntry(@ModelAttribute("update") Student student) {
		
		student=studentService.searchStudent(student.getId());
		//studentService.updateStudent(student);
		ModelAndView mv = new ModelAndView("updatedRecord");
		mv.addObject("update", student);
		return mv;

	}
	@RequestMapping("searchController")
	public ModelAndView searchEntry(@ModelAttribute("student") Student student){
		
		student= studentService.searchStudent(student.getId());
		ModelAndView mv=new ModelAndView("searchedPage");
		mv.addObject("search",student);
		return mv;
	}
	@RequestMapping("viewController")
	public ModelAndView viewAllEntry(@ModelAttribute("view") Student student)
	{
		List<Student> stude=studentService.viewAll();
		ModelAndView mv=new ModelAndView("showAll");
		mv.addObject("studList", stude);
		return mv;
		
	}
	@RequestMapping("secondUpdate")
	public ModelAndView updateTheEntry(@ModelAttribute("final") Student student)
	{
		studentService.updateStudent(student);
		ModelAndView mv=new ModelAndView("updatedOutput");
		return mv;
	}
	
}
