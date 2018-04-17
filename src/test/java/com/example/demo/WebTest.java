package com.example.demo;

import com.example.demo.domain.Person;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * 这个测试跑之前要先把项目启动，不然访问不到
 * Created by sunjibo on 18-4-16.
 */
public class WebTest {

//	private static final Logger log = LoggerFactory.getLogger(WebTest.class);

	@Test
	public void testSave(){
		//webClient可以create的时候指定url，也可以在用的时候uri（）这样指定
		WebClient client = WebClient.create();
		//这段用来参考（get请求
//		Mono<Person> result = client.post()// 请求方法,get,post...
//				.uri("persion/getPersion/{id}.json", "123")// 请求相对地址以及参数
//				.accept(MediaType.APPLICATION_JSON).retrieve()// 请求类型
//				.bodyToMono(Person.class);// 返回类型
//		Person person = result.block();
//		log.info(JSONObject.wrap(person).toString());
		//参考部分结束
//		Mono<String> result = client.get().uri("").retrieve()
//				.bodyToMono(String.class);
//		System.out.println(result.block());//hello!
		Person person = new Person();
		person.setId(1L);
		person.setUsername("Tom");
		Mono<String> resp = client.post()
				.uri("http://localhost:8092/person")
				//1.Accept属于请求头, Content-Type属于实体头,是http的内容，猜测：get请求放到请求头里，post放到实体里
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.body(Mono.just(person),Person.class)
				//retrieve中文意为取回，猜测意思是取回，然后把返回值变成Mono<String>
				.retrieve().bodyToMono(String.class);
		System.out.println(resp.block());//这里好像显示的null，没有返回什么东西

	}
}
