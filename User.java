package com.javabsf.UserManagement.collection;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {
	@Id
	long userId;
	String name;
	String email;
	long mobileNumber;
	String Address;

}
