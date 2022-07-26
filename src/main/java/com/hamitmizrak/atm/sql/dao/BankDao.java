package com.hamitmizrak.atm.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.hamitmizrak.atm.sql.dto.BankDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class BankDao implements IDaoConnection<BankDto> {
	
	// CREATE
	@Override
	public void create(BankDto banDto) {
		try (Connection connection = getInterfaceConnection()) {
			connection.setAutoCommit(false);
			String sql = "insert into  bank (bank_name,branch_name) values (?,?);";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banDto.getBankName());
			preparedStatement.setString(2, banDto.getBranchName());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(BankDto.class + " Ekleme Baþarýlý");
				connection.commit();
			} else {
				log.error(BankDto.class + " !!!! Ekleme Baþarýsýz");
				connection.rollback();
			}
		} catch (Exception e) {
			log.error(BankDto.class + " !!!! Ekleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// UPDATE
	@Override
	public void update(BankDto banDto) {
		try (Connection connection = getInterfaceConnection()) {
			connection.setAutoCommit(false);
			String sql = "update bank set bank_name=?,branch_name=? where bank_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, banDto.getBankName());
			preparedStatement.setString(2, banDto.getBranchName());
			preparedStatement.setLong(3, banDto.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(BankDto.class + " Güncelleme Baþarýlý");
				connection.commit();
			} else {
				log.error(BankDto.class + " !!!! Güncelleme Baþarýsýz");
				connection.rollback();
			}
		} catch (Exception e) {
			log.error(BankDto.class + " !!!! Güncelleme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	// DELETE
	@Override
	public void delete(BankDto banDto) {
		try (Connection connection = getInterfaceConnection()) {
			connection.setAutoCommit(false);
			String sql = "delete from  bank  where bank_id=?;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, banDto.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				log.info(BankDto.class + " Silme Baþarýlý");
				connection.commit();
			} else {
				log.error(BankDto.class + " !!!! Silme Baþarýsýz");
				connection.rollback();
			}
		} catch (Exception e) {
			log.error(BankDto.class + " !!!! Silme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	// LÝST
	// SELECT
	@Override
	public ArrayList<BankDto> list() {
		ArrayList<BankDto> list = new ArrayList<BankDto>();
		BankDto bankDto;
		
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from  bank;";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				bankDto = new BankDto();
				bankDto.setId(resultSet.getLong("bank_id"));
				bankDto.setBankName(resultSet.getString("bank_name"));
				bankDto.setBranchName(resultSet.getString("branch_name"));
				bankDto.setCreatedDate(resultSet.getDate("created_date"));
				list.add(bankDto);
			}
		} catch (Exception e) {
			log.error(BankDto.class + " !!!! Silme sýrasýnda hata meydana geldi");
			e.printStackTrace();
		}
		return list;
	}
	
}
