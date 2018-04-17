package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 和mvc进行对比的类
 * @author sunjibo
 * @date 18-4-13
 */
@RestController
public class HelloController {

	@GetMapping("/hello/{latency}")
	public Mono<String> hello(@PathVariable int latency){
		//delayElement实现延迟
		return Mono.just("Welcome to reactive world ~").delayElement(Duration.ofMillis(latency));
	}
}
