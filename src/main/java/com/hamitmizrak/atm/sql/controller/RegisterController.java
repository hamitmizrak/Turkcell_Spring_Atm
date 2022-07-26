package com.hamitmizrak.atm.sql.controller;

import java.util.ArrayList;
import java.util.List;

import com.hamitmizrak.atm.sql.dao.RegisterDao;
import com.hamitmizrak.atm.sql.dto.RegisterDto;

public class RegisterController implements IControllerBank<RegisterDto> {
	
	// object variable
	RegisterDao registerDao;
	
	// parametresiz constructor
	public RegisterController() {
		this.registerDao = new RegisterDao();
	}
	
	@Override
	public void create(RegisterDto registerDto) {
		registerDao.create(registerDto);
		
	}
	
	@Override
	public void update(RegisterDto registerDto) {
		registerDao.update(registerDto);
		
	}
	
	@Override
	public void delete(RegisterDto registerDto) {
		registerDao.delete(registerDto);
		
	}
	
	@Override
	public ArrayList<RegisterDto> list() {
		return registerDao.list();
	}
	
	public static void main(String[] args) {
		RegisterController bankController = new RegisterController();
		
		// INSERT
		// RegisterDto registerDto = RegisterDto.builder().bankName("Banka
		// 44").branchName("Malatya").build();
		// bankController.create(registerDto);
		
		// UPDATE
		// Long id, Date createdDate, String bankName, String branchName
		// RegisterDto registerDto = new RegisterDto(1L, "Bank 23", "þube 23");
		// bankController.update(registerDto);
		
		// DELETE
		// RegisterDto registerDto = new RegisterDto();
		// registerDto.setId(2L);
		// bankController.delete(registerDto);
		
		// LIST
		List<RegisterDto> listem = bankController.list();
		listem.forEach(System.out::println);
		
	}
}
