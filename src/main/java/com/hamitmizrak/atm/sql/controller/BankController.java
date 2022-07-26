package com.hamitmizrak.atm.sql.controller;

import java.util.ArrayList;
import java.util.List;

import com.hamitmizrak.atm.sql.dao.BankDao;
import com.hamitmizrak.atm.sql.dto.BankDto;

public class BankController implements IControllerBank<BankDto> {
	
	// object variable
	BankDao bankDao;
	
	// parametresiz constructor
	public BankController() {
		this.bankDao = new BankDao();
	}
	
	@Override
	public void create(BankDto bankDto) {
		bankDao.create(bankDto);
		
	}
	
	@Override
	public void update(BankDto bankDto) {
		bankDao.update(bankDto);
		
	}
	
	@Override
	public void delete(BankDto bankDto) {
		bankDao.delete(bankDto);
		
	}
	
	@Override
	public ArrayList<BankDto> list() {
		return bankDao.list();
	}
	
	public static void main(String[] args) {
		BankController bankController = new BankController();
		
		// INSERT
		// BankDto bankDto = BankDto.builder().bankName("Banka
		// 44").branchName("Malatya").build();
		// bankController.create(bankDto);
		
		// UPDATE
		// Long id, Date createdDate, String bankName, String branchName
		// BankDto bankDto = new BankDto(1L, "Bank 23", "þube 23");
		// bankController.update(bankDto);
		
		// DELETE
		// BankDto bankDto = new BankDto();
		// bankDto.setId(2L);
		// bankController.delete(bankDto);
		
		// LIST
		List<BankDto> listem = bankController.list();
		listem.forEach(System.out::println);
		
	}
}
