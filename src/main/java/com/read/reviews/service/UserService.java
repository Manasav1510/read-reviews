package com.read.reviews.service;

import java.util.Optional;

import com.read.reviews.entity.User;

public interface UserService {

	public Optional<User> getUser(String userId) ;
		
	public void saveUser(User user);
}
