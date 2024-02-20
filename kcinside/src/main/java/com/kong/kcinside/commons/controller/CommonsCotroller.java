package com.kong.kcinside.commons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

//import com.solvit.cryptoserver.user.dto.UserDTO;
//import com.solvit.cryptoserver.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@Controller
public class CommonsCotroller {

//	private final UserService userService;
//	
//	@Autowired
//	public CommonsCotroller(UserService userService) {
//		this.userService = userService;
//	}
	
    @Operation(summary = "index view", description = "index 화면으로 이동합니다.")
//    @Parameter(name = "", description = "")
	@GetMapping("/")
	public String index() {
		System.out.println("call index...");
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "commons/login";
	}
	
//	@PostMapping("/signup")
//	public String signup(UserDTO user) {
//		
//		return "redirect:/login";
//	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		new SecurityContextLogoutHandler().logout(request, response,
				SecurityContextHolder.getContext().getAuthentication());
		
		return "redirect:/commons/auth/login";
	}
}
