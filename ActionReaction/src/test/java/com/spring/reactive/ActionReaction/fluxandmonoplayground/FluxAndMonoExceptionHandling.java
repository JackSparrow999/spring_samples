package com.spring.reactive.ActionReaction.fluxandmonoplayground;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxAndMonoExceptionHandling {
	
	@Test
    public void fluxTestOnErrorResume(){
        Flux<String> fluxStr = Flux.just("Papa", "Mummy")
        		.concatWith(Flux.error(new RuntimeException("Runtime exc")))
        		.concatWith(Flux.just("didi"))
        		.onErrorResume((e) -> {
        			System.out.println(e);
        			return Flux.just("ronaq");
        		});
        
        StepVerifier.create(fluxStr)
        		.expectNextCount(3)
        		.verifyComplete();
    }
	
	@Test
    public void fluxTestOnErrorReturn(){
        Flux<String> fluxStr = Flux.just("Papa", "Mummy")
        		.concatWith(Flux.error(new RuntimeException("Runtime exc")))
        		.concatWith(Flux.just("didi"))
        		.onErrorReturn("ronaq");
        
        StepVerifier.create(fluxStr)
        		.expectNextCount(3)
        		.verifyComplete();
    }
	
	@Test
    public void fluxTestOnErrorMap(){
        Flux<String> fluxStr = Flux.just("Papa", "Mummy")
        		.concatWith(Flux.error(new RuntimeException("Runtime exc")))
        		.concatWith(Flux.just("didi"))
        		.onErrorMap((e) -> new CustomException(e));
        
        StepVerifier.create(fluxStr)
        		.expectNextCount(2)
        		.expectError(CustomException.class)
        		.verify();
    }
	
	@Test
    public void fluxTestOnRetry(){
        Flux<String> fluxStr = Flux.just("Papa", "Mummy")
        		.concatWith(Flux.error(new RuntimeException("Runtime exc")))
        		.concatWith(Flux.just("didi"))
        		.onErrorMap((e) -> new CustomException(e))
        		.retry(1);
        
        StepVerifier.create(fluxStr.log())
        		.expectNextCount(4)
        		.expectError(CustomException.class)
        		.verify();
    }

}
