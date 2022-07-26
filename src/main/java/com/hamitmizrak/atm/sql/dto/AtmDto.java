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
		// kullanýcýdan alacaðým password
		String userPassword;
		
		// login giriþ hakký 3
		int counter = 3;
		
		// kullanýcý doðru girene kadar sisteme giriþ yapýlacak 3 hakkýmýz bulunuyor.
		while (counter > 0) {
			System.out.println("Lütfen Þifreyi Giriniz");
			userPassword = klavye.nextLine();
			registerDto.setRegisterPassword(userPassword);
			registerDto2 = registerDao.isThereUser(registerDto);
			
			if (registerDto2 != null) {
				if (registerDto2.getRegisterPassword().equals(userPassword)) {
					System.out.println("Bank Seçime Yönlendiriliyorsunuz");
					secim();
					return true;
				}
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
			System.out.println("\nSeçim yapýnýz");
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
					System.out.println("Atm Çýkýþ Yapýlýyor\n devam etmek icin bir tusa basiniz");
					klavye.hasNext();
					AvmDto avmDto = new AvmDto();
					avmDto.avmMain();
					break;
				
				default:
					System.out.println("Doðru seçim yapmadýnýz");
					// throw new IllegalArgumentException("Unexpected value: ");
					break;
			}
		}
	}
	
	// HAVALE
	private void havale() {
		System.out.println("**********Havale Ýþlemleri***********");
		HavaleDto havaleDto = new HavaleDto();
		System.out.println("Havale Adýný giriniz");
		havaleDto.setHavaleName(klavye.nextLine());
		System.out.println("Havale Miktarýný giriniz");
		double amout = klavye.nextDouble();
		havaleDto.setHavaleAmount(amout);
		System.out.println("Yapýlan Havale adý: " + havaleDto.getHavaleName());
		System.out.println("Yapýlan Havale Miktarý: " + havaleDto.getHavaleAmount());
		kasa.amount -= havaleDto.getHavaleAmount();
		System.out.println("Kalan Miktarýnýz: " + kasa.amount);
	}
	
	// EFT
	private void eft() {
		System.out.println("**********Eft Ýþlemleri***********");
		EftDto eftDto = new EftDto();
		System.out.println("Eft Adýný giriniz");
		eftDto.setEftName(klavye.nextLine());
		System.out.println("Eft Miktarýný giriniz");
		double amout = klavye.nextDouble();
		eftDto.setEftAmount(amout);
		System.out.println("Yapýlan Eft adý: " + eftDto.getEftName());
		System.out.println("Yapýlan Eft Miktarý: " + eftDto.getEftAmount());
		kasa.amount -= eftDto.getEftAmount();
		System.out.println("Kalan Miktarýnýz: " + kasa.amount);
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
		kasa.amount += addMoney;
		System.out.println("Bakiyeniz: " + kasa.getAmount());
		
	}
	
	@Override
	public void paraCek() {
		Scanner klavye = new Scanner(System.in);
		System.out.println("Para Çekilecek miktarý yazýnýz");
		double reduceMoney = klavye.nextDouble();
		
		// ek hesaptan en fazla -1000 kadar gidebilir.
		if (kasa.amount <= 0) {
			System.out.println("Öncelikle Para eklemelisiniz");
		} else if (reduceMoney >= 5000) {
			System.out.println(
					" çekeceðiniz miktar " + reduceMoney + "ancak Tek seferde 5000 TL kadar  Para çekebilirsiniz");
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
