package com.kong.kcinside.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfiguration {

//	@Autowired
//	UserDetailsService userService;
	
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
				.authorizeRequests()
				.anyRequest().permitAll();
		return http.build();
	}
    
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() throws Exception {
//    	DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//    	
//    	daoAuthenticationProvider.setUserDetailsService(userService);
//    	daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//    	
//    	return daoAuthenticationProvider;
//    }
}
