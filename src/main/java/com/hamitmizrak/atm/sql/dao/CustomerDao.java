package com.hamitmizrak.atm.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.hamitmizrak.atm.sql.dto.CustomerDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomerDao implements IDaoConnection<CustomerDto> {
	
	// private String userName;
	// private String userSurname;
	// private String userPassword;
	
	// CREATE
	@Override
	public void create(CustomerDto customerDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into customer () values ()";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerDto.getUserName());
			preparedStatement.setString(2, customerDto.getUserSurname());
			preparedStatement.setString(3, customerDto.getUserPassword());
			
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(CustomerDto.class + " Ekleme Baþarýlý");
			} else {
				log.error(CustomerDto.class + " !!!! Ekleme Baþarýsýz");
			}
		} catch (Exception e) {
			log.error(CustomerDto.class + " !!!! Ekleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// UPDATE
	@Override
	public void update(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}
	
	// DELETE
	@Override
	public void delete(CustomerDto customerDto) {
		// TODO Auto-generated method stub
		
	}
	
	// LÝST
	@Override
	public ArrayList<CustomerDto> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
