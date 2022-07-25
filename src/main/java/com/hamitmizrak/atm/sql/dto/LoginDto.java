package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class LoginDto {
	
	private String userName;
	private String userPassword;
	private String userEmailAddress;
	
	public LoginDto() {
		this.userEmailAddress = "root";
		this.userPassword = "root";
	}
	
	public LoginDto(String userName, String userPassword, String userEmailAddress) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmailAddress = userEmailAddress;
	}
	
}
