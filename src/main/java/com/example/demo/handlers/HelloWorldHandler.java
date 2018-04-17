package com.example.demo.handlers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * 测试项目是否运行的hello world
 * @author sunjibo
 * @date 18-4-13
 */
@Service
public class HelloWorldHandler {
	public Mono<ServerResponse> helloWorld(ServerRequest request){
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN).body(BodyInserters.fromObject("hello world"));
	}
}
