package com.example.demo.controllers;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 测试mongodb
 * @author sunjibo
 * @date 18-4-16
 */
@RestController
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/")
	public String hello(){
		return "hello!";
	}

	@PostMapping("/person")
	public Mono<Void> add(@RequestBody Publisher<Person> person){
		return personRepository.insert(person).then();
	}

	@GetMapping("/person/{id}")
	public Mono<Person> getById(@PathVariable Long id){
		return personRepository.findById(id);
	}

	@GetMapping("/person/list")
	public Flux<Person> list(){
		return personRepository.findAll();
	}

	@DeleteMapping("/person/{id}")
	public Mono<Void> delete(@PathVariable Long id){
		return personRepository.deleteById(id);
	}
}
