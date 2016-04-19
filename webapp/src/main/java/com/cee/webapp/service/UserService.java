package com.cee.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cee.webapp.model.User;
import com.cee.webapp.repository.UserRepository;

@Service
@Transactional
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserService() {}
	
	public UserService(UserRepository repository) {
		this.userRepository = repository;
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
	
}
