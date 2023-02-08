package com.javabsf.UserManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javabsf.UserManagement.collection.User;

import com.javabsf.UserManagement.repository.userRepository;

@Service
public class userService {
	

	
	@Autowired
	userRepository userRepository;
	
	

	public  ResponseEntity addUser(User user) {
		Optional<User> user1=userRepository.findByEmail(user.getEmail());
		if(user1.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user email is already present");
		}
		else
		return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
		
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}
	
	public Optional<User> getUser(long id) {
		return userRepository.findById(id);
	}
	public Optional<User> getUserData(String name) {
		return userRepository.findByName(name);
	}

	public ResponseEntity updateUser(User user, long id) {
		User user1=userRepository.findById(id).orElse(null);
		if(user1!=null)
		{
			user1.setEmail(user.getEmail());
			user1.setAddress(user.getAddress());
			user1.setMobileNumber(user.getMobileNumber());
			user1.setName(user.getName());
			return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user1));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user not present");
	}

	public ResponseEntity deleteUser(long id) {
		userRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).body("User is deleted");
	}

	}


