package com.example.demo.repository;

import com.example.demo.domain.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Primary注解，同名的情况下优先注入这个(不考虑指定名字的情况)
 * @author sunjibo
 * @date 18-4-16
 */
@Repository
@Primary
public interface PersonRepository extends ReactiveMongoRepository<Person,Long> {
}
