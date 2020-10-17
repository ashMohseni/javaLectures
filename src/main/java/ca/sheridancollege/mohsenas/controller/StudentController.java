package ca.sheridancollege.mohsenas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.mohsenas.beans.Student;
import ca.sheridancollege.mohsenas.database.DatabaseAccess;

@Controller
public class StudentController {

	@Autowired
	private DatabaseAccess da;
	
	@GetMapping("/")
	public String index(Model model) {
		
		// Add student Frank to the DB
		da.insertStudent();
		
		model.addAttribute("student", new Student());
		
		return "index";
	}
	
	
	
	@PostMapping("/insertStudent")
	public String insertStudent(Model model, @ModelAttribute Student student) {
		
		//Add the specified name by the user to the DB
		da.insertStudent(student);
		
		// Get the student list and add it to the model (for index.html to use it)
		model.addAttribute("studentList", da.getList());
		
		// Add a blank object to insert the next student
		model.addAttribute("student", new Student());
		
		return "index";
	}
	
	
	@GetMapping("/deleteStudentById/{id}")
	public String deleteStudentById(Model model, @PathVariable Long id) {
		
		// Call method to delete the record
		da.deleteStudentbyID(id);
		
		// Update the list
		model.addAttribute("student", da.getList());
		// Blank object for form binding 
		model.addAttribute("student", new Student());
		
		
		return "index";
	}
	
	@GetMapping("/editStudentById/{id}")
	public String editStudentById(Model model, @PathVariable Long id) {
		
		//Specify a record to update and get the result
		Student student = da.getStudentListByID(id).get(0);
		
		// Add the object to the model
		model.addAttribute("student", student);
		
		// Delete the existing version of the record
		da.deleteStudentbyID(id);
		
		// Update the model with the new version of the list
		model.addAttribute("studentList", da.getList());
		
		
		
		return "index";
		
	}
	
	
	
}
