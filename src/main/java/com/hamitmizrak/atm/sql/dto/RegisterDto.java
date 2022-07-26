package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class RegisterDto extends BaseEntity {
	
	private String registerName;
	private String registerSurname;
	private String registerPassword;
	private String registerEmailAddress;
	
	public RegisterDto() {
		super();
	}
	
	public RegisterDto(Long id, String registerName, String registerSurname, String registerPassword,
			String registerEmailAddress) {
		super(id);
		this.registerName = registerName;
		this.registerSurname = registerSurname;
		this.registerPassword = registerPassword;
		this.registerEmailAddress = registerEmailAddress;
	}
	
}
