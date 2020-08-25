package com.spring.jpa_join_demo.onetomany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/love")
public class SongsILikeController {

	@Autowired
	private GuyRepository guyRepository;
	
	@Autowired
	private SongRepository songRepository;
	
	@PostMapping("/likesongs")
	public Guy likeSongs(@RequestBody Guy newGuy) {
		return guyRepository.save(newGuy);
	}
	
	@GetMapping("/songs")
	public List<Song> getAllSongs(){
		return songRepository.findAll();
	}
	
	@GetMapping("/guys")
	public List<Guy> getAllGuys(){
		return guyRepository.findAll();
	}
	
}
