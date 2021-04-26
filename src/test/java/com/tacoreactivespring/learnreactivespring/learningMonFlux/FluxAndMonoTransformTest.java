package com.tacoreactivespring.learnreactivespring.learningMonFlux;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxAndMonoTransformTest {

	List<String> arlist = Arrays.asList("Vishal","Shruti","Bhavika");
	
	@Test
	public void transaformUsingMap() {
		
		Flux<String> nameFlux = Flux.fromIterable(arlist)
				.map(s->s.toUpperCase()).log(); //We will get all the names in arlist in upper case.
		
		StepVerifier.create(nameFlux)
		.expectNext("VISHAL","SHRUTI","BHAVIKA")
		.verifyComplete();
		
	}

	
	@Test
	public void transaformUsingMap_LengthMethod() {
		
		Flux<Integer> nameFlux = Flux.fromIterable(arlist)
				.map(s->s.length()).log(); //We will get all the names length in flux.
		
		StepVerifier.create(nameFlux)
		.expectNext(6,6,7)
		.verifyComplete();
		
	}
	
	@Test
	public void transaformUsingMap_Length_Repeat() {
		
		Flux<Integer> nameFlux = Flux.fromIterable(arlist)
				.map(s->s.length())
				.repeat(1)
				.log();
		
		StepVerifier.create(nameFlux)
		.expectNext(6,6,7,6,6,7)
		.verifyComplete();
		
	}
	
	
	@Test
	public void transaformUsingMap_Filert() {
		
		Flux<String> nameFlux = Flux.fromIterable(arlist)
				.filter(s->s.length()>6)
				.map(s->s.toUpperCase())
				.log();   //This is known as pipeline
		
		StepVerifier.create(nameFlux)
		.expectNext("BHAVIKA")
		.verifyComplete();
		
	}
}
