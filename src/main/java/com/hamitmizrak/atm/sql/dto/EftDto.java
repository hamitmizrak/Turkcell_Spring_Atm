package com.hamitmizrak.atm.sql.dto;

import lombok.Data;

@Data
public class EftDto extends BaseEntity {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String eftName;
	private double eftAmount;
	
	public EftDto() {
		super();
	}
	
	public EftDto(Long id, String eftName, double eftAmount) {
		super(id);
		this.eftName = eftName;
		this.eftAmount = eftAmount;
	}
	
}
