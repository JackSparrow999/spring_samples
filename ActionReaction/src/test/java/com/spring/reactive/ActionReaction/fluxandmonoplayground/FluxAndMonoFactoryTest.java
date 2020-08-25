package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import java.util.List;
import java.util.function.Supplier;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoFactoryTest {
	
	String[] s = new String[] {"ronaq", "didi", "papa"};
	List<Object> names = Arrays.asList(s);

	@Test
	public void testFlux() {
		Flux<Object> flux = Flux.fromIterable(names);
		StepVerifier.create(flux)
					.expectNextCount(3)
					.verifyComplete();
	}
	
	@Test
	public void testFluxFromArray() {
		Flux<String> fluxNames = Flux.fromArray(s);
		StepVerifier.create(fluxNames)
					.expectNextCount(3)
					.verifyComplete();
	}
	
	@Test
	public void testFluxFromStream() {
		Flux<Object> fluxNames = Flux.fromStream(names.stream());
		StepVerifier.create(fluxNames)
					.expectNextCount(3)
					.verifyComplete();
		//stream starts executing only after verifyComplete
	}
	
	@Test
	public void testMonoOrEmpty() {
		Mono<String> mono = Mono.justOrEmpty(null);
		StepVerifier.create(mono)
					.verifyComplete();
		//stream starts executing only after verifyComplete
	}
	
	@Test
	public void testMonoFromSupplier() {
		Supplier<String> supl = () -> "Hello";
		StepVerifier.create(Mono.fromSupplier(supl))
					.expectNextCount(1)
					.verifyComplete();
		//stream starts executing only after verifyComplete
	}
	
	@Test
	public void testFluxFromRange() {
		Flux<Integer> fluxInts = Flux.range(1, 7);
		StepVerifier.create(fluxInts)
					.expectNextCount(7)
					.verifyComplete();
		//stream starts executing only after verifyComplete
	}
}
