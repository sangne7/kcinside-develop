package com.kong.kcinside.commons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kong.kcinside.user.dto.UserDTO;
import com.kong.kcinside.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

//import com.solvit.cryptoserver.user.dto.UserDTO;
//import com.solvit.cryptoserver.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name = "Commons API", description = "")
@RestController
public class CommonsCotroller {

	private final UserService userService;
	
	@Autowired
	public CommonsCotroller(UserService userService) {
		this.userService = userService;
	}

    @Operation(summary = "로그아웃", description = "로그아웃을 합니다.")
    @Parameter(name = "", description = "")
	@GetMapping("/logout")
    public ResponseEntity<Object> logout(HttpServletRequest request, HttpServletResponse response) {
    	new SecurityContextLogoutHandler().logout(request, response,
				SecurityContextHolder.getContext().getAuthentication());
    	
    	System.out.println("call api logout");
    	
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
