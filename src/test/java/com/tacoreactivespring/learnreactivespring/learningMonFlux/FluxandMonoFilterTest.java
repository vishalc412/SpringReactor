package com.tacoreactivespring.learnreactivespring.learningMonFlux;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

class FluxandMonoFilterTest {

	List<String> arlist = Arrays.asList("Vishal","Shrut","Bhavika");
	
	@Test
	public void filterTest() {
		Flux<String> fluxFilter =  Flux.fromIterable(arlist).filter(s->s.startsWith("V")).log(); //Only name start with V wil be part of flux
		
		StepVerifier.create(fluxFilter)
		.expectNext("Vishal")
		.verifyComplete();
		
		
	}
	
	
	@Test
	public void filterTestLength() {
		Flux<String> fluxFilter =  Flux.fromIterable(arlist).filter(s->s.length()>5).log(); //Only name start with V wil be part of flux
		
		StepVerifier.create(fluxFilter)
		.expectNext("Vishal","Bhavika")
		.verifyComplete();
		
		
	}
	
}
