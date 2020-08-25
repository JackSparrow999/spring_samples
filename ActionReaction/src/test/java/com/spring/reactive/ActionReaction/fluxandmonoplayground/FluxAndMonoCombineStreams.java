package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import java.time.Duration;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoCombineStreams {

	@Test
	public void combineSreamsMerge() {
		Flux<String> flux1 = Flux.just("ronaq", "papa");
		Flux<String> flux2 = Flux.just("mummy", "didi");
		
		Flux mergedFlux = Flux.merge(flux1, flux2);
		
		StepVerifier.create(mergedFlux)
					.expectNext("ronaq", "papa", "mummy", "didi")
					.verifyComplete();
		
	}
	
	@Test
	public void combineSreamsMergeWithDelay() {
		Flux<String> flux1 = Flux.just("ronaq", "papa").delayElements(Duration.ofSeconds(1));
		Flux<String> flux2 = Flux.just("mummy", "didi").delayElements(Duration.ofSeconds(1));
		
		Flux mergedFlux = Flux.merge(flux1, flux2);
		
		//merge does not maintain flux 1, 2 order
		StepVerifier.create(mergedFlux)
					.expectNextCount(4)
					.verifyComplete();
		
	}
	
	@Test
	public void combineSreamsConcatWithDelay() {
		Flux<String> flux1 = Flux.just("ronaq", "papa").delayElements(Duration.ofSeconds(1));
		Flux<String> flux2 = Flux.just("mummy", "didi").delayElements(Duration.ofSeconds(1));
		
		Flux mergedFlux = Flux.concat(flux1, flux2);
		
		//merge does not maintain flux order
		StepVerifier.create(mergedFlux)
					.expectNextCount(4)
					.verifyComplete();
		
	}
	
	@Test
	public void combineStreamsWithZip() {
		Flux<String> flux1 = Flux.just("papa", "mummy");
		Flux<String> flux2 = Flux.just("ronaq", "didi");
		
		Flux<String> zippedFlux = Flux.zip(flux1,  flux2, 
				(p, q) -> p.concat(q));
		
		StepVerifier.create(zippedFlux.log())
				.expectNextCount(2)
				.verifyComplete();
	}
	
}
