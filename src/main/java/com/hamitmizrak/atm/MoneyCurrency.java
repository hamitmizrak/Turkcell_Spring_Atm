package com.hamitmizrak.atm;

// para birimi
public enum MoneyCurrency {
	TR(1, "tr"), EN(2, "en"), GE(3, "ge");
	
	private final int number;
	private final String curr;
	
	private MoneyCurrency(int number, String curr) {
		this.number = number;
		this.curr = curr;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getCurr() {
		return curr;
	}
	
}
