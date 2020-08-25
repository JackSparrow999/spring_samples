package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoFilterTest {
	
	List<String> list = Arrays.asList(new String[] {"ronaq", "papa", "mummy", "", "didi"});
	
	@Test
	public void filterTest() {
		Flux<String> fluxList = Flux.fromIterable(list)
				.filter(str -> !str.isEmpty());
		
		StepVerifier.create(fluxList.log())
				.expectNextCount(4)
				.verifyComplete();
	}
	
}
