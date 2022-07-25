package com.hamitmizrak.atm.sql.dto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SafeDto {
	
	// kasadaki para miktarý
	public static double amount = 1000;
	
	// parametresiz constructor
	public SafeDto() {
	}
	
	// parametreli constructor
	public SafeDto(double amount) {
		SafeDto.amount = amount;
	}
	
	// getter and setter
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		if (amount <= 0) {
			System.out.println("Öncelikle Kasaya para eklemelisiniz");
		} else {
			SafeDto.amount = amount;
		}
	}
	
}
