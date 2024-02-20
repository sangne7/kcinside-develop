package com.kong.kcinside.user.dto;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import net.bytebuddy.asm.Advice.Local;

public class UserDTO {
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String phone;
	private int status;
	
}
