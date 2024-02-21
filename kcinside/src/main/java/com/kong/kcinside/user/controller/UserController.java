package com.kong.kcinside.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kong.kcinside.user.dto.UserDTO;
import com.kong.kcinside.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User API", description = "")
@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Operation(summary = "전체 회원 조회", description = "전체 회원을 조회합니다.")
	@Parameter()
	@GetMapping("")
	public ResponseEntity<?> findAllUser() {
		
		System.out.println("call api /user");
		
		List<UserDTO> userList = userService.findAllUser();
		
		System.out.println(userList);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<>(userList, headers, HttpStatus.OK);
	}
	
	@Operation(summary = "회원 조회", description = "회원을 조회합니다.")
	@Parameter(name = "회원 번호")
	@GetMapping("/{id}")
	public ResponseEntity<?> findUserById(@PathVariable(name="id") int id) {
		
		System.out.println("call api /user/{id}");
		
		UserDTO user = userService.findUserById(id);
		System.out.println(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<>(user, headers, HttpStatus.OK);
	}
	
    @Operation(summary = "회원가입", description = "회원가입을 합니다.")
    @Parameter(name = "회원 정보", description = "")
    @PostMapping("")
    public ResponseEntity<?> signUp(@RequestBody UserDTO user) {
    	
    	System.out.println(user);
    	userService.signUp(user);
    	
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
    }
}
