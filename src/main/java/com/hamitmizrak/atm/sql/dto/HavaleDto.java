package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class HavaleDto extends BaseEntity {
	private static final long serialVersionUID = 1L;
	
	private String havaleName;
	private double havaleAmount;
	
	// parametresiz constructor
	public HavaleDto() {
		super();
	}
	
	// parametreli constructor
	public HavaleDto(Long id, String havaleName, double havaleAmount) {
		super(id);
		this.havaleName = havaleName;
		this.havaleAmount = havaleAmount;
	}
	
}
