package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class BankDto extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	// Object variable
	private String bankName;
	private String branchName;
	
	// parametresiz constructor
	public BankDto() {
	}
	
	// parametreli constructor
	
	public BankDto(String bankName, String branchName) {
		super();
		this.bankName = bankName;
		this.branchName = branchName;
	}
	
}
