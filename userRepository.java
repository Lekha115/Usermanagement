package com.javabsf.UserManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javabsf.UserManagement.collection.User;

public interface userRepository extends MongoRepository<User, Long>{
	
	Optional<User> findByEmail(String email);
	List<User> findAllByuserId(Long userId );
	Optional<User> findByName(String name );


}
