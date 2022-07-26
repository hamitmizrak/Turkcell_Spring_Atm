package com.hamitmizrak.atm.sql.dto;

import java.util.List;

import lombok.Data;

@Data
// Bank(1) Customer(N)
public class BankDto extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	// Object variable
	private String bankName;
	private String branchName;
	
	// composition
	List<CustomerDto> customerList;
	
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
