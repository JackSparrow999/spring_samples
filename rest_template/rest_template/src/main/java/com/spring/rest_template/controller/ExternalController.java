package com.spring.rest_template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ExternalController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	Object[] objects = restTemplate.getFor
	
}
