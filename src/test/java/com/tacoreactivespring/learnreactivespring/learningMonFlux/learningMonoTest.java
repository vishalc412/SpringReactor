package com.tacoreactivespring.learnreactivespring.learningMonFlux;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class learningMonoTest {

//	
//	@Test
//	public void MonoTest() {
//		
//		Mono<String> stringMono = Mono.just("Spring");
//		
//		StepVerifier.create(stringMono.log())
//		.expectNext("Spring")
//		.verifyComplete();
//	}
	
	
	@Test
	public void MonoTest_Error() {
		
		Mono<String> stringMono = Mono.just("Spring");
		
		StepVerifier.create(Mono.error(new RuntimeException("Error Occured")).log())
		.expectError(RuntimeException.class)
		.verify();
	}
	
}
