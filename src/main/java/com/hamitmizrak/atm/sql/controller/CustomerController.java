package com.hamitmizrak.atm.sql.controller;

import java.util.ArrayList;
import java.util.List;

import com.hamitmizrak.atm.sql.dao.CustomerDao;
import com.hamitmizrak.atm.sql.dto.CustomerDto;

public class CustomerController implements IControllerBank<CustomerDto> {
	
	// object variable
	CustomerDao customerDao;
	
	// parametresiz constructor
	public CustomerController() {
		this.customerDao = new CustomerDao();
	}
	
	@Override
	public void create(CustomerDto customerDto) {
		customerDao.create(customerDto);
		
	}
	
	@Override
	public void update(CustomerDto customerDto) {
		customerDao.update(customerDto);
		
	}
	
	@Override
	public void delete(CustomerDto customerDto) {
		customerDao.delete(customerDto);
		
	}
	
	@Override
	public ArrayList<CustomerDto> list() {
		return customerDao.list();
	}
	
	public static void main(String[] args) {
		CustomerController customerController = new CustomerController();
		
		// 1- Bank Ekleyeceðiz
		// 2- Customer 2 tane kayýt
		// 3- inner joinler pgAdmin sorgusunun atalalým
		// 4- Java MEthodunda 3 adýmý yazalým ?
		
		// INSERT
		// CustomerDto customerDto = BankDto.builder().bankName("Banka
		// 44").branchName("Malatya").build();
		// bankController.create(customerDto);
		
		// UPDATE
		// Long id, Date createdDate, String bankName, String branchName
		// BankDto bankDto = new BankDto(1L, "Bank 23", "þube 23");
		// bankController.update(bankDto);
		
		// DELETE
		// BankDto bankDto = new BankDto();
		// bankDto.setId(2L);
		// bankController.delete(bankDto);
		
		// LIST
		List<CustomerDto> listem = customerController.list();
		listem.forEach(System.out::println);
		
	}
}
