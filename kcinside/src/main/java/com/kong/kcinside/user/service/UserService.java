package com.kong.kcinside.user.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kong.kcinside.user.dto.UserDTO;
import com.kong.kcinside.user.entity.User;
import com.kong.kcinside.user.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final ModelMapper modelMapper;
	
	@Autowired
	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.modelMapper = modelMapper;
	}
	
	public UserDTO findUserById(int id) {
		
		return modelMapper.map(userRepository.getById(id), UserDTO.class);
	}
	
	public List<UserDTO> findAllUser() {
		
        return userRepository.findAll().stream()
        		.map(user -> modelMapper.map(user, UserDTO.class)).collect(Collectors.toList());
	}
	
	public int signUp(UserDTO new_user) {
				
		User user = User.builder()
				.username(new_user.getUsername())
				.email(new_user.getEmail())
				.password(passwordEncoder.encode(new_user.getPassword()))
				.phone(new_user.getPhone())
				.status(1)
				.build();
		
		System.out.println(user.toString());

		return userRepository.save(user).getId();
	}
}
