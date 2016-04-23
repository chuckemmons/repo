package com.cee.webapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cee.webapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmail(String email);
	
}
