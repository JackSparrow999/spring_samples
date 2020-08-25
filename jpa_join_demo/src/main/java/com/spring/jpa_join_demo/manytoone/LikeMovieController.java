package com.spring.jpa_join_demo.manytoone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/likemovie")
public class LikeMovieController {
	
	@Autowired
	private BoyRepository boyRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@GetMapping("/boys")
	public List<Boy> getBoys(){
		return boyRepository.findAll();
	}
	
	@GetMapping("/movies")
	public List<Movie> getMovies(){
		return movieRepository.findAll();
	}
	
	@PostMapping("/save")
	public Movie saveMovie(@RequestBody Movie movie) {
		return movieRepository.save(movie);
	}

}
