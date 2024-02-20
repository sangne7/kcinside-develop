package com.kong.kcinside.user.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kong.kcinside.user.dto.UserDTO;
import com.kong.kcinside.user.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
//	public int signUp(UserDTO new_user) {
//		
//		LocalDate today = LocalDate.now();
//		
//		System.out.println(passwordEncoder.encode(new_user.getPassword()));
//		
//		System.out.println(user.toString());
//
//		return userRepository.save(user).getId();
//	}
}
