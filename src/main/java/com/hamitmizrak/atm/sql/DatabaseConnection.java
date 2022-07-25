package com.hamitmizrak.atm.sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection extends DatabaseInformation {
	
	// database baÄlantÄ±sÄ± iÃ§in
	private Connection connection;
	
	// database bileÅenleri
	private String url = this.getUrl();
	private String userName = this.getUserName();
	private String userPassword = this.getUserPassword();
	private String forNameData = this.getForNameData();
	
	// singleton design pattern database connection
	private static DatabaseConnection instance;
	
	private DatabaseConnection() {
		try {
			Class.forName(forNameData);
			// System.out.println("Driver loading");
			connection = DriverManager.getConnection(url, userName, userPassword);
			// System.out.println("Database success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnection getInstance() {
		try {
			if (instance == null || instance.connection.isClosed())
				instance = new DatabaseConnection();
			
		} catch (Exception e) {
			System.err.println("instance error");
			e.printStackTrace();
		}
		return instance;
	}
	
	public static void setDatabaseConnection(DatabaseConnection databaseConnection) {
		DatabaseConnection.instance = databaseConnection;
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public static void main(String[] args) {
		// DatabaseConnection connection = new DatabaseConnection();
	}
	
}
