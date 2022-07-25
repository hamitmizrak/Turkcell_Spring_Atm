package com.hamitmizrak.atm.sql.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
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
	
	// parametreli constructor
	public BankDto(Long id, String bankName, String branchName) {
		super(id);
		this.bankName = bankName;
		this.branchName = branchName;
	}
	
}
