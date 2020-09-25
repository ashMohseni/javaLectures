package ca.sheridancollege.mohsenas.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.mohsenas.beans.Message;
import ca.sheridancollege.mohsenas.beans.Student;

@Controller
public class HomeController {
	
	@Autowired
	private Message message;
	
	@GetMapping("/")
	public String index(Model model) {
		System.out.println("The message is " + message);
		return "index";
	}
	
	@PostMapping("/formPost")
	public String formPost(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email,
			@RequestParam Long studentNumber, @RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate birthday) {
		
		// Test to see the info is being received
		Student stu = new Student();
		
		stu.setFirstName(firstName);
		stu.setLastName(lastName);
		stu.setEmail(email);
		stu.setStudentNumber(studentNumber);
		stu.setBirthday(birthday);
		
		System.out.println("Student Info: " + stu);
		
		
		return "working";
	}

}
