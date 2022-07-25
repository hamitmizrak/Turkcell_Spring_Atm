package com.hamitmizrak.atm;

// B�t�n bankalarda ortak methodlar
public interface IBank {
	
	// para g�r�nt�meleme
	public void showMoney();
	
	// para Ekleme
	public void addMoney();
	
	// para �ekme
	public void reduceMoney();
	
	// Havale yapmak
	public void sendHavaleMoney();
	
	// Eft yapmak
	public void sendEftMoney();
	
	// Mail G�ndermek
	public void sendMail();
	
}
