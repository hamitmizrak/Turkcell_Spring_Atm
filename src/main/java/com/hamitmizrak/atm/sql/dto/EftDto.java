package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class EftDto extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String eftName;
	private String eftAmount;
	
	public EftDto() {
		super();
	}
	
	public EftDto(Long id, String eftName, String eftAmount) {
		super(id);
		this.eftName = eftName;
		this.eftAmount = eftAmount;
	}
	
}
