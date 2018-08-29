package com.example.demo.domain;

import org.springframework.data.annotation.Id;

/**
 * Created by sunjibo on 18-4-16.
 */
public class Person {

	@Id
	private Long id;

	private String username;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
