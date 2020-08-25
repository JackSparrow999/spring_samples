package com.spring.jpa_join_demo.one_to_one;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private GuitarRepository guitarRepository;
	
	@PostMapping("/save")
	public Person savePlayers(@RequestBody Person person) {
		return personRepository.save(person);
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPerons(){
		return personRepository.findAll();
	}
	
	@GetMapping("/guitars")
	public List<Guitar> getAllGuitars(){
		return guitarRepository.findAll();
	}
	
}
