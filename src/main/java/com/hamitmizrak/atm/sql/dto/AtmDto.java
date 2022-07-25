package com.hamitmizrak.atm.sql.dto;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.hamitmizrak.atm.IAtm;

public class AtmDto implements IAtm {
	
	LoginDto loginDto;
	SafeDto kasa;
	
	public AtmDto() {
		loginDto = new LoginDto();
		kasa = new SafeDto();
	}
	
	@Override
	public boolean bankGiris() {
		// database login bilgisi
		String databasePassword = loginDto.getUserPassword();
		
		// kullanýcýdan alacaðým password
		String userPassord;
		
		// login giriþ hakký 3
		int counter = 3;
		
		// kullanýcý doðru girene kadar sisteme giriþ yapýlacak 3 hakkýmýz bulunuyor.
		while (counter > 0) {
			userPassord = JOptionPane.showInputDialog("Lütfen þifre giriniz");
			if (databasePassword.equals(userPassord)) {
				System.out.println("Bank Seçime Yönlendiriliyorsunuz");
				secim();
				return true;
			}
			counter--;
			System.out.println("Kalan hakkýnýz: " + counter);
			if (counter <= 0) {
				System.out.println("Kartýnýz bloke oldu: Müþteri Hizmetlerini aramamý ister misiniz\n çýkýþ yapýlýyor");
				System.exit(0);
			}
		}
		return false;
	}
	
	@Override
	public void secim() {
		while (true) {
			System.out.println("Seçim yapýnýz");
			System.out.println("1-)Ozet\n2-)Para Ekle\n3-)Para Cek\n4-)Cikis");
			Scanner klavye = new Scanner(System.in);
			int chooise = klavye.nextInt();
			
			switch (chooise) {
				case 1:
					ozet();
					break;
				
				case 2:
					paraEkle();
					break;
				
				case 3:
					paraCek();
					break;
				
				case 4:
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
	
	@Override
	public void kasa() {
		// SafeDto kasa = new SafeDto();
		
	}
	
	@Override
	public void ozet() {
		System.out.println("Ozet");
		System.out.println("Bakiyeniz: " + kasa.getAmount());
	}
	
	@Override
	public void paraEkle() {
		Scanner klavye = new Scanner(System.in);
		System.out.println("Eklenecek Para miktarý yazýnýz");
		double addMoney = klavye.nextDouble();
		SafeDto.amount += addMoney;
		System.out.println("Bakiyeniz: " + kasa.getAmount());
		
	}
	
	@Override
	public void paraCek() {
		Scanner klavye = new Scanner(System.in);
		System.out.println("Para Çekilecek miktarý yazýnýz");
		double reduceMoney = klavye.nextDouble();
		
		// ek hesaptan en fazla -1000 kadar gidebilir.
		if (SafeDto.amount <= 0) {
			System.out.println("Öncelikle Para eklemelisiniz");
		} else if (reduceMoney >= 5000) {
			System.out.println(
					" çekeceðiniz miktar " + reduceMoney + "ancak Tek seferde 5000 TL kadar  Para çekebilirsiniz");
		} else {
			SafeDto.amount -= reduceMoney;
			System.out.println("Bakiyeniz: " + kasa.getAmount());
		}
		
	}
	
	public static void main(String[] args) {
		AtmDto atmDto = new AtmDto();
		atmDto.bankGiris();
	}
	
}
