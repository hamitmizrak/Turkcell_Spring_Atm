package com.hamitmizrak.atm.sql.dto;

import java.util.Scanner;

public class AvmDto {
	
	ThermoMetherDto metherDto;
	
	// parametresiz constructor
	public AvmDto() {
		this.metherDto = new ThermoMetherDto();
	}
	
	public void avmMain() {
		if (metherDto.isLogin()) {
			System.out.println("Ateþiniz Çok Yüksek Hastane Gitmelisiniz Avm Giremezsiniz");
			System.exit(0);
			;
		} else {
			while (true) {
				System.out.println("Seçim yapýnýz");
				System.out.println("1-)ATM\n2-)YEMEK\n3-)KÜTÜPHANE\n4-)SÝNEMA\n5-)BOWLING\n6-)Cikis");
				Scanner klavye = new Scanner(System.in);
				int chooise = klavye.nextInt();
				
				switch (chooise) {
					case 1:
						System.out.println("Atm Giriþ");
						AtmDto atmDto = new AtmDto();
						atmDto.bankGiris();
						break;
					
					case 2:
						yemek();
						break;
					
					case 3:
						kutuphane();
						break;
					case 4:
						sinema();
						break;
					case 5:
						bowling();
						break;
					
					case 6:
						System.out.println("Atm Çýkýþ Yapýlýyor");
						System.exit(0);
						break;
					
					default:
						System.out.println("Doðru seçim yapmadýnýz");
						// throw new IllegalArgumentException("Unexpected value: ");
						break;
				}
			}
		}
	}
	
	private void bowling() {
		// TODO Auto-generated method stub
		
	}
	
	private void sinema() {
		// TODO Auto-generated method stub
		
	}
	
	private void kutuphane() {
		// TODO Auto-generated method stub
		
	}
	
	private void yemek() {
		// TODO Auto-generated method stub
		
	}
	
}
