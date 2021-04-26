package com.tacoreactivespring.learnreactivespring.learningMonFlux;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import java.lang.Object;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.support.hierarchical.ParallelExecutionConfiguration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.ParallelFlux;
import reactor.test.StepVerifier;


class FluxAndMonoTransformTest2 extends Object{

	List<String> arlist = Arrays.asList("Vishal","Shruti","Bhavika");
	
	@Test
//	public void transaformUsingFlatMap() {
//		
//		Flux<String> nameFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E","F")) //A,B,C,D,E,F
//				.flatMap(s->{
//					
//					return Flux.fromIterable(convertToList(s)); //If value is A then we will get List[A,newValue], if B-> List[B,newValue ] ......
//				})
//				.log();   //for every element when we need DB or external service call and that return the flux then.s-> Flux<String>
//		
//		StepVerifier.create(nameFlux)
//		.expectNextCount(12)
//		.verifyComplete();
//		
//	}

	private List<String> convertToList(String s) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Arrays.asList(s,"NewValue");
	}
	
//	@Test
//	public void transaformUsingFlatMap_UsingParallel() {
//		
//		Flux<String> nameFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E","F"))
//				.window(2)
//				.flatMap((s)-> 
//				s.map(this::convertToList).subscribeOn(reactor.core.scheduler.Schedulers.parallel()))
//				.flatMap(s->Flux.fromIterable(s)).log();
//		
//				StepVerifier.create(nameFlux)
//				.expectNextCount(12)
//				.verifyComplete();
//		
//	}
	
	@Test
	public void transaformUsingFlatMap_UsingParallelOrdered() {
		
		Flux<String> nameFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E","F"))
				.window(2)
//				.concatMap((s)-> 
//				s.map(this::convertToList).subscribeOn(reactor.core.scheduler.Schedulers.parallel()))
//				.flatMap(s->Flux.fromIterable(s)).log();
				.flatMapSequential((s)-> 
				s.map(this::convertToList).subscribeOn(reactor.core.scheduler.Schedulers.parallel()))
				.flatMap(s->Flux.fromIterable(s)).log();
				StepVerifier.create(nameFlux)
				.expectNextCount(12)
				.verifyComplete();
		
	}
	
	
}
