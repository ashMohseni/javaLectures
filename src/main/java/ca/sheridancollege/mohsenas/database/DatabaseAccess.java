package ca.sheridancollege.mohsenas.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
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
	
	
	
}
