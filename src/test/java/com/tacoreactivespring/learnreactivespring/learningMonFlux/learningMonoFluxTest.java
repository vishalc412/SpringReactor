package com.tacoreactivespring.learnreactivespring.learningMonFlux;


import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class learningMonoFluxTest {

//	@Test
//	public void FluxTest() {
//		
//		Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Flux Test")//.log();
//				.concatWith(Flux.error(new RuntimeException("Exception Occured")))
//				.log();
//		
//		stringFlux.subscribe(System.out::println,(e)-> System.err.println(e),()->System.out.println("completed"));
//		
//	}
	
//	@Test
//	public void FluxTestWithElements() {
//		Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Flux Test")
//				
//				.log();
//		
//		StepVerifier.create(stringFlux)
//		.expectNext("Spring")
//		.expectNext("Spring Boot")
//		
//		.expectNext("Flux Test")
//		.verifyComplete(); // Its equivalent to subscribe that the one that actually starts the subscription
//		}

//	
//	@Test
//	public void FluxTestWithErrors() {
//		Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Flux Test")
//				.concatWith(Flux.error(new RuntimeException("Exception Occured")))
//				.log();
//		
//		StepVerifier.create(stringFlux)
//		.expectNext("Spring")
//		.expectNext("Spring Boot")
//		
//		.expectNext("Flux Test")
//		.expectErrorMessage("Exception Occured")
//		//.expectError(RuntimeException.class)
//		.verify();
//		//.verifyComplete(); // Its equivalent to subscribe that the one that actually starts the subscription
//		}
//	
	
//	@Test
//	public void FluxTestElementCount() {
//		Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Flux Test")
//				.concatWith(Flux.error(new RuntimeException("Exception Occured")))
//				.log();
//		
//		StepVerifier.create(stringFlux)
//		.expectNextCount(3)
//		.expectErrorMessage("Exception Occured")
//		//.expectError(RuntimeException.class)
//		.verify();
//		//.verifyComplete(); // Its equivalent to subscribe that the one that actually starts the subscription
//		}
	@Test
	public void FluxTestWithErrors() {
		Flux<String> stringFlux = Flux.just("Spring","Spring Boot","Flux Test")
				.concatWith(Flux.error(new RuntimeException("Exception Occured")))
				.log();
		
		StepVerifier.create(stringFlux)
		.expectNext("Spring","Spring Boot","Flux Test")
		.expectErrorMessage("Exception Occured")
		//.expectError(RuntimeException.class)
		.verify();
		//.verifyComplete(); // Its equivalent to subscribe that the one that actually starts the subscription
		}
}
