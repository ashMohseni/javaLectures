package ca.sheridancollege.mohsenas.beans;

import java.time.LocalDate;

public class Student {

	private String firstName;
	private String lastName;
	private Long studentNumber;
	private String email;
	private LocalDate birthday;
	

    
    public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(Long studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
    public String toString() {
		return lastName + ", " + firstName + ", " + email + ", " 
    + studentNumber + ", " + birthday;
    }
    
    
}
