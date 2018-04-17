package com.example.demo;

import com.example.demo.handlers.HelloWorldHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

/**
 * 测试项目是否运行的 router,和HelloController配合使用
 * @author sunjibo
 * @date 18-4-13
 */
@Configuration
public class Router {
	@Autowired
	private HelloWorldHandler helloWorldHandler;

	@Bean
	public RouterFunction<?> routerFunction(){
		return RouterFunctions.route(RequestPredicates.GET("/hello"),helloWorldHandler::helloWorld);
	}
}
