package com.hamitmizrak.atm.sql.dto;

public class CustomerDto extends BaseEntity {
	
	private String userName;
	private String userSurname;
	private String userPassword;
	
	public CustomerDto() {
	}
	
	public CustomerDto(String userName, String userSurname, String userPassword) {
		this.userName = userName;
		this.userSurname = userSurname;
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserSurname() {
		return userSurname;
	}
	
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
