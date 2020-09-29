package ca.sheridancollege.mohsenas.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudenTest {

	@Test
	public void buildStudent() {
		
		Student testStu = Student.builder()
				.id(Long.valueOf(10))
				.name("Joseph")
				.build(); // Complete the creation of the Student object
		
		// Check if the id is 10
		assertEquals(testStu.getId(), Long.valueOf(10));
		// Check if the name is "Joseph"
		assertEquals(testStu.getName(), "Joseph");
		
		
	}
}
