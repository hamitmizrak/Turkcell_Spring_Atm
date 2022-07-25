package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class CustomerDto extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	// Object variable
	private String userName;
	private String userSurname;
	private String userPassword;
	
	// parametresiz constructor
	public CustomerDto() {
	}
	
	// parametreli constructor
	public CustomerDto(String userName, String userSurname, String userPassword) {
		this.userName = userName;
		this.userSurname = userSurname;
		this.userPassword = userPassword;
	}
	
}
