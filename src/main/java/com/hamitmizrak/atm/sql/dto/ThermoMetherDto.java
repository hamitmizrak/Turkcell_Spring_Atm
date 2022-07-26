package com.hamitmizrak.atm.sql.dto;

import java.util.Scanner;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ThermoMetherDto extends BaseEntity {
	// serial
	private static final long serialVersionUID = 1L;
	
	// object variable
	private double number;
	Scanner klavye;
	
	// parametresiz constructor
	public ThermoMetherDto() {
		super();
		klavye = new Scanner(System.in);
	}
	
	// parametreli constructor
	public ThermoMetherDto(double number) {
		super();
		this.number = number;
	}
	
	// Result isLogin
	public boolean isLogin() {
		System.out.println("Ateþ sayýsýný giriniz.");
		number = klavye.nextDouble();
		if (number <= 36.5)
			return false;
		else
			return true;
	}
	
	// TEST
	public static void main(String[] args) {
		ThermoMetherDto dto = new ThermoMetherDto();
		dto.setNumber(38);
		boolean result = dto.isLogin();
		System.out.println(result);
	}
	
}
