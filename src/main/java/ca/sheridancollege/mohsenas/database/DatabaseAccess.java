package ca.sheridancollege.mohsenas.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.mohsenas.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	/*
	 * Insert Frank to the database
	 */

	public void insertStudent() {

		// To use for parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Specify the query
		String query="INSERT INTO student(name) VALUES ('Frank')";

		// Insert the row to the DB and check the return value
		int rowsAffected = jdbc.update(query, namedParameters);

		// Check if any rows were updated
		if(rowsAffected>0) {
			System.out.println("Student was inserted in DB");
		}


	}

	/*
	 * Insert a student object to the database
	 */

	public void insertStudent(Student student) {

		// To use for parameters
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		// Specify the query to insert the student name to the DB
		String query="INSERT INTO student(name) VALUES (:name)";
		
		//Specify the value to replace name
		namedParameters.addValue("name", student.getName());

		// Insert Student to DB
		int rowsAffected = jdbc.update(query, namedParameters);

		// Check to see if the insert was successful
		if(rowsAffected>0) {
			System.out.println("Student was inserted in DB");
		}

	}
	
	/*
	 * Display a List of all students
	 * @return the Student List
	 */
	public List<Student> getList(){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		//Query to retrieve all students
		String query = "SELECT * FROM student";
		
		// Return the list
		// NOTE: BeanPropertyRowMapper will convert the data read from the DB to student object
		return jdbc.query(query, namedParameters,new BeanPropertyRowMapper<Student>(Student.class));
		
	}
	
	
	public void deleteStudentbyID(Long ID) {
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		//Query
		String query = "DELETE FROM student WHERE id = :id";
		
		//specify the parameter
		namedParameters.addValue("id", ID);
		
		// Perform delete
		int rowsAffected = jdbc.update(query, namedParameters);
		
		//Check if delete is successful
		if(rowsAffected > 0) {
			System.out.println("Student with id (" + ID + ") has been deleted.");
		}
		
	}
	
	
	
	public List<Student> getStudentListByID(Long ID){
		
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		
		String query= "SELECT * FROM student WHERE id = :id";
		
		// Specify the value of the named parameter
		namedParameters.addValue("id", ID);
		
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Student>(Student.class));
		
	}


}// End of DatabaseAccess
