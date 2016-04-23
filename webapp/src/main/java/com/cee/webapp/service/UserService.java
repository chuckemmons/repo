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
	
	/**
	 * Authenticates a user.
	 * <p>
	 * If authenticated, initializes
	 * 
	 * @param user the user to authenticate
	 * @return  if the user is authenticated or not
	 */
	public boolean authenticate(User user) {
		User persistedUser = userRepository.findByEmail(user.getEmail());
		
		if (persistedUser == null) {
			return false;
		}
		
		if(user.getPassword().equals(persistedUser.getPassword())) {
			user.setFirstName(persistedUser.getFirstName());
			return true;
		}
		return false;
	}
	
}
