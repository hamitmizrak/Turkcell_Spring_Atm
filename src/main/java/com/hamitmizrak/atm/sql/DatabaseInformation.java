package com.hamitmizrak.atm.sql;

import lombok.Data;

@Data
abstract public class DatabaseInformation {
	
	// Object field
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
		// this.url = "jdbc:mysql://localhostt:3306/turkcell_db";
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
	
	// toString
	// HashCode
	// getter and setter
	
}
