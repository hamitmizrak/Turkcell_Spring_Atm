package com.hamitmizrak.atm.sql;

import java.util.Objects;

abstract public class DatabaseInformation {
	
	// class field
	private String url;
	private String userName;
	private String userPassword;
	private String forNameData;
	
	// parametresiz constructor
	public DatabaseInformation() {
		// postgresql
		this.url = "jdbc:postgresql://localhost:5432/turkcell_db";
		this.userName = "postgres";
		this.userPassword = "root";
		this.forNameData = "org.postgresql.Driver";
		
		// mysql
		// this.url = "jdbc:mysql://localhostİ:3306/turkcell_db";
		// this.userName = "postgres";
		// this.userPassword = "root";
		// this.forNameData = "com.mysql.jdbc.Driver";
	}
	
	// parametreli constructor
	public DatabaseInformation(String url, String userName, String userPassword, String forNameData) {
		this.url = url;
		this.userName = userName;
		this.userPassword = userPassword;
		this.forNameData = forNameData;
	}
	
	@Override
	public String toString() {
		return "DatabaseInformation [url=" + url + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", forNameData=" + forNameData + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(forNameData, url, userName, userPassword);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatabaseInformation other = (DatabaseInformation) obj;
		return Objects.equals(forNameData, other.forNameData) && Objects.equals(url, other.url)
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword);
	}
	
	// getter and setter
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getForNameData() {
		return forNameData;
	}
	
	public void setForNameData(String forNameData) {
		this.forNameData = forNameData;
	}
	
}
