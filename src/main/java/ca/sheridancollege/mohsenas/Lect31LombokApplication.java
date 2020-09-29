package ca.sheridancollege.mohsenas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ca.sheridancollege.mohsenas.beans.Student;

@SpringBootApplication
public class Lect31LombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lect31LombokApplication.class, args);
	
	//Test the bean
	// Create object and set the properties
	Student stu = new Student();
	stu.setId(Long.valueOf(5)); // Set the id 
	stu.setName("Frank"); // Set student name
	System.out.println("Student Information :" + stu);
	
	
	}

}
