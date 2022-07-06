package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.models.User;

@Service
public class UserService {

	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("abc", "abc123", "abc@gmail.com"));
		list.add(new User("pqr", "pqr123", "pqr@gmail.com"));
	}

	// Get all users
	public List<User> getAllUsers() {
		return this.list;
	}

	// Get single user
	public User getUser(String username) {
		return this.list.stream().filter((user) -> user.getUsername().equals(username)).findAny().orElse(null);
	}

	// Insert user
	public User insertUser(User user) {
		this.list.add(user);
		return user;
	}

}