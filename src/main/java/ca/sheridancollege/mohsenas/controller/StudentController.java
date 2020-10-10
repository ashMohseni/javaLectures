package ca.sheridancollege.mohsenas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ca.sheridancollege.mohsenas.beans.Student;
import ca.sheridancollege.mohsenas.database.DatabaseAccess;

@Controller
public class StudentController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		
		da.insertStudent();
		model.addAttribute("Student", new Student());
		
		return "index";
	}
	
	
	
//	@PostMapping("/insertStudent")
//	public String insertStudent() {
//		
//		return "index";
//	}
	
}
