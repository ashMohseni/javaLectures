package ca.sheridancollege.eadeeb.controllers;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.eadeeb.beans.Song;

@Controller
public class SongController {

	List<Song> songList = new CopyOnWriteArrayList<Song>();
	
	@GetMapping("/")
	public String index(Model model) {
		
		// Create a blank Song object and add it to the model parameter		
		model.addAttribute("song", new Song());
		model.addAttribute("songList", songList);
		return "index";
	}
	
	@PostMapping("/addSong")
	public String addSong(Model model, @ModelAttribute Song song) {
		
		// Add song to the list
		songList.add(song);
		
		// Update the model to included the updated version of the list
		model.addAttribute("songList", songList);
		
		// Create another blank Song object for the next insert
		model.addAttribute("song", new Song());
		
		
		return "index";
	}
	
}
