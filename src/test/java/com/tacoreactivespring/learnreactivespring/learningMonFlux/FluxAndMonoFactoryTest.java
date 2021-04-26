package com.tacoreactivespring.learnreactivespring.learningMonFlux;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class FluxAndMonoFactoryTest {

	List<String> arlist = Arrays.asList("Vishal","Shruti","Bhavika");
	
//	@Test
//	public void fluxUsingIterable() {
//		Flux<String> namesFlux = Flux.fromIterable(arlist).log();
//		StepVerifier.create(namesFlux)
//		.expectNext("Vishal","Shruti","Bhavika")
//		.verifyComplete();
//	}
//	
//	@Test
//	public void fluxUsingArray() {
//		String[] names = new String[] {"Vishal","Shruti","Bhavika"};
//		Flux<String> namesFlux = Flux.fromArray(names).log();
//		StepVerifier.create(namesFlux)
//		.expectNext("Vishal","Shruti","Bhavika")
//		.verifyComplete();
// 	}
//	
//	
//	@Test
//	public void fluxUsingStream() {
//		
//		Flux<String> namesFlux = Flux.fromStream(arlist.stream()).log();
//		StepVerifier.create(namesFlux)
//		.expectNext("Vishal","Shruti","Bhavika")
//		.verifyComplete();
// 	}
//	
//	
	
//	@Test
//	public void monoUsingJustOrEmpty() {
//		
//		Mono<String> mono = Mono.justOrEmpty(null);//Empty mono.
//		StepVerifier.create(mono.log())
//		.verifyComplete();
//	}
	
	
	@Test
	public void monoUsingSupplier() {
		
		Supplier<String> supplier = ()->"Vishal";
		System.out.println(supplier.get());
		Mono<String> stringMono = Mono.fromSupplier(supplier);
		StepVerifier.create(stringMono.log())
		.expectNext("Vishal")
		.verifyComplete();
	}
	
	
	
	@Test
	public void fluxUsingRange() {
		
		Flux<Integer> intFlux = Flux.range(1, 5); //Return the range of values from 1 to 5 
		
		StepVerifier.create(intFlux.log())
		.expectNext(1,2,3,4,5)
		.verifyComplete();
		
	}
	
}
