package com.spring.jackson.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.jackson.dto.GuitarDto;

@RestController
@RequestMapping("/guitar")
public class GuitarController {

	@PostMapping("/save")
	public GuitarDto saveGuitar(@RequestBody GuitarDto guitarDto) {
		guitarDto.setPrice(9900L);
		System.out.println(guitarDto.isWantToBuy());
		return guitarDto;
	}
	
}
