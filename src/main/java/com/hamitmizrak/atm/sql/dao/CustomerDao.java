package com.hamitmizrak.atm.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.hamitmizrak.atm.sql.dto.CustomerDto;

public class CustomerDao implements IDaoConnection<CustomerDto> {
	
	@Override
	public void create(CustomerDto t) {
		
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into customer () values ()";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	@Override
	public void update(CustomerDto t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void delete(CustomerDto t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public ArrayList<CustomerDto> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
