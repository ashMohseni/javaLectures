package ca.sheridancollege.mohsenas.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.mohsenas.beans.Student;

@Controller
public class StudentController {
	
	List<Student> studentList = new CopyOnWriteArrayList<Student>();
	

	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("serverDate", LocalDate.now());
		
		return "index";
	}
	
	@GetMapping("/getStudent")
	public String getStudent(Model model) {
		
		Student myStudent = new Student(Long.valueOf("1234"), "Frank");
		model.addAttribute("student", myStudent);
		
		return "getStudent";
	}
	
	@GetMapping("/getStudentList")
	public String getStudentList(Model model) {
		
		
		studentList.add(new Student(Long.valueOf("1234"), "Frank"));
		studentList.add(new Student(Long.valueOf("1235"), "Sarah"));
		studentList.add(new Student(Long.valueOf("1236"), "Giovanni"));
		studentList.add(new Student(Long.valueOf("1237"), "Angela"));
		
		model.addAttribute("studentList", studentList);
		
		return "getStudentList";
	}
}
