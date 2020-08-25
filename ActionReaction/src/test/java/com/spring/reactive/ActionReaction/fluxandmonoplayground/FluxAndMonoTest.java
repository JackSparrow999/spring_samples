package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Created by DELL on 8/1/2020.
 */
public class FluxAndMonoTest {

    @Test
    public void fluxTest(){
        Flux<String> fluxStr = Flux.just("Hello ", "Greetings ", "Hi")
//        		.concatWith(Flux.error(new RuntimeException("Runtime exc")))
        		.concatWith(Flux.just("Another one "));
        
        fluxStr.subscribe(System.out::println,
                (e) -> System.err.println("Exception occured " + e));
    }
    
    @Test
    public void fluxTestWithElements() {
    	Flux<String> flux = Flux.just("Hey", "Hi", "Hello");
    	
    	StepVerifier.create(flux)
    				.expectNext("Hey")
    				.expectNext("Hi")
    				.expectNext("Hello")
    				.verifyComplete();
    }
    
    @Test
    public void fluxElementsWithError() {
    	Flux<String> flux = Flux.just("data")
    			.concatWith(Flux.error(new RuntimeException()));
    	
    	StepVerifier.create(flux)
    			.expectNext("data")
    			.expectError(RuntimeException.class)
    			.verify();
    }
    
    @Test
    public void monoTest() {
    	Mono<String> mono = Mono.just("Hey");
    	
    	StepVerifier.create(mono)
    			.expectNext("Hey")
    			.verifyComplete();
    }

    @Test
    public void monoTestWithError() {
    	StepVerifier.create(Mono.error(new RuntimeException()).log())
    			.expectError()
    			.verify();
    }
    
}
