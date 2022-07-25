package com.hamitmizrak.atm;

// Bütün bankalarda ortak methodlar
public interface IBank {
	
	// para görüntümeleme
	public void showMoney();
	
	// para Ekleme
	public void addMoney();
	
	// para çekme
	public void reduceMoney();
	
	// Havale yapmak
	public void sendHavaleMoney();
	
	// Eft yapmak
	public void sendEftMoney();
	
	// Mail Göndermek
	public void sendMail();
	
}
