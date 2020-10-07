package ca.sheridancollege.eadeeb.beans;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Song implements Serializable {

	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6768858324156922345L;

	private final String[] genres = {"Spoken Word", "Country", 
			"Classical", "Indie", "Electronic"};

	private Long id;
	private String title;
	private String artist;
	private String genre;

}
