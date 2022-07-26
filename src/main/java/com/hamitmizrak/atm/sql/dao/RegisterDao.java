package com.hamitmizrak.atm.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hamitmizrak.atm.sql.dto.RegisterDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class RegisterDao implements IDaoConnection<RegisterDto> {
	
	// Database user search
	public RegisterDto isThereUser(RegisterDto registerDto) {
		RegisterDto registerDto2 = null;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select * from register where register_password='" + registerDto.getRegisterPassword() + "'";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				registerDto2 = new RegisterDto();
				registerDto2.setId(resultSet.getLong("register_id"));
				registerDto2.setRegisterName(resultSet.getString("register_name"));
				registerDto2.setRegisterSurname(resultSet.getString("register_surname"));
				registerDto2.setRegisterPassword(resultSet.getString("register_password"));
				registerDto2.setRegisterEmailAddress(resultSet.getString("register_email_address"));
				registerDto2.setCreatedDate(resultSet.getDate("created_date"));
			}
		} catch (Exception e) {
			log.error(RegisterDto.class + " !!!! Sorgulama sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		return registerDto2;
	}
	
	// CREATE
	@Override
	public void create(RegisterDto registerDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into  register (register_name,register_surname,register_password,register_email_address) values (?,?,?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, registerDto.getRegisterName());
			preparedStatement.setString(2, registerDto.getRegisterSurname());
			preparedStatement.setString(3, registerDto.getRegisterPassword());
			preparedStatement.setString(4, registerDto.getRegisterEmailAddress());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(RegisterDto.class + " Ekleme Baþarýlý");
			} else {
				log.error(RegisterDto.class + " !!!! Ekleme Baþarýsýz");
			}
		} catch (Exception e) {
			log.error(RegisterDto.class + " !!!! Ekleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// UPDATE
	@Override
	public void update(RegisterDto registerDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update bank set bank_name=?,branch_name=? where bank_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, registerDto.getRegisterName());
			preparedStatement.setString(2, registerDto.getRegisterSurname());
			preparedStatement.setString(3, registerDto.getRegisterPassword());
			preparedStatement.setString(4, registerDto.getRegisterEmailAddress());
			preparedStatement.setLong(5, registerDto.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(RegisterDto.class + " Güncelleme Baþarýlý");
			} else {
				log.error(RegisterDto.class + " !!!! Güncelleme Baþarýsýz");
			}
		} catch (Exception e) {
			log.error(RegisterDto.class + " !!!! Güncelleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	// DELETE
	@Override
	public void delete(RegisterDto registerDto) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from  bank  where bank_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, registerDto.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(RegisterDto.class + " Silme Baþarýlý");
			} else {
				log.error(RegisterDto.class + " !!!! Silme Baþarýsýz");
			}
		} catch (Exception e) {
			log.error(RegisterDto.class + " !!!! Silme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// LÝST
	// SELECT
	@Override
	public ArrayList<RegisterDto> list() {
		ArrayList<RegisterDto> list = new ArrayList<RegisterDto>();
		RegisterDto registerDto;
		
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from  bank;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				registerDto = new RegisterDto();
				registerDto.setId(resultSet.getLong("register_id"));
				registerDto.setRegisterName(resultSet.getString("register_name"));
				registerDto.setRegisterSurname(resultSet.getString("register_surname"));
				registerDto.setRegisterPassword(resultSet.getString("register_password"));
				registerDto.setRegisterEmailAddress(resultSet.getString("register_email_address"));
				registerDto.setCreatedDate(resultSet.getDate("created_date"));
				list.add(registerDto);
			}
		} catch (Exception e) {
			log.error(RegisterDto.class + " !!!! Silme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		return list;
	}
	
}
