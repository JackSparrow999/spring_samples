package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoBackPressure {

	@Test
	public void testBackPressureDemo() {
		Flux<String> fluxes = Flux.just("ronaq", "papa", "mummy", "didi");
		
		StepVerifier.create(fluxes)
					.expectSubscription()
					.thenRequest(1)
					.expectNext("ronaq")
					.thenRequest(1)
					.expectNext("papa")
					.thenCancel()
					.verify();
	}
	
	@Test
	public void testBackPressureSubscriber() {
		Flux<String> fluxes = Flux.just("ronaq", "papa", "mummy", "didi");
		
		fluxes.subscribe(
				x -> System.out.println(x),
				e -> System.out.println("Error is " + e),
				() -> System.out.println("Completed flux"),
				(subscription) -> subscription.request(2));
	}
	
	@Test
	public void testBackPressureSubscriberWithCancel() {
		Flux<String> fluxes = Flux.just("ronaq", "papa", "mummy", "didi");
		
		fluxes.subscribe(
				x -> System.out.println(x),
				e -> System.out.println("Error is " + e),
				() -> System.out.println("Completed flux"),
				(subscription) -> subscription.cancel());
	}
	
	@Test
	public void testHookOnNext() {
		
		Flux<String> fluxes = Flux.just("ronaq", "papa", "mummy", "didi")
				.log();
		
		fluxes.subscribe(new BaseSubscriber<String>() {
			protected void hookOnNext(String val) {
				request(1);
				if(val.equals("mummy"))
					cancel();
				System.out.println(val);
			}
		});
		
	}
	
}
