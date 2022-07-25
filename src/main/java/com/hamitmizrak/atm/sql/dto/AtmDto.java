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
		
		// kullan�c�dan alaca��m password
		String userPassord;
		
		// login giri� hakk� 3
		int counter = 3;
		
		// kullan�c� do�ru girene kadar sisteme giri� yap�lacak 3 hakk�m�z bulunuyor.
		while (counter > 0) {
			userPassord = JOptionPane.showInputDialog("L�tfen �ifre giriniz");
			if (databasePassword.equals(userPassord)) {
				System.out.println("Bank Se�ime Y�nlendiriliyorsunuz");
				secim();
				return true;
			}
			counter--;
			System.out.println("Kalan hakk�n�z: " + counter);
			if (counter <= 0) {
				System.out.println("Kart�n�z bloke oldu: M��teri Hizmetlerini aramam� ister misiniz\n ��k�� yap�l�yor");
				System.exit(0);
			}
		}
		return false;
	}
	
	@Override
	public void secim() {
		while (true) {
			System.out.println("Se�im yap�n�z");
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
					System.out.println("Atm ��k�� Yap�l�yor");
					System.exit(0);
					break;
				
				default:
					System.out.println("Do�ru se�im yapmad�n�z");
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
		System.out.println("Eklenecek Para miktar� yaz�n�z");
		double addMoney = klavye.nextDouble();
		SafeDto.amount += addMoney;
		System.out.println("Bakiyeniz: " + kasa.getAmount());
		
	}
	
	@Override
	public void paraCek() {
		Scanner klavye = new Scanner(System.in);
		System.out.println("Para �ekilecek miktar� yaz�n�z");
		double reduceMoney = klavye.nextDouble();
		
		// ek hesaptan en fazla -1000 kadar gidebilir.
		if (SafeDto.amount <= 0) {
			System.out.println("�ncelikle Para eklemelisiniz");
		} else if (reduceMoney >= 5000) {
			System.out.println(
					" �ekece�iniz miktar " + reduceMoney + "ancak Tek seferde 5000 TL kadar  Para �ekebilirsiniz");
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
