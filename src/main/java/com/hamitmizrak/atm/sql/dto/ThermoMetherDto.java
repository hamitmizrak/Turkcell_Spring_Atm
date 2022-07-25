package com.hamitmizrak.atm.sql.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThermoMetherDto extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	private double number;
	
	public ThermoMetherDto() {
		super();
	}
	
	public ThermoMetherDto(double number) {
		super();
		this.number = number;
	}
	
	// Result isLogin
	public boolean isLogin() {
		if (number <= 36.5)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		ThermoMetherDto dto = new ThermoMetherDto();
		dto.setNumber(38);
		boolean result = dto.isLogin();
		System.out.println(result);
	}
	
}
