package com.hamitmizrak.atm.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.hamitmizrak.atm.sql.dto.BankDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BankDao implements IDaoConnection<BankDto> {
	
	// private String userName;
	// private String userSurname;
	// private String userPassword;
	
	// CREATE
	@Override
	public void create(BankDto banDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into customer () values ()";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banDto.getBankName());
			preparedStatement.setString(2, banDto.getBranchName());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(BankDto.class + " Ekleme Baþarýlý");
			} else {
				log.error(BankDto.class + " !!!! Ekleme Baþarýsýz");
			}
		} catch (Exception e) {
			log.error(BankDto.class + " !!!! Ekleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// UPDATE
	@Override
	public void update(BankDto banDto) {
		// TODO Auto-generated method stub
		
	}
	
	// DELETE
	@Override
	public void delete(BankDto banDto) {
		// TODO Auto-generated method stub
		
	}
	
	// LÝST
	@Override
	public ArrayList<BankDto> list() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
