package com.spring.reactive.ActionReaction.Controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class FluxAndMonoController {
	
	@GetMapping(value="/ints")
	public Flux<Integer> getIntegers(){
		return Flux.range(1, 5)
				.delayElements(Duration.ofSeconds(1)).
				log();
	}
	
	@GetMapping(value="/ints_stream",
			produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Integer> getIntegersStream(){
		return Flux.range(1, 5)
				.delayElements(Duration.ofSeconds(1)).
				log();
	}

}
