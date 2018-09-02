/*package com.read.reviews.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.read.reviews.entity.Users;
import com.read.reviews.repository.UserRepository;
import com.read.reviews.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRespository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRespository = userRepository;
	
	}
	
	public Optional<Users> getUser(String userId) {
		return userRespository.findById(userId);
	}
	
	public void saveUser(Users user) {
		userRespository.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return userRespository.findAll();
	}
}
*/