package com.hamitmizrak.atm.sql.controller;

import java.util.ArrayList;

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
	
}
