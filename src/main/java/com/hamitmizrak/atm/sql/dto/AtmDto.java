package com.hamitmizrak.atm.sql.dto;

import java.util.Scanner;

import com.hamitmizrak.atm.IAtm;
import com.hamitmizrak.atm.sql.dao.RegisterDao;

public class AtmDto implements IAtm {
	
	// object variable
	RegisterDto loginDto;
	SafeDto kasa;
	Scanner klavye;
	RegisterDto registerDto;
	RegisterDao registerDao;
	RegisterDto registerDto2;
	
	// parametresiz constructor
	public AtmDto() {
		loginDto = new RegisterDto();
		kasa = new SafeDto();
		klavye = new Scanner(System.in);
		registerDto = new RegisterDto();
		registerDao = new RegisterDao();
		registerDto2 = new RegisterDto();
	}
	
	// database login bilgisi
	@Override
	public boolean bankGiris() {
		// kullan�c�dan alaca��m password
		String userPassword;
		
		// login giri� hakk� 3
		int counter = 3;
		
		// kullan�c� do�ru girene kadar sisteme giri� yap�lacak 3 hakk�m�z bulunuyor.
		while (counter > 0) {
			System.out.println("L�tfen �ifreyi Giriniz");
			userPassword = klavye.nextLine();
			registerDto.setRegisterPassword(userPassword);
			registerDto2 = registerDao.isThereUser(registerDto);
			
			if (registerDto2 != null) {
				if (registerDto2.getRegisterPassword().equals(userPassword)) {
					System.out.println("Bank Se�ime Y�nlendiriliyorsunuz");
					secim();
					return true;
				}
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
			System.out.println("\nSe�im yap�n�z");
			System.out.println("1-)Ozet\n2-)Para Ekle\n3-)Para Cek\n4-)EFT\n5-)HAVALE\n6-)Cikis");
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
					eft();
					break;
				case 5:
					havale();
					break;
				
				case 6:
					System.out.println("Atm ��k�� Yap�l�yor\n devam etmek icin bir tusa basiniz");
					klavye.hasNext();
					AvmDto avmDto = new AvmDto();
					avmDto.avmMain();
					break;
				
				default:
					System.out.println("Do�ru se�im yapmad�n�z");
					// throw new IllegalArgumentException("Unexpected value: ");
					break;
			}
		}
	}
	
	// HAVALE
	private void havale() {
		System.out.println("**********Havale ��lemleri***********");
		HavaleDto havaleDto = new HavaleDto();
		System.out.println("Havale Ad�n� giriniz");
		havaleDto.setHavaleName(klavye.nextLine());
		System.out.println("Havale Miktar�n� giriniz");
		double amout = klavye.nextDouble();
		havaleDto.setHavaleAmount(amout);
		System.out.println("Yap�lan Havale ad�: " + havaleDto.getHavaleName());
		System.out.println("Yap�lan Havale Miktar�: " + havaleDto.getHavaleAmount());
		kasa.amount -= havaleDto.getHavaleAmount();
		System.out.println("Kalan Miktar�n�z: " + kasa.amount);
	}
	
	// EFT
	private void eft() {
		System.out.println("**********Eft ��lemleri***********");
		EftDto eftDto = new EftDto();
		System.out.println("Eft Ad�n� giriniz");
		eftDto.setEftName(klavye.nextLine());
		System.out.println("Eft Miktar�n� giriniz");
		double amout = klavye.nextDouble();
		eftDto.setEftAmount(amout);
		System.out.println("Yap�lan Eft ad�: " + eftDto.getEftName());
		System.out.println("Yap�lan Eft Miktar�: " + eftDto.getEftAmount());
		kasa.amount -= eftDto.getEftAmount();
		System.out.println("Kalan Miktar�n�z: " + kasa.amount);
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
		kasa.amount += addMoney;
		System.out.println("Bakiyeniz: " + kasa.getAmount());
		
	}
	
	@Override
	public void paraCek() {
		Scanner klavye = new Scanner(System.in);
		System.out.println("Para �ekilecek miktar� yaz�n�z");
		double reduceMoney = klavye.nextDouble();
		
		// ek hesaptan en fazla -1000 kadar gidebilir.
		if (kasa.amount <= 0) {
			System.out.println("�ncelikle Para eklemelisiniz");
		} else if (reduceMoney >= 5000) {
			System.out.println(
					" �ekece�iniz miktar " + reduceMoney + "ancak Tek seferde 5000 TL kadar  Para �ekebilirsiniz");
		} else {
			kasa.amount -= reduceMoney;
			System.out.println("Bakiyeniz: " + kasa.getAmount());
		}
		
	}
	
	public static void main(String[] args) {
		AtmDto atmDto = new AtmDto();
		atmDto.bankGiris();
	}
	
}
