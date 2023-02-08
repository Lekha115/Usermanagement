package com.javabsf.UserManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabsf.UserManagement.collection.User;

import com.javabsf.UserManagement.service.userService;

@RestController
@RequestMapping("/user")
public class userController {
	
	

		@Autowired
		userService userservice;
		
		@PostMapping("/addUser")
		public ResponseEntity<User> addUser(@RequestBody User user) {
			return userservice.addUser(user);
		}
		@GetMapping("/getAllUser")
		public List<User> getAllUser() {
			return userservice.getAllUser();
		}
		@PutMapping("/updateUser/{id}")
		public ResponseEntity updateUser(@RequestBody User user, @PathVariable int id) {
			return userservice.updateUser(user, id);
		}
		
		@GetMapping("/getUser/{id}")
		public Optional<User> getUser(@PathVariable("id") Long id)
		{
			return userservice.getUser( id);
		}
		@GetMapping("/getUserByName/{name}")
		public Optional<User> getUserByName(@PathVariable("name") String name)
		{
			return userservice.getUserData( name);
		}
		
		@DeleteMapping("/deleteUser/{id}")
		public ResponseEntity deleteUser(@PathVariable long id) {
			 return userservice.deleteUser(id);
		}
		

		

}
