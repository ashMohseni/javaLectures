package ca.sheridancollege.mohsenas.beans;

import org.springframework.stereotype.Component;

@Component
public class Message {

	
	private String sayThis = "Injected! this is powerful. :)";

	@Override
	public String toString() {
		return "Message [sayThis= " + sayThis + " ]";
	}
}
