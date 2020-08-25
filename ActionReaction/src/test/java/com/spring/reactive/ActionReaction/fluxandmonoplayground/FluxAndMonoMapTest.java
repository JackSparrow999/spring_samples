package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoMapTest {

	List<String> list = Arrays.asList(new String[] {"ronaq", "papa", "mummy", "", "didi"});
	
	@Test
	public void mapTest() {
		Flux<Integer> fluxList = Flux.fromIterable(list)
				.filter(str -> !str.isEmpty())
				.map(str -> str.length())
				.repeat(0);//repeats flux 0 times i.e. result flux is same
		
		StepVerifier.create(fluxList)
				.expectNext(5, 4, 5, 4)
				.verifyComplete();
	}
	
	@Test
	public void flatMapTest() {
		Flux<String> flux = Flux.fromIterable(list)
					.filter(s -> !s.isEmpty())
					.flatMap(x -> dbSimulation(x))
					.log();
		
		StepVerifier.create(flux)
					.expectNextCount(8)
					.verifyComplete();
	}
	
	public Flux<String> dbSimulation(String s){
		Flux<String> flux = Flux.just(s)
					.concatWithValues("hello");
		return flux;
	}
	
	
	
}
